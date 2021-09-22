package com.app.passwordvalidation.service;


import com.app.passwordvalidation.domain.entity.PwdStatus;
import com.app.passwordvalidation.domain.enumeration.Criterios;
import com.app.passwordvalidation.domain.mapper.PwdRegraMapper;
import com.app.passwordvalidation.resources.entity.PwdDTO;
import org.springframework.stereotype.Service;

@Service
public class PwdValidationService {

    public PwdStatus validarPwd(PwdDTO pwdDTO) {
        String pwd = pwdDTO.getPwd();

        boolean pwdValido = PwdRegraMapper.valido(pwd,
                Criterios.CARACTER_BRANCO,
                Criterios.CARACTER_ESPECIAL,
                Criterios.CARACTER_REPETIDO,
                Criterios.LETRA_MAIUSCULA,
                Criterios.LETRA_MINUSCULA,
                Criterios.NOVE_CARACTER);

        return PwdStatus.builder()
                .valido(pwdValido)
                .build();
    }


}
