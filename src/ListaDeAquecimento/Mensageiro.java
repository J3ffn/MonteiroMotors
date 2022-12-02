package ListaDeAquecimento;

import java.util.ArrayList;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Mensageiro extends MultiPartEmail{

	public Mensageiro(){
		setHostName("smtp.gmail.com");
		setSmtpPort(587);
		setAuthenticator(new DefaultAuthenticator("monteiromotos4598@gmail.com", "jzmiiiqyqmxqqtin"));
		setSSLOnConnect(true);
		try {
			setFrom("monteiromotos4598@gmail.com");
		} catch (EmailException e) {e.printStackTrace();}
	
	}
	
	public boolean enviarHistoricoDeCorridas(Passageiro p) {
		Persistencia per = new Persistencia();
		ArrayList <Corrida> corridas = null;
		CentralDeInformacoes central = null;
		CentralDeInformacoes outraCentral = new CentralDeInformacoes();
		
		try {
			central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			corridas = central.recuperarCorridasDeUmPassageiro(p.getEmail());
		} catch (Exception e) {e.printStackTrace();}
		
		ArrayList <Passageiro> pass = new ArrayList <Passageiro> ();
		pass.add(central.recuperarPassageiroPeloEmail(p.getEmail()));
		outraCentral.setTodosOsPassageiros(pass);
		outraCentral.setCorridas(corridas);
		
		GeradorDeRelatorios.obterSolicitacoesDeCorrida(outraCentral);
		
		setSubject("Seu Relatório de Corridas Solicitadas — Monteiro Motos");
		try {
			setMsg(String.format("Olá %s, em anexo está o seu histórico de corridas no nosso aplicativo! \n\n\nMuito obrigado pela preferência!\nAtenciosamente, \nEquipe Monteiro Motos", p.getNome()));
			
			EmailAttachment anexo = new EmailAttachment();
			anexo.setPath("relatorios/relatorio.pdf");
			anexo.setName("Relatório de Corridas.pdf");
			
			addTo(p.getEmail());
			this.attach(anexo);
			
			send();
			System.out.println("Email enviado com Sucesso!");
			return true;
		} catch (EmailException erro) {
			System.out.println(erro.getMessage());
			return false;
		}
	}
}
