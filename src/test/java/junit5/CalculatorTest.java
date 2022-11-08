package junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("@BeforeEach->setUp()");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("AfterEach-> tearDown");
    }

    @Test
    public void calculatorNoNullTest() {
        Assertions.assertNotNull(calculator, "Calculator debe ser no null");
        System.out.println("Test->calculatorNoNullTest()");
    }

    @Test
    public void calculatorNullTest() {
        Assertions.assertNull(calculatorNull);
        System.out.println("Test->calculatorNull()");
    }


    @Test
    public void calculatorSumarTest() {

        int resultadoEsperado = 11;
        int respuestaActual = calculator.sumar(5, 6);
        Assertions.assertEquals(resultadoEsperado, respuestaActual);
        System.out.println("Test->calculatorSumar()");
    }

    @Test
    public void calculatorRestarTest() {

        int resultadoEsperado = 5;
        int respuestaActual = calculator.restar(16, 11);
        Assertions.assertEquals(resultadoEsperado, respuestaActual);
        System.out.println("Test->calculatorRestar()");
    }

    @Disabled("Desabilitado por bug 3")
    @Test
    public void calculatorDividirPorCeroTest() {
        int respuestaActual = calculator.dividir(5, 0);
        Assertions.assertEquals(2, respuestaActual);
        System.out.println("Test->calculatorDividirPorCero()");
    }


    @Test
    @DisplayName("Funciona dividir")
    public void calculatorDividirTest() {
        int respuestaActual = calculator.dividir(6, 2);
        Assertions.assertEquals(3, respuestaActual);
        System.out.println("Test->calculatorDividirPorCero()");
    }

    @Test
    public void sumarAssertAllTest() {
        Assertions.assertAll(() -> Assertions.assertEquals(4, calculator.sumar(1, 3)), () -> Assertions.assertEquals(7, calculator.sumar(5, 2)), () -> Assertions.assertEquals(35, calculator.sumar(15, 20)));
    }

    @Nested
    class SumarTest {
        @Test
        public void sumarPositivosTest() {
            Assertions.assertEquals(11, calculator.sumar(5, 6));
        }

        @Test
        public void sumarNegativosTest() {
            Assertions.assertEquals(-30, calculator.sumar(-15, -15));
        }

        @Test
        public void sumarCeroTest() {
            Assertions.assertEquals(0, calculator.sumar(0, 0));
        }
    }

    @ParameterizedTest(name = "{index} => a={0}, b={2}, suma={2}")
    @MethodSource("sumarProveerDatos")
    public void sumarParametrizadosTest(int a, int b, int suma) {
        Assertions.assertEquals(suma, calculator.sumar(a, b));
    }

    public static Stream<Arguments> sumarProveerDatos() {

        return Stream.of(Arguments.of(6, 7, 13), Arguments.of(5, 8, 13), Arguments.of(0, 5, 5));
    }

    @Test
    public void timeOut() {
        Assertions.assertTimeout(Duration.ofMillis(10000), () -> {
            calculator.longOperation();
        });
    }

}