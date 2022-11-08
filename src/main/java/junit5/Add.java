package junit5;

public class Add {
    private ValidarNumero validarNumero;

    public Add(ValidarNumero validarNumero) {
        this.validarNumero = validarNumero;
    }

    public int add(Object a,Object b){
        if(validarNumero.verificar(a) && validarNumero.verificar(b)){
            return (Integer)a + (Integer)b;
        }
        return 0;
    }

}
