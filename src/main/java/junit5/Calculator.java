package junit5;

public class Calculator {


    private int resultado;

    public int sumar(int n1, int n2) {
        resultado = n1 + n2;
        return resultado;
    }


    public int restar(int n1, int n2) {
        resultado = n1 - n2;
        return resultado;
    }

    public int dividir(int n1, int n2) {
        resultado = n1 / n2;
        return resultado;
    }

    public void longOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
