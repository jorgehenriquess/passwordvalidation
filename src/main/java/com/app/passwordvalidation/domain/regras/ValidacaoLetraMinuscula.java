package com.app.passwordvalidation.domain.regras;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;

public class ValidacaoLetraMinuscula implements PwdRegrasInterface {
    @Override
    public boolean validar(String password) {

        final String validacaoLetraMinusculaRegex = "^(?=.*[a-z]).*$";

        return password.matches(validacaoLetraMinusculaRegex);

    }
}
