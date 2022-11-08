package junit5;

public class ValidarNumero {


    public ValidarNumero() {
    }

    public Boolean verificar(Object o) {
        if(o instanceof Integer) {
            return (Integer) o >= 0 && (Integer) o < 10;
        }
        return false;
    }
}
