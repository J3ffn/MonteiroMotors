package sistemas.GestãoDeInformacoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	public Persistencia() {
		xstream.addPermission(AnyTypePermission.ANY);
	}

	private XStream xstream = new XStream(new DomDriver());

	public void salvar(CentralDeInformacoes central, String nomeDoArquivo) throws Exception {

		File arquivo = new File("src/arquivos/" + nomeDoArquivo);
		arquivo.createNewFile();

		PrintWriter pw = new PrintWriter(arquivo);
		String xml = xstream.toXML(central);
		pw.print(xml);
		pw.close();
	}

	public Object recuperar(String nomeDoArquivo) throws Exception {
		File arquivo = new File("src/arquivos/" + nomeDoArquivo);
		try {
			if (arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (Object) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
}
