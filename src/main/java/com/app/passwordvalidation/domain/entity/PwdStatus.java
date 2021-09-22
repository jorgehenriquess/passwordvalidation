package com.app.passwordvalidation.domain.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PwdStatus {

    private boolean valido;
}
