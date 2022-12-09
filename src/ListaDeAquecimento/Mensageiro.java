package ListaDeAquecimento;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Mensageiro extends MultiPartEmail{

	private String emailRemetente = "monteiromotos4598@gmail.com";
	private String chave = "jzmiiiqyqmxqqtin";
	
	public Mensageiro(){
		setarProtocolo();
	}
	
	private void setarProtocolo() {
		setHostName("smtp.gmail.com");
		setSmtpPort(587);
		setAuthenticator(new DefaultAuthenticator(emailRemetente, chave));
		setSSLOnConnect(true);
		try {
			setFrom(emailRemetente);
		} catch (EmailException e) {e.printStackTrace();}
	}
	
	public boolean enviarHistoricoDeCorridas(Usuario p) {
		Persistencia per = new Persistencia();
		ArrayList <Corrida> corridas = null;
		CentralDeInformacoes central = null;
		CentralDeInformacoes outraCentral = new CentralDeInformacoes();
		
		try {
			central = (CentralDeInformacoes) per.recuperar("dados-passageiros.xml");
			corridas = central.recuperarCorridasDeUmPassageiro(p.getEmail());
		} catch (Exception e) {e.printStackTrace();}
		
		ArrayList <Usuario> pass = new ArrayList <Usuario> ();
		pass.add(central.recuperarUsuarioPeloEmail(p.getEmail()));
		outraCentral.setTodosOsUsuarios(pass);
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
	
	public boolean verificarEmail(String email)  {
		try {
			InternetAddress verificador = new InternetAddress(email);
			verificador.validate();
			
			return true;
		} catch (AddressException e) {
			
			return false;
			
		}
	}
	
	public boolean enviarCodigoDeRecuperacao(String email, String codigoChave, String titulo) {
		if (verificarEmail(email)) {
			try {
				addTo(email);
				setMsg("Sua chave é: " + codigoChave);
				
				send();
				System.out.println("Enviado");
				return true;
			} catch (EmailException e) {
				
				JOptionPane.showMessageDialog(null, "Email não enviado");
				
			}
		} 
		return false;
	}
}
