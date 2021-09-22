package com.app.passwordvalidation.domain.mapper;

import com.app.passwordvalidation.domain.enumeration.Criterios;

public class PwdRegraMapper {

    public static boolean valido(String pwd, Criterios... criterios) {

        for (Criterios criterio : criterios) {
            boolean pwdInvalido = !criterio.getPwdRegrasInterface().validar(pwd);

            if (pwdInvalido) {
                return false;
            }
        }
        return true;
    }
}
