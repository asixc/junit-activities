package com.example.exceptions;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    @DisplayName("Funcionamiento correcto")
    void findOneTest() throws Exception {
        // SmartPhone smartPhone1 = service.findOne(1L); Last
        // service.findOne(1L).ifPresent(SmartDevice::getId);
        // Lambda:
        assertAll(
                () -> assertTrue(service.findOne(1L).isPresent()),
                () -> service.findOne(1L).ifPresent(smartPhone -> assertEquals(1L, smartPhone.getId())),
                () -> assertTrue(service.findOne(1L).map(smartPhone -> smartPhone.getCamera()).isPresent())
        );

        // Forma clásica pero más legible:
        Optional<SmartPhone> smartPhoneOptional = service.findOne(1L);
        assertTrue(smartPhoneOptional.isPresent());

        SmartPhone smartphone = smartPhoneOptional.get();
        assertAll(
                () -> assertEquals(1L, smartphone.getId()),
                () -> assertNotNull(smartphone)
        );

    }

    @Test
    @DisplayName("Cuando se buscar por un null nos devuelve la excepcion esperada")
    void findOneTestThrowException()  {
        assertThrows(IllegalArgumentException.class, () -> service.findOne(null));
    }


    @Test
    @DisplayName("Cuando se buscar por un ID que no existe")
    void findOneTestIdNotExistReturnNull()  {
       // assertNull( service.findOne(999L)); Last
        Optional<SmartPhone> smartPhone = service.findOne(999L);
        assertTrue(smartPhone.isEmpty());
    }

}
