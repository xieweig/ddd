package com.exam.demo.application.restock;

import com.exam.demo.manager.RestockManager;
import com.exam.demo.model.restock.RestockDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/restock")
public class RestockController {

    @Resource
    private RestockManager restockManager;
    @RequestMapping("/save")
    public String saveBySomething(@RequestBody RestockDTO restockDTO){
        //绑定完毕，依次可能进行的事情
        //权限验证
        if (restockDTO.getToken()!="restock_user")
            //throw new RuntimeException("any reason");
            return "rights_failed";
        //后端约束
        if (restockDTO.getRemarks()==null || restockDTO.getRemarks()=="")
            return "field_failed";
        //解析DTO

         this.restockManager.saveOrUpdate(restockDTO);


        return "success";
    }
//
//    @RequestMapping("/findByConditions")
//    public RestockDTO find
}
