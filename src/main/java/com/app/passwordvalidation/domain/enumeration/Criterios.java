package com.app.passwordvalidation.domain.enumeration;

import com.app.passwordvalidation.domain.interfaces.PwdRegrasInterface;
import com.app.passwordvalidation.domain.regras.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Criterios {

    LETRA_MAIUSCULA(new ValidacaoLetraMaiuscula()),

    CARACTER_BRANCO(new ValidacaoCaracterBranco()),

    CARACTER_ESPECIAL(new ValidacaoCaracterEspecial()),

    CARACTER_REPETIDO(new ValidacaoCaracterRepetido()),

    NOVE_CARACTER(new ValidacaoNoveCaracteres()),

    LETRA_MINUSCULA(new ValidacaoLetraMinuscula());

    private final PwdRegrasInterface pwdRegrasInterface;


}
