package com.example.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


/*
org.junit.jupiter.api.condition proporciona anotaciones para ejecutar los test condicionalmente en base a:
JRE, OS, variables entorno, propiedades de sistema

 */
public class ConditionalTest {

    @Test
    void test1() {
        System.getenv().forEach((k,v) -> System.out.println("K: " + k + ", " + v));

        System.out.println("----------");
        System.getProperties().forEach((k,v) -> System.out.println("K: " + k + ", " + v));
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testJava11() {
        System.out.println("Test with Java 11");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testJava8() {
        System.out.println("Test with Java 8");
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_11)
    void testJava8To11() {
        System.out.println("Test with Java FROM JAVA 8 to JAVA 11");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testJava17() {
        System.out.println("Test with Java 17");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForOsLinux() {
        System.out.println("Test only for linux system");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForOsWindows() {
        System.out.println("Test only for windows system");
    }

    @Test
    @EnabledIfSystemProperty(named ="user.language", matches = "es")
    void testForPropertySystemSpanish() {
        System.out.println("Test only for user.language ES");
    }

    @Test
    @EnabledIfSystemProperty(named ="user.language", matches = "en")
    void testForPropertySystemEnglish() {
        System.out.println("Test only for user.language EN");
    }

    @Test
    @EnabledIf("isEncryptionSupported")
    void testWithCustomConditional() {
        System.out.println("Custom conditional test is executed");
    }

    /*
    Utilizamos nuestras propias condiciones cuando no nos alcanza con las que hay por defecto: JRE, OS, variables entorno, propiedades de sistema
     */
    private boolean isEncryptionSupported() {
        return true;
    }

}
