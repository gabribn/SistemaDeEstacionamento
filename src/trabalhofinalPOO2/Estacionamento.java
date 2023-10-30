package trabalhofinalPOO2;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private static Estacionamento instancia;
    private List<Carro> carrosEstacionados;
    private int capacidadeMaxima;

    private Estacionamento() {
        carrosEstacionados = new ArrayList<>();
        capacidadeMaxima = 100; 
    }

    public static Estacionamento getInstancia() {
        if (instancia == null) {
            instancia = new Estacionamento();
        }
        return instancia;
    }

    public void adicionarCarro(Carro carro) {
        if (carrosEstacionados.size() < capacidadeMaxima) {
            carrosEstacionados.add(carro);
        } else {
            System.out.println("Estacionamento lotado.");
        }
    }
    
    public void removeCarro(String placa) {
        FachadaSaida estacionamentoFacade = new FachadaSaida(this);
        estacionamentoFacade.processarSaida(placa, placa);;
    }
    
    public Carro buscarCarro(String placa) {
        for (Carro carro : carrosEstacionados) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }
    
    public List<Carro> getCarrosEstacionados() {
        return carrosEstacionados;
    }
}
