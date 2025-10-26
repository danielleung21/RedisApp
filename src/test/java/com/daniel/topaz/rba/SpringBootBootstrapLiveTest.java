package com.daniel.topaz.rba;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootBootstrapLiveTest {

    @LocalServerPort
    private int port;
    private String API_PATH;

    @BeforeEach
    public void setUp() {
        API_PATH = "http://localhost:" + port + "/run-batch/{batchId}";
        RestAssured.port = port;
    }

    @Test
    public void whenRunBatchById_thenOk() {
        //given
        String batchId = "HSIOPT";

        //when
        Response response = RestAssured.post(API_PATH,batchId);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void whenRunNotExistBatchById_thenNotFound() {
        //given
        final String batchId = "HSIFUT";

        //when
        Response response = RestAssured.post(API_PATH,batchId);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getBody().asString()).isEqualTo("Batch not found, batchId=" + batchId);
    }

}
