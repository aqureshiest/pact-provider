package com.example.provider;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int port;

    @Test
    public void all_people() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/people", String.class);
        Assertions.assertThat(response).isNotEmpty();
    }
}