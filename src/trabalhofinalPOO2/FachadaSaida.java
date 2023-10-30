package trabalhofinalPOO2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FachadaSaida {
    private Estacionamento estacionamento;

    public FachadaSaida(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    
    //fachada
    public void processarSaida(String placa, String dataSaida) {
        Carro carro = estacionamento.buscarCarro(placa);
        if (carro != null) {
            String dataEntrada = carro.getDataEntrada();
            if (verificaDataSaida(dataEntrada, dataSaida)) {
                int diasEstadia = calcularDiasEstadia(dataEntrada, dataSaida);
                calcTaxa(diasEstadia);
                estacionamento.removeCarro(placa);
            }
        } else {
            System.out.println("Carro com placa " + placa + " não encontrado no estacionamento.");
        }
    }
    

    private boolean verificaDataSaida(String dataEntrada, String dataSaida) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate data1 = LocalDate.parse(dataEntrada, formato);
        LocalDate data2 = LocalDate.parse(dataSaida, formato);
        if (data1.isBefore(data2)) {
            return true;
        } else if (data1.isAfter(data2)) {
            System.out.println("Data de saída inválida.");
            return false;
        } else {
            System.out.println(dataEntrada + " e " + dataSaida + " são iguais");
            return false;
        }
    }

    private int calcularDiasEstadia(String dataEntrada, String dataSaida) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate data1 = LocalDate.parse(dataEntrada, formato);
        LocalDate data2 = LocalDate.parse(dataSaida, formato);
        return (int) data1.until(data2).getDays();
    }

    private void calcTaxa(int diasEstadia) {
        // Implemente o cálculo da taxa com base nos dias de estadia aqui.
    }
}
