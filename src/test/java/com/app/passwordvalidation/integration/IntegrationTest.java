package com.app.passwordvalidation.integration;

import com.app.passwordvalidation.PasswordvalidationApplication;
import com.app.passwordvalidation.resources.entity.PwdDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import java.util.stream.Stream;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest(classes = PasswordvalidationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private int port;

    static Stream<Arguments> validatePwd() {
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
    @MethodSource("validatePwd")
    void validaPwdTest(String pwd, boolean output) {
        PwdDTO passwordDTO = new PwdDTO();
        passwordDTO.setPwd(pwd);

        given()
                .port(port)
                .body(passwordDTO)
                .contentType("application/JSON")
                .when()
                .post("/v1/pwd/validate")
                .then()
                .statusCode(200)
                .body("valido", equalTo(output));
    }



}
