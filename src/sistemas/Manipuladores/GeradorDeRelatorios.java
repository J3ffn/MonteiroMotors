package sistemas.Manipuladores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import sistemas.GestãoDeInformacoes.CentralDeInformacoes;
import sistemas.Usuários.Usuario;

public class GeradorDeRelatorios {
	public static void obterSolicitacoesDeCorrida(CentralDeInformacoes central) {

		try {
			Document doc = new Document(PageSize.A4);
			OutputStream os = new FileOutputStream("src/arquivos/relatorio.pdf");
			PdfWriter.getInstance(doc, os);

			doc.open();

			Paragraph p1 = new Paragraph("Relatório de Solicitações de Corrida");
			p1.setAlignment(Element.ALIGN_CENTER);
			PdfPTable table = new PdfPTable(2);
			PdfPCell cabecalho1 = new PdfPCell(p1);
			PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Nome do Usuario"));
			PdfPCell cabecalho3 = new PdfPCell(new Paragraph("Número de Corridas Solicitadas"));

			cabecalho1.setColspan(2);
			cabecalho1.setBackgroundColor(BaseColor.GREEN);
			cabecalho1.setHorizontalAlignment(Element.ALIGN_CENTER);

			cabecalho2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecalho2.setHorizontalAlignment(Element.ALIGN_CENTER);

			cabecalho3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecalho3.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cabecalho1);
			table.addCell(cabecalho2);
			table.addCell(cabecalho3);

			for (Usuario usuario : central.getTodosOsUsuarios()) {
				PdfPCell nome = new PdfPCell(new Paragraph(usuario.getNome()));
				PdfPCell corridas = new PdfPCell(new Paragraph(
						Integer.toString(central.recuperarCorridasDeUmPassageiro(usuario.getEmail()).size())));
				nome.setHorizontalAlignment(Element.ALIGN_CENTER);
				corridas.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(nome);
				table.addCell(corridas);
			}
			doc.add(table);
			doc.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
