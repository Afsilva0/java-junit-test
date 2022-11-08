package junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    @InjectMocks
    private Add add;


    @Mock
    private ValidarNumero validarNumero;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void addTest() {
        Mockito.when(validarNumero.verificar(3)).thenReturn(false);

        boolean  verificarNumero= validarNumero.verificar(3);

        Assertions.assertEquals(false,verificarNumero);
    }
}