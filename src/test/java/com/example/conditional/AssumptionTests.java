package com.example.conditional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTests {

    @Test
    void test1() {
        var envs = System.getenv();
        final String jdk = System.getenv("java.home");
        assumeTrue(jdk.contains("jdk-17"));

        System.out.println("Test1 assumpt"); // No se ejcuta si no se cumple el assume

    }

    @Test
    void test2() {
        var envs = System.getenv();
        final String jdk = System.getenv("java.home");
        assumingThat(jdk.contains("jdk-16"),
                () -> System.out.println("Se cumple")); //Si no se cumple no pintará nada es un if encapsulado

        System.out.println("Test1 assumpt"); // Se ejecutará siempre

    }
}
