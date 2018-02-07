package com.exam.demo.behavior;

import com.exam.demo.config.BillPurpose;
import com.exam.demo.entity.restock.RestockEntity;
import com.exam.demo.repository.CommonRepo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RestockBehavior {
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    @Resource
    private CommonRepo<RestockEntity> commonRepo;
    //保存与业务无关 使用基础设施里的方法
    public RestockEntity saveNoFlush(RestockEntity restockEntity){
        RestockEntity restockEntityBack =this.commonRepo.save(restockEntity);

        System.out.print("id :"+restockEntityBack.getId());
        return  restockEntityBack;

    }
    //为了将来扩展和业务逻辑有关的回调函数
    public void sendEntityByEvent(RestockEntity restockEntity){
        applicationEventPublisher.publishEvent(restockEntity);
    }

    public RestockEntity setDomainField(RestockEntity restockEntity) {
        restockEntity.setBillPurpose(BillPurpose.OUT_STORAGR);
        return restockEntity;
    }

    public RestockEntity firstUnion(RestockEntity restockEntity){
        this.sendEntityByEvent(this.saveNoFlush(this.setDomainField(restockEntity)));
    }
}
