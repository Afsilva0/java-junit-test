package junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions.*;

class AddCreateMockTest {

    private Add add;
    private ValidarNumero validarNumero;

    @BeforeEach
    void setUp() {
        validarNumero= Mockito.mock(ValidarNumero.class);
        add = new Add(validarNumero);
    }

    @AfterEach
    void tearDown() {
        add = null;
    }

    @Test
    void addTest() {
        add.add(3,2);
        Mockito.verify(validarNumero).verificar(3);
    }
}