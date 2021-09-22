package com.app.passwordvalidation.domain.regras;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoNoveCaracteres implements PwdRegrasInterface {
    @Override
    public boolean validar(String password) {

        final String noveCaracteresRegex = "^(?=^.{9,}).*$";

        return password.matches(noveCaracteresRegex);

    }
}
