package com.app.passwordvalidation.resources.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


public class PwdDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pwd;

    public PwdDTO(){
    }

    public PwdDTO(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isInvalidInput() {
        return Objects.isNull(this.pwd);
    }
}
