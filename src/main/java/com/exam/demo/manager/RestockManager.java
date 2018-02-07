package com.exam.demo.manager;

import com.exam.demo.behavior.RestockBehavior;
import com.exam.demo.config.DeleteState;
import com.exam.demo.entity.restock.RestockDetailEntity;
import com.exam.demo.entity.restock.RestockEntity;
import com.exam.demo.model.restock.RestockDTO;
import com.exam.demo.model.restock.RestockDetailDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
public class RestockManager {

    @Resource
    private RestockBehavior restockBehavior;

    public RestockEntity saveOrUpdate(RestockDTO restockDTO) {
        RestockEntity restockEntity = new RestockEntity();

        //Dto copy 只复制了少量对象
        BeanUtils.copyProperties(restockDTO , restockEntity);

        //Dto copy 复制set中的对象
        Set<RestockDetailEntity> restockDetailEntities = new HashSet<>();

        for(RestockDetailDTO detail : restockDTO.getRestockDetailDTOS()){
            RestockDetailEntity  restockDetailEntity = new RestockDetailEntity();
            BeanUtils.copyProperties(detail, restockDetailEntities);
            restockDetailEntities.add(restockDetailEntity);
        }
        restockEntity.setRestockDetailEntities(restockDetailEntities);

        //初始化设置 非前台传入  与业务无关
        restockEntity.setBillCode("00000000");
        restockEntity.setDeleteState(DeleteState.NOT_DELETED);



        //初始化设置 非前台传入 与业务相关 可以放入业务行为中
        //restockEntity.setBillPurpose(BillPurpose.IN_STORAGE);可以更改为下边一行
        restockEntity = this.restockBehavior.setDomainField(restockEntity);

        //委托给基础设施保存
        restockEntity = this.restockBehavior.saveNoFlush(restockEntity);
        //方便以后扩展
        this.restockBehavior.sendEntityByEvent(restockEntity);
        //可以看到 上述代码重复了三遍，聚合到一起

        restockEntity = restockBehavior.firstUnion(restockEntity);

        return restockEntity;
    }
}
