package com.exam.demo.model.restock;

import com.exam.demo.config.DetailType;

public class RestockDetailDTO {
    private String cargoCode;

    private DetailType detailType;

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
}
