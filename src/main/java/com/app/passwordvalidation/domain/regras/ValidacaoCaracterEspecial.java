package com.app.passwordvalidation.domain.regras;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;

public class ValidacaoCaracterEspecial implements PwdRegrasInterface {


    @Override
    public boolean validar(String pwd) {

        final String validacaoCaracterEspecial = "^(?=.*[!|@|#|$|%|^|&|*|(|)|\\-|+]).*$";

        return pwd.matches(validacaoCaracterEspecial);

    }
}
