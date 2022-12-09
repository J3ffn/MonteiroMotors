package ListaDeAquecimento;

import java.time.LocalDate;
import java.util.Scanner;

import eduardo.JanelaDeRegistro;

public class Programa {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Persistencia per = new Persistencia();
		Mensageiro msn = new Mensageiro();
		Usuario usuarioAtual = null;
		
		boolean flag = false;
		try {
			CentralDeInformacoes central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			do {
				System.out.print("\n1- novo usuario\n" +
						"2- listar todos os usuarios\n" +
						"3- exibir informações de um usuario expecífico\n" +
						"4- nova corrida\n" +
						"5- listar todas as corridas\n" +
						"6- listar corridas de um passageiro\n" +
						"7- gerar relatório de solicitações de corridas\n" +
						"8- enviar histórico de corridas\n" +
						"9- verificar tipo de usuario\n" +
						"10- fazer login\n" +
						"S- Sair\nSua Escolha: ");
				String escolha = input.nextLine().toUpperCase();
				switch(escolha) {
				
				case "1":
					JanelaDeRegistro janela = new JanelaDeRegistro(central, per);
					break;
					
				case "2":
					System.out.println(central.listarTodosOsUsuarios());
					break;
					
				case "3":
					Usuario u = null;
					do {
						System.out.print("\nInsira o email(Digite 'Cancelar' para voltar ao menu): ");
						String eml = input.nextLine();
						if(eml.equalsIgnoreCase("Cancelar")) {
							break;
						} else {
							u = central.recuperarUsuarioPeloEmail(eml);
						}
						if(u==null){
							System.out.println("Email não encontrado! Tente novamente!");
						}
					}while(u == null);
					if(u!= null) 
						System.out.printf("Nome: %s\nSexo: %s \nData de Nascimento: %s\n", u.getNome(), u.getSexo(), u.getDataDeNascimento());
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
						
						corrida = new Corrida(enderecoP, enderecoD,  distancia, true, null, central.recuperarUsuarioPeloEmail(id));
						boolean g = false;
						if(corrida.getUsuario() != null) {
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
					Usuario u1 = null;
					do {
						System.out.print("\nInsira o email(Digite 'Cancelar' para voltar ao menu): ");
						String eml = input.nextLine();
						if(eml.equalsIgnoreCase("Cancelar")) {
							break;
						} else {
							u1 = central.recuperarUsuarioPeloEmail(eml);
						}
						if(u1==null){
							System.out.println("Email não encontrado! Tente novamente!");
						}
					}while(u1 == null);
					if(u1 != null && u1 instanceof Passageiro) {
						System.out.printf("Corridas de %s:\n", u1.getNome());
						for(Corrida c : central.recuperarCorridasDeUmPassageiro(u1.getId())) {
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
					Usuario usuario2 = central.recuperarUsuarioPeloEmail(email1);
					if(usuario2 == null) {
						System.out.println("Passageiro não encontrado! Tente novamente!");
					} else {
						msn.enviarHistoricoDeCorridas(usuario2);
					}
					break;
				case "9":
					System.out.print("Informe o email do passageiro: ");
					String email2 = input.nextLine();
					Usuario usuario3 = central.recuperarUsuarioPeloEmail(email2);
					if(usuario3 == null) {
						System.out.println("Passageiro não encontrado! Tente novamente!");
					} else {
						System.out.println(usuario3.recuperarCargo());
					}
					break;
				case "10":
					if(usuarioAtual == null) {
						System.out.print("Insira o email: ");
						String email4 = input.nextLine();
						System.out.print("Insira a senha: ");
						String senha2 = input.nextLine();
						try {
							usuarioAtual = central.recuperarUsuarioPeloEmail(email4);
							boolean logado = usuarioAtual.fazerLogin(senha2);
							System.out.println("Logado!");
						} catch(SenhaIncorretaException erro) {
							System.out.println("Senha Incorreta!");
							usuarioAtual = null;
						} catch(PerfilDesativadoException erro) {
							System.out.println("Perfil Desativado!");
							usuarioAtual = null;
						} catch (NullPointerException erro) {
							System.out.println("Passageiro não encontrado!");
						}
					} else {
						System.out.println("Você já está logado!");
					}
					break;
				case "S":
					System.out.println("\nSaindo...");
					flag = true;
				}
				
			} while(!flag);
			System.out.println("Fim do Programa!");
			
		} catch (Exception erro){
			System.out.println(erro.toString());
		}
		input.close();
	}
}
