package trabalhofinalPOO2;

public class Carro{
    private String placa;
    private String modelo;
	private String dataEntrada;
	private int numVagas;
	
	
    public Carro(String placa, String modelo, String dataEntrada, int numVagas) {
        this.placa = placa;
        this.modelo = modelo;
        this.dataEntrada = dataEntrada;
        this.numVagas = numVagas;
    }
    
    public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public int getNumVagas() {
		return numVagas;
	}
}
