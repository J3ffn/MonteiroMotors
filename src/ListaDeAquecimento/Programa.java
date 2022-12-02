package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Persistencia per = new Persistencia();
		Mensageiro msn = new Mensageiro();
		boolean flag = false;
		try {
			CentralDeInformacoes central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			do {
				System.out.print("\n1- novo passageiro\n" +
						"2- listar todos os passageiros\n" +
						"3- exibir informações de um passageiro expecífico\n" +
						"4- nova corrida\n" +
						"5- listar todas as corridas\n" +
						"6- listar corridas de um passageiro\n" +
						"7- gerar relatório de solicitações de corridas\n" +
						"8- enviar histórico de corridas\n" +
						"S- Sair\nSua Escolha: ");
				String escolha = input.nextLine().toUpperCase();
				switch(escolha) {
				
				case "1":
					System.out.print("\nInsira o nome do passageiro: ");
					String nome = input.nextLine();
					
					System.out.print("Insira o sexo do passageiro: ");
					String sexo = input.nextLine();
					
					System.out.print("Insira a data de nascimento (no formato DD/MM/AAAA): ");
					String[] datas = input.nextLine().split("/");
					LocalDate dataNascimento = LocalDate.of(Integer.parseInt(datas[2]), 
							Integer.parseInt(datas[1]), 
							Integer.parseInt(datas[0]));
					
					System.out.print("Insira o email do passageiro: ");
					String email = input.nextLine();
					
					Passageiro pass = new Passageiro(nome, sexo, dataNascimento, email);
					if(central.adicionarPassageiro(pass)) {
						System.out.println("Passageiro adicionado!");
						try {
							per.salvar(central, "dados-passageiros.xml");
						} catch (Exception erro){
							System.out.println("Houve um erro ao salvar os dados!");
						}
					} else {
						System.out.println("Erro! Tente Novamente!");
					}
					break;
					
				case "2":
					System.out.println(central.listarTodosOsPassageiros());
					break;
					
				case "3":
					Passageiro p = null;
					do {
						System.out.print("\nInsira o email(Digite 'Cancelar' para voltar ao menu): ");
						String eml = input.nextLine();
						if(eml.equalsIgnoreCase("Cancelar")) {
							break;
						} else {
							p = central.recuperarPassageiroPeloEmail(eml);
						}
						if(p==null){
							System.out.println("Email não encontrado! Tente novamente!");
						}
					}while(p == null);
					if(p!= null) 
						System.out.printf("Nome: %s\nSexo: %s \nData de Nascimento: %s\n", p.getNome(), p.getSexo(), p.getDataDeNascimento());
					break;
					
				case "4":
					Corrida corrida = null;
					do {
						System.out.print("Informe o ID do passageiro: ");
						String id = input.nextLine();
						System.out.print("Informe o endereço de partida: ");
						String enderecoP = input.nextLine();
						
						System.out.print("Informe o endereço de destino: ");
						String enderecoD = input.nextLine();
						
						System.out.print("Informe o endereço de destino: ");
						float distancia = Float.parseFloat(input.nextLine());
						
						corrida = new Corrida(enderecoP, enderecoD,  distancia, central.recuperarPassageiroPeloEmail(id));
						boolean g = false;
						if(corrida.getPassageiro() != null) {
							g = central.adicionarCorrida(corrida);
						}
						if(!g) {
							System.out.println("Erro! Tente Novamente!");
							corrida = null;
						}
					}while(corrida == null);
					System.out.println("Corrida adicionada!");
					try {
						per.salvar(central, "dados-passageiros.xml");
					} catch (Exception erro){
						System.out.println("Houve um erro ao salvar os dados!");
					}
					break;
					
				case "5":
					System.out.println(central.listarTodasAsCorridas());
					break;
					
				case "6":
					Passageiro p1 = null;
					do {
						System.out.print("\nInsira o email(Digite 'Cancelar' para voltar ao menu): ");
						String eml = input.nextLine();
						if(eml.equalsIgnoreCase("Cancelar")) {
							break;
						} else {
							p1 = central.recuperarPassageiroPeloEmail(eml);
						}
						if(p1==null){
							System.out.println("Email não encontrado! Tente novamente!");
						}
					}while(p1 == null);
					if(p1 != null) {
						System.out.printf("Corridas de %s:\n", p1.getNome());
						for(Corrida c : central.recuperarCorridasDeUmPassageiro(p1.getId())) {
							System.out.println(c);
						}
					}
					break;
				case "7":
					System.out.println("Gerando Relatório...");
					GeradorDeRelatorios.obterSolicitacoesDeCorrida(central);
					System.out.println("Relatório Gerado com Sucesso!");
					break;
				case "8":
					System.out.print("Insira o email do passageiro: ");
					String email1 = input.nextLine();
					Passageiro passageiro = central.recuperarPassageiroPeloEmail(email1);
					if(passageiro == null) {
						System.out.println("Passageiro não encontrado! Tente novamente!");
					} else {
						msn.enviarHistoricoDeCorridas(passageiro);
					}
					break;
				case "S":
					System.out.println("\nSaindo...");
					flag = true;
				}
				
			}while(!flag);
			System.out.println("Fim do Programa!");
			
		} catch (Exception erro){
			System.out.println(erro.toString());
		}
		input.close();
	}
}
