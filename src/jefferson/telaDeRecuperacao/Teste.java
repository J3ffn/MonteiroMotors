package jefferson.telaDeRecuperacao;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Teste {

	public static void main(String[] args) {
		
//		HashSet<String> saco = new HashSet<>();

//		for(char i = 'a'; i < 'z'; i++) {
//			saco.add(i + "");
//		}
//		
//		for(String s: saco) {
//			System.out.println(s);
//		}
		
//		OuvinteEnvioCodigo o = new OuvinteEnvioCodigo("jefferson.mangueira@academico.ifpb.edu.br", new JFrame());
//		try {
//			
//			o.enviarEmail();
//			
//		} catch (EmailException e) {
//			System.out.println("Erro");
//			e.printStackTrace();
//		}
//		new TelaVerificarCodigo("a7b9858");
		
		try {
			InternetAddress emailAddr = new InternetAddress("");
			emailAddr.validate();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
