package trabalhofinalPOO2;

public class TaxaDupla implements CalculadoraTaxa {
    @Override
    public double calcularTaxa(int diasEstacionado, int numVagas) {
        return numVagas == 2 ? diasEstacionado * 20.0 : diasEstacionado * 10.0;
    }
}
