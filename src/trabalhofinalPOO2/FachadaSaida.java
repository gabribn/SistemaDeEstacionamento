package trabalhofinalPOO2;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class FachadaSaida {
	private Estacionamento estacionamento;
	public FachadaSaida(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public void processarSaida(String placa, String dataSaida) {
		Carro carro = estacionamento.buscarCarro(placa);
		if (carro != null) {
			String dataEntrada = carro.getDataEntrada();
			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Date data1 = formato.parse(dataEntrada);
				Date data2 = formato.parse(dataSaida);

				if (verificaDataSaida(data1, data2)) {
					int diasEstadia = calcularDiasEstadia(data1, data2);
					double taxa = calcTaxa(diasEstadia, carro.getNumVagas());
					System.out.println("Taxa a ser paga: " + taxa);
					estacionamento.resumo.att(taxa);
					removeCarro(placa);
				}
			} catch (ParseException e) {
				System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
			}
		} else {
			System.out.println("Carro com placa " + placa + " não encontrado no estacionamento.");
		}
	}

	private boolean verificaDataSaida(Date dataEntrada, Date dataSaida) {
		if (dataEntrada.before(dataSaida)) {
			return true;
		} else if (dataEntrada.after(dataSaida)) {
			System.out.println("Data de saída inválida.");
			return false;
		} else {
			System.out.println("As datas de entrada e saída são iguais.");
			return false;
		}
	}

	private int calcularDiasEstadia(Date dataEntrada, Date dataSaida) {
		long diff = dataSaida.getTime() - dataEntrada.getTime();
		return (int) (diff / (1000 * 60 * 60 * 24)); // Converte milissegundos para dias
	}

	private double calcTaxa(int diasEstadia, int numVagas) {
		CalculadoraTaxa calculadora;

		if (numVagas == 2) {
			calculadora = new TaxaDupla();
		} else {
			calculadora = new TaxaPadrao();
		}

		return calculadora.calcularTaxa(diasEstadia, numVagas);
	}

	public void removeCarro(String placa) {
	    for (Carro carro : estacionamento.getCarrosEstacionados()) {
	        if (carro.getPlaca().equals(placa)) {
	            estacionamento.getCarrosEstacionados().remove(carro);
	            System.out.println("Carro com placa " + placa + " removido do estacionamento.");
	            return;
	        }
	    }
	    System.out.println("Carro com placa " + placa + " não encontrado no estacionamento.");
	}
}
