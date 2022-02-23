package com.example.repeated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class RepeatedDemoTest {


    @Test
    void test1() {

        System.out.println("test1");
    }

    @RepeatedTest(value = 3, name = "Ejecución {currentRepetition}/{totalRepetitions}")
    void test2() {

        System.out.println("test2");
    }

    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Insertar Smartphone")
    void test3() {

        System.out.println("test3");
    }

    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Insertar Smartphone")
    void test4(RepetitionInfo info) {
        System.out.println("getCurrentRepetition: " + info.getCurrentRepetition());
        System.out.println("getTotalRepetitions: " + info.getTotalRepetitions());
        System.out.println("test4");
    }

}
