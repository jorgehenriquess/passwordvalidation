package com.app.passwordvalidation.application.service;

import com.app.passwordvalidation.domain.entity.PwdStatus;
import com.app.passwordvalidation.resources.entity.PwdDTO;
import com.app.passwordvalidation.service.PwdValidationService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
class ServiceTest {

    @Autowired
    PwdValidationService pwdValidationService;

    static Stream<Arguments> pwdDataProvider() {
        return Stream.of(
                arguments("", false),
                arguments("aa", false),
                arguments("ab", false),
                arguments("AAAbbbCc", false),
                arguments("AbTp9!foo", false),
                arguments("AbTp9!foA", false),
                arguments("AbTp9 fok", false),
                arguments("AbTp9!fok", true)
        );
    }

    @ParameterizedTest
    @MethodSource("pwdDataProvider")
    void validaPwdTstService(String pwd, boolean output) {
        PwdDTO pwDTO = new PwdDTO();
        pwDTO.setPwd(pwd);

        PwdStatus result = pwdValidationService.validarPwd(pwDTO);

        Assert.assertEquals(result.isValido(), output);
    }

}
