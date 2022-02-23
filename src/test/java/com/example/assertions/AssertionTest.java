package com.example.assertions;

import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    void countAssertAllTest() {
        Integer count = service.count();

        assertAll(
                () -> assertTrue(count > 0),
                () -> assertEquals(3, count),
                () -> assertEquals(3, count, "No hay 3 smartphones por defecto")
        );

    }
}
