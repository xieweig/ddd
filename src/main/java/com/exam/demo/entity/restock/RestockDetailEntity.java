package com.exam.demo.entity.restock;

import com.exam.demo.config.DetailType;



public class RestockDetailEntity {

    public String getCargoCode() {
        return cargoCode;
    }

    public void setCargoCode(String cargoCode) {
        this.cargoCode = cargoCode;
    }

    public DetailType getDetailType() {
        return detailType;
    }

    public void setDetailType(DetailType detailType) {
        this.detailType = detailType;
    }

    private String cargoCode;

    private DetailType detailType;
}
