package com.app.passwordvalidation.resources.controller;


import com.app.passwordvalidation.domain.entity.PwdStatus;
import com.app.passwordvalidation.resources.entity.PwdDTO;
import com.app.passwordvalidation.service.PwdValidationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/pwd")
public class PwdValidationController {

    @Autowired
    PwdValidationService pwdValidationService;

    @PostMapping(value = "/validate")
    public ResponseEntity<PwdStatus> validatePassword(@NonNull @RequestBody PwdDTO pwdDTO) {

        if (pwdDTO.isInvalidInput()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(pwdValidationService.validarPwd(pwdDTO));


    }


}
