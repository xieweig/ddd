package com.exam.demo.model.restock;

import com.exam.demo.config.DeleteState;

import java.util.List;
import java.util.Set;

public class RestockDTO {

    //一般性的前台传入的业务字段
    private String remarks;

    //关联另外一张表的内容也就是多个实体组成一个实体  前台的这个可以完全平面化
    private Set<RestockDetailDTO> restockDetailDTOS;

    //与业务可能有关（也可能无关） 初次保存时候无 之后更新时候有 业务主键
    private String billCode;

    //与业务无关 可能是前台传入 用于逻辑删除
    private DeleteState deleteState;

    //特有字段 例如权限验证
    private String Token;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Set<RestockDetailDTO> getRestockDetailDTOS() {
        return restockDetailDTOS;
    }

    public void setRestockDetailDTOS(Set<RestockDetailDTO> restockDetailDTOS) {
        this.restockDetailDTOS = restockDetailDTOS;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public DeleteState getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(DeleteState deleteState) {
        this.deleteState = deleteState;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
