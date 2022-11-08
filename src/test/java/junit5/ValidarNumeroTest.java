package junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidarNumeroTest {

    private ValidarNumero validarNumero;

    @BeforeEach
    public void setUp() {
        validarNumero = new ValidarNumero();
    }

    @AfterEach
    public void tearDown() {
        validarNumero = null;
    }

    @Test
    void verificarTest() {
        assertEquals(true, validarNumero.verificar(5));
    }

    @Test
    void verificarNegativoTest() {
        assertEquals(false, validarNumero.verificar(-5));
    }

    @Test
    void verificarCadenaTest() {
        assertEquals(false, validarNumero.verificar("5"));
    }
}