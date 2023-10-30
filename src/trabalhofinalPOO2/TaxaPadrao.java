package trabalhofinalPOO2;

public class TaxaPadrao implements CalculadoraTaxa {
    @Override
    public double calcularTaxa(int diasEstacionado) {
        return diasEstacionado * 10.0;
    }
}
