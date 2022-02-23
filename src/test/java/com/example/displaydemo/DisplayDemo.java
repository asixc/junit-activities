package com.example.displaydemo;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Funcionalidad CRUD smartphones")
public class DisplayDemo {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    @DisplayName("Por defecto hay 3 smartphones")
    void countAssertAllTest() {
        Integer count = service.count();

        assertAll(
                () -> assertTrue(count > 0),
                () -> assertEquals(3, count),
                () -> assertEquals(3, count, "No hay 3 smartphones por defecto como se espera")
        );

    }

    @Test
    @DisplayName("Al agregar un nuevo smartphone se incrementa el número total de smartphones")
    void countIncrementsTest() {
        Integer count = service.count();

        assertAll(
                () -> assertEquals(3, count),
                () -> {
                    service.save(new SmartPhone());
                    Integer incrementedCount = service.count();
                    assertEquals(4, incrementedCount);
                }
        );

    }
}
