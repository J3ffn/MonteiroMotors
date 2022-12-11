package ListaDeAquecimento;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeBoleto{

	public void gerar(CentralDeInformacoes central) {
		Document doc = new Document();
		
		List< Corrida > listarCorridas = central.getCorridas();
		
		String arquivoPDF = "Boleto.pdf";
		
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
			doc.open();
			
			Paragraph paragrafo = new Paragraph("Relatório de finanças");
			paragrafo.setAlignment(1);
			doc.add(paragrafo);
			
			paragrafo = new Paragraph("");
			doc.add(paragrafo);
			
			PdfPTable tabela = new PdfPTable(3);
			
			PdfPCell celula1 = new PdfPCell(new Paragraph("Corrida"));
			PdfPCell celula2 = new PdfPCell(new Paragraph("Situacao"));
			PdfPCell celula3 = new PdfPCell(new Paragraph("Valor"));
			
			tabela.addCell(celula1);
			tabela.addCell(celula2);
			tabela.addCell(celula3);
			
			for(Corrida c: listarCorridas) {
				celula1 = new PdfPCell(new Paragraph(c.toString()));
				celula2 = new PdfPCell(new Paragraph(c.getStatus() + ""));
				celula3 = new PdfPCell(new Paragraph("Valor"));
				
				tabela.addCell(celula1);
				tabela.addCell(celula2);
				tabela.addCell(celula3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
