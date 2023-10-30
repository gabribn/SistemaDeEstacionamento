package trabalhofinalPOO2;

public class Vaga {
    private int numeroVaga;
    private boolean ocupada;

    public Vaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
        this.ocupada = false;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void desocupar() {
        ocupada = false;
    }

	public int getNumeroVaga() {
		return numeroVaga;
	}
}