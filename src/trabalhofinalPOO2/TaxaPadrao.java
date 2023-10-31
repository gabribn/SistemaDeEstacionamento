package trabalhofinalPOO2;

public class TaxaPadrao implements CalculadoraTaxa {
    @Override
    public double calcularTaxa(int diasEstacionado, int numVagas) {
        return diasEstacionado * 10.0;
    }
}
