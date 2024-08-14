package com.mycompany.property_management.exception;

import java.util.List;

public class BusinessException extends RuntimeException {

    private List<ErrorModel> errorModel;

    public BusinessException(List<ErrorModel> errorModel) {
        this.errorModel = errorModel;
    }

    public List<ErrorModel> getErrorModel() {
        return errorModel;
    }

    public void setErrorModel(List<ErrorModel> errorModel) {
        this.errorModel = errorModel;
    }
}
