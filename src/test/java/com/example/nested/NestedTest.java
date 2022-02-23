package com.example.nested;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;





//@DisplayName("SmartPhone CRUD")
public class NestedTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Nested
    @DisplayName("Recuperar")
    class Retrieve {
        @Test
        void countTest(){
            Integer count = service.count();

            assertTrue(count > 0);
            assertEquals(3, count);

        }
    }

    @Nested
    @DisplayName("Crear")
    class Create {
        @Test
        void countTest(){
            Integer count = service.count();
        }
    }

    @Nested
    @DisplayName("Actualizar")
    class Update {
        @Test
        void countTest(){
            Integer count = service.count();
        }
    }

    @Nested
    @DisplayName("Borrar")
    class Delete {
        @Test
        void countTest(){
            Integer count = service.count();
        }
    }
}
