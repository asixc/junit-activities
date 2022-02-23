package com.example.nested;

import com.example.demo.domain.SmartPhone;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CPU;
import com.example.demo.domain.pieces.Camera;
import com.example.demo.domain.pieces.RAM;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


@DisplayName("Operaciones CRUD SmartPhone")
public class NestedTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();


    @Nested
    @DisplayName("Recuperar")
    class Retrieve {
        @Test
        void countTest() {
            Integer count = service.count();
            assertTrue(count > 0);
            assertEquals(3, count);
            assertEquals(3, count, "No hay 3 smartphones por defecto como se espera");
        }

        @Test
        void findOne1Test() {
            Optional<SmartPhone> smartPhoneOptional = service.findOne(1L);
            assertTrue(smartPhoneOptional.isPresent());

            SmartPhone smartPhone = smartPhoneOptional.get();
            assertAll(
                    () -> assertEquals(1L, smartPhone.getId()),
                    () -> assertNotNull(smartPhone.getCamera())
            );
        }

        @Test
        @DisplayName("Se lanza una excepción cuando se busca un smartphone nulo")
        void findOneExceptionTest() {
            assertThrows(IllegalArgumentException.class, () -> service.findOne(null));
        }

        @Test
        void findOneNotExistsTest() {
            Optional<SmartPhone> smartPhoneOptional = service.findOne(999L);
            assertTrue(smartPhoneOptional.isEmpty());
        }

        @Test
        void findAllTest() {
            List<SmartPhone> smartphones = service.findAll();
            assertNotNull(smartphones);
            assertFalse(smartphones.isEmpty());
            assertEquals(3, smartphones.size());
        }

        @Test
        void findByWifiTrueTest() {
            List<SmartPhone> smartphones = service.findByWifi(true);
            assertEquals(2, smartphones.size());
            smartphones.forEach(s -> assertTrue(s.getWifi()));
        }


        @Test
        void findByWifiFalseTest() {
            List<SmartPhone> smartphones = service.findByWifi(false);
            assertEquals(1, smartphones.size());
            smartphones.forEach(s -> assertFalse(s.getWifi()));
        }
    }

    @Nested
    @DisplayName("Creación")
    class Create {

        @Test
        void saveNullTest() {
            assertThrows(IllegalArgumentException.class,
                    () -> service.save(null));

        }

        @Test
        void saveIdNullTest() {
            SmartPhone phone4 = new SmartPhone(null, "JUnit smartphone",
                    new RAM(4L, "DDR5", 32),
                    new Battery(4L, 9500.0),
                    new CPU(4L, 16),
                    true,
                    new Camera(4L, "back camera", 58.5));

            SmartPhone savedPhone4 = service.save(phone4);
            assertNotNull(savedPhone4);
            assertEquals(4L, savedPhone4.getId());
        }

        @Test
        void saveIdZeroTest() {
            SmartPhone phone4 = new SmartPhone(0L, "JUnit smartphone",
                    new RAM(4L, "DDR5", 32),
                    new Battery(4L, 9500.0),
                    new CPU(4L, 16),
                    true,
                    new Camera(4L, "back camera", 58.5));

            SmartPhone savedPhone4 = service.save(phone4);
            assertNotNull(savedPhone4);
            assertEquals(4L, savedPhone4.getId());
        }

        @Test
        void saveInEmptyMapTest() {
            service.deleteAll();

            SmartPhone phone1 = new SmartPhone(0L, "JUnit smartphone",
                    new RAM(4L, "DDR5", 32),
                    new Battery(4L, 9500.0),
                    new CPU(4L, 16),
                    true,
                    new Camera(4L, "back camera", 58.5));

            SmartPhone savedPhone1 = service.save(phone1);
            assertNotNull(savedPhone1);
            assertEquals(1L, savedPhone1.getId());
        }

        @Test
        void updateTest() {
            SmartPhone phone1 = new SmartPhone(1L, "Editado",
                    new RAM(1L, "DDR4", 8),
                    new Battery(1L, 4500.0),
                    new CPU(1L, 4),
                    false,
                    new Camera(1L, "front camera", 12.5));
            SmartPhone updatedPhone1 = service.save(phone1);
            assertNotNull(updatedPhone1);
            assertEquals(1L, updatedPhone1.getId());
            assertEquals("Editado", updatedPhone1.getName());
        }


    }

    @Nested
    @DisplayName("Borrado")
    class Delete {

        @Test
        void deleteIdNullTest() {
            assertEquals(3, service.count());
            assertFalse(service.delete(null));
            assertEquals(3, service.count());
        }

        @Test
        void deleteIdNotExistsTest() {
            assertEquals(3, service.count());
            assertFalse(service.delete(999L));
            assertEquals(3, service.count());
        }

        @Test
        void deleteOkTest() {
            assertEquals(3, service.count());
            assertTrue(service.delete(1L));
            assertEquals(2, service.count());

            assertFalse(service.delete(1L));
            assertEquals(2, service.count());
        }

        @Test
        void deleteAllOkTest() {
            assertEquals(3, service.count());
            service.deleteAll();
            assertEquals(0, service.count());

            service.deleteAll(); // no hace clear porque ya está vacío
            assertEquals(0, service.count());
        }
    }
}
