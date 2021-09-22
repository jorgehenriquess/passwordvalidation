package com.app.passwordvalidation.domain.regras;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;

public class ValidacaoCaracterRepetido implements PwdRegrasInterface {
    @Override
    public boolean validar(String password) {

        final String validacaoCaracterRepetido = "^(?!.*(.).*\\1).*$";

        return password.matches(validacaoCaracterRepetido);

    }
}
