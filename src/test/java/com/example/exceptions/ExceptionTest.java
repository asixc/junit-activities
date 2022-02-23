package com.example.exceptions;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    @DisplayName("Funcionamiento correcto")
    void findOneTest() throws Exception {
        SmartPhone smartPhone1 = service.findOne(1L);
        assertAll(
                () -> assertEquals(1L, smartPhone1.getId()),
                () -> assertNotNull(smartPhone1.getCamera())
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
        assertNull( service.findOne(999L));
    }

}
