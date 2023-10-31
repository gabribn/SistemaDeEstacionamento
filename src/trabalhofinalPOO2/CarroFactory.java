package trabalhofinalPOO2;

public class CarroFactory {
    public static Carro createCarro(String placa, String modelo, String dataEntrada, int numVagas) {
        return new Carro(placa, modelo, dataEntrada, numVagas);
    }
}