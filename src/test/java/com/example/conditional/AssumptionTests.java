package com.example.conditional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTests {

    @Test
    void test1() {
        String jdk = System.getenv("JAVA_HOME");
        assumeTrue(jdk.contains("jdk-16"));
        System.out.println("test1 asserts"); // no se ejecuta si no se cumple el assume
    }

    @Test
    void test2() {
        String jdk = System.getenv("JAVA_HOME");

        assumingThat(jdk.contains("jdk-16"),
                () -> System.out.println("assume")); // si se cumple no lo ejecuta pero sigue adelante

        assumingThat(jdk.contains("jdk-17"),
                () -> System.out.println("jdk-17 correcto")); // si se cumple

        System.out.println("test2 asserts"); // si se ejecuta independientemente de si se cumple el assume
    }
}
