package com.example.provider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Provider("provider")
@PactFolder("../consumer/target/pacts")
@RunWith(SpringRestPactRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProviderContractVerificationTest {

    @TestTarget
    public final Target target = new SpringBootHttpTarget();


    @State("has people")
    public void contextLoads() {
    }

    @State("test user exists")
    public void createTestUser() {
		controller.people().add(new Person(0, "test", "user", 30, null));
    }

    @Autowired
	PeopleController controller;
}
