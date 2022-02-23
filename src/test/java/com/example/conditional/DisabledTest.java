package com.example.conditional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled // este Disabled funciona cuando se ejecuta desde maven
public class DisabledTest {

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    @Disabled
    void test2() {
        System.out.println("test1");
    }

    @Test
    @Disabled("Deshabilitado hasta corrección de bug #977")
    void test3() {
        System.out.println("test3");
    }
}
