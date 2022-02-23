package com.example.DisplayDemo;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayDemo {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    @DisplayName("Al agregar un nuevo smartphone se incrementa el número total de smartphones")
    void countAssertAllTest() {
        Integer count = service.count();

        assertAll(
                () -> assertEquals(3, count, "No hay 3 smartphones por defecto"),
                () -> {
                    service.save(new SmartPhone());
                    Integer incrementedCount = service.count();
                    assertEquals(4, incrementedCount);
                }
        );

    }
}
