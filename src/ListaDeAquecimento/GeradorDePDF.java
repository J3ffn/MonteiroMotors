package ListaDeAquecimento;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDePDF{

	private CentralDeInformacoes central;
	
	public GeradorDePDF(){
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			
		}
	}
	
	public void gerarBoleto(CentralDeInformacoes central) {
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
				celula3 = new PdfPCell(new Paragraph(c.getValor().toString()));
				
				tabela.addCell(celula1);
				tabela.addCell(celula2);
				tabela.addCell(celula3);
			}
			
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void gerarRelatorioFinancas(ArrayList<Corrida> listaCorridas) {
		Document doc = new Document();
		
		String arquivoPDF = "Relatório_de_Finanças.pdf";
		
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
			
			for(Corrida c: listaCorridas) {
				celula1 = new PdfPCell(new Paragraph(c.toString()));
				celula2 = new PdfPCell(new Paragraph(c.getStatus() + ""));
				celula3 = new PdfPCell(new Paragraph(1));
				
				tabela.addCell(celula1);
				tabela.addCell(celula2);
				tabela.addCell(celula3);
			}
			
			doc.add(tabela);
			doc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
