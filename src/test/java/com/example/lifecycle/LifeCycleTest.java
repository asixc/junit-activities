package com.example.lifecycle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    @BeforeEach
    void setup() {
        System.out.println("Se inicia setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("se ejecuta tearDown");
    }
    @Test
    void test1(){
        System.out.println("Test1");
    }

    @Test
    void test2(){
        System.out.println("Test2");
    }
}
