package junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AddCreateMock2Test {

    @InjectMocks
    private Add add;

    @Mock
    private ValidarNumero validarNumero;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addTest() {
        add.add(3,2);
        Mockito.verify(validarNumero).verificar(3);
    }
}