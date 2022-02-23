package com.example.lifecycle;

import org.junit.jupiter.api.*;

public class LifeCycleTest {

    @BeforeEach
    void setup() {
        System.out.println("Se inicia setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("se ejecuta tearDown");
    }

    @BeforeAll
    static void beforAll(){
        System.out.println("Inicio test lifeCycle");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Fin de los tests");
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
