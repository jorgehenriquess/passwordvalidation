package com.app.passwordvalidation.domain.regras;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;

public class ValidacaoCaracterBranco implements PwdRegrasInterface {
    @Override
    public boolean validar(String password) {

        final String validacaoCaracterBranco = "^(?!.*\\h).*$";

        return password.matches(validacaoCaracterBranco);

    }
}
