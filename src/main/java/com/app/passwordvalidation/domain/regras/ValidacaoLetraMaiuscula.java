package com.app.passwordvalidation.domain.regras;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;

public class ValidacaoLetraMaiuscula implements PwdRegrasInterface {
    @Override
    public boolean validar(String password) {

        final String validacaoLetraMaiusculaRegex = "^(?=.*[A-Z]).*$";

        return password.matches(validacaoLetraMaiusculaRegex);

    }
}
