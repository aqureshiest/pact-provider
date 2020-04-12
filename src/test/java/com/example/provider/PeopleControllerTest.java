package com.example.provider;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleControllerTest {

    @Autowired
    TestRestTemplate server;

    @Test
    public void get_all_people() {
        String response = server.getForObject("http://localhost:8081/people", String.class);
        Assertions.assertThat(response).isNotEmpty();
        // verify other properties
    }

    @Test
    public void person_by_id() {
        String response = server.getForObject("http://localhost:8081/people/1", String.class);
        Assertions.assertThat(response).isNotEmpty();
    }
}