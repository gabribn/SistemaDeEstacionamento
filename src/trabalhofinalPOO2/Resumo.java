package trabalhofinalPOO2;

public class Resumo {
	private int numCarros;
	private double arrecadacao;
	
	public Resumo(int carros, float arrecadacao) {
		this.numCarros = carros;
		this.arrecadacao = arrecadacao;
	}
	
	public int getCarros() {
		return numCarros;
	}
	
	public double getArrecadacao() {
		return arrecadacao;
	}

	public void atualizar(double taxa) {
        numCarros ++;
        arrecadacao += taxa;
    }

	@Override
    public String toString() {
        return "Carros que foram estacionados = " + numCarros + ", arrecadação total = " + arrecadacao + "\n";
    }
}
