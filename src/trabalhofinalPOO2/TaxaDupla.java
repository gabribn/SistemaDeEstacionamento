package trabalhofinalPOO2;

public class TaxaDupla implements CalculadoraTaxa {
    @Override
    public double calcularTaxa(int diasEstacionado) {
        return diasEstacionado * 20.0;
    }
}
