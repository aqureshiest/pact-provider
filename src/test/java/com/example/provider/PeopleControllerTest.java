package com.example.provider;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void all_people() {
        String response = restTemplate.getForObject("http://localhost:8081/people", String.class);
        Assertions.assertThat(response).isNotEmpty();
    }

    @Test
    public void person_by_id() {
        String response = restTemplate.getForObject("http://localhost:8081/people/1", String.class);
        Assertions.assertThat(response).isNotEmpty();
    }
}