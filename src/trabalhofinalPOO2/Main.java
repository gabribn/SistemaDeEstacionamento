package trabalhofinalPOO2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Estacionamento estacionamento = Estacionamento.getInstancia();// Singleton
		Scanner scanner = new Scanner(System.in);
		FachadaSaida estacionamentoFacade = new FachadaSaida(estacionamento);

		while (true) {
			System.out.println("\nSistema de Estacionamento");
			System.out.println("1. Adicionar carro");
			System.out.println("2. Listar carros estacionados");
			System.out.println("3. Remover um carro");
			System.out.println("4. Sair do programa");
			System.out.print("Escolha uma opção: \n");
			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				
				System.out.print("Digite a placa do carro: ");
				String placa = scanner.next();
				System.out.print("Digite o modelo do carro: ");
				String modelo = scanner.next();
				System.out.print("Digite a data de entrada: ");
				String dataEntrada = scanner.next();
				System.out.print("Digite número de vagas a serem ocupadas: ");
				int numVagas = scanner.nextInt();
				Carro carro = CarroFactory.createCarro(placa, modelo, dataEntrada, numVagas);
				estacionamento.adicionarCarro(carro);
				System.out.println("Carro adicionado com sucesso.");
				break;

			case 2:
				System.out.println("Carros estacionados:");
				for (Carro car : estacionamento.getCarrosEstacionados()) {
					System.out.println("Placa: " + car.getPlaca() + ", Modelo: " + car.getModelo()
							+ ", Data de Entrada: " + car.getDataEntrada());
				}
				break;

			case 3:
				System.out.print("Digite a placa do carro a ser removido: ");
				String placaRemover = scanner.next();
				System.out.print("Digite a data de saída: ");
				String dataSaida = scanner.next();
				estacionamentoFacade.processarSaida(placaRemover, dataSaida);
				;
				break;

			case 4:
				System.out.println("Encerrando o programa.");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}
}
