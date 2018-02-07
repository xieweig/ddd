package com.exam.demo.entity.restock;



import com.exam.demo.config.BillPurpose;
import com.exam.demo.config.DeleteState;
import com.exam.demo.entity.base.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
public class RestockEntity extends BaseEntity {

    //前台传入的业务字段必须有
    private String remarks;

    //前台传入字段 关联另外一张表的内容也就是多个实体组成一个实体 必须有
    private Set<RestockDetailEntity> restockDetailEntities;

    //与业务可能有关（也可能无关） 初次保存时候无 之后更新时候有 业务主键
    private String billCode;

    //与业务无关 可能是前台传入 用于逻辑删除
    private DeleteState deleteState;

    //与业务有关 不是前台传入信息
    private BillPurpose billPurpose;

    //与业务无关 不是前台传入信息 entity中有
    private Date lastSaveTime;



    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Set<RestockDetailEntity> getRestockDetailEntities() {
        return restockDetailEntities;
    }

    public void setRestockDetailEntities(Set<RestockDetailEntity> restockDetailEntities) {
        this.restockDetailEntities = restockDetailEntities;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public BillPurpose getBillPurpose() {
        return billPurpose;
    }

    public void setBillPurpose(BillPurpose billPurpose) {
        this.billPurpose = billPurpose;
    }

    public Date getLastSaveTime() {
        return lastSaveTime;
    }

    public void setLastSaveTime(Date lastSaveTime) {
        this.lastSaveTime = lastSaveTime;
    }

    public DeleteState getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(DeleteState deleteState) {
        this.deleteState = deleteState;
    }



}
