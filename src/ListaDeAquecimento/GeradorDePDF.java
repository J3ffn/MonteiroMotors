package ListaDeAquecimento;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
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
	
	public void gerarBoleto(CentralDeInformacoes central, Mototaxista m, float valor) {
		Document doc = new Document(PageSize.A4);
		
		//List< Corrida > listarCorridas = central.getCorridas();
		
		String arquivoPDF = "Boleto.pdf";
		
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
			doc.open();
			
			Image imagem = Image.getInstance("icones/icons8-motocross-30.png");
			imagem.scaleAbsolute(50, 50);
			doc.add(imagem);
			
			PdfPTable tabela = new PdfPTable(4);
			
			
			Paragraph paragrafo = new Paragraph("Monteiro Motors");
			paragrafo.setAlignment(Element.ALIGN_CENTER);
			Font f = new Font();
			f.setStyle(Font.BOLD);
			paragrafo.setFont(f);
			PdfPCell celula1 = new PdfPCell(paragrafo);
			celula1.setColspan(2);
			tabela.addCell(celula1);
			
			PdfPCell celula5 = new PdfPCell(new Paragraph("Numero:\n" + (int)(Math.random() * 99999999) + "-" + (int)(Math.random() * 99999999)));
			celula5.setColspan(2);
			tabela.addCell(celula5);

			
			celula1 = new PdfPCell(new Paragraph("Nome do Baneficiário:\n\nMonterio Motors-LTDA"));
			celula1.setColspan(2);
			LocalDate data = LocalDate.now();
			LocalDate vencimento = data.plusDays(3);
			
			PdfPCell celula2 = new PdfPCell(new Paragraph(String.format("Data de Vencimento:\n\n%d/%d/%d", vencimento.getDayOfMonth(), vencimento.getMonthValue(), vencimento.getYear())));
			PdfPCell celula3 = new PdfPCell(new Paragraph("Valor:\n\n R$ " + valor));
			PdfPCell celula4 = new PdfPCell(new Paragraph(String.format("Data do Documento:\n\n%d/%d/%d", data.getDayOfMonth(), data.getMonthValue(), data.getYear())));			
			PdfPCell celula6 = new PdfPCell(new Paragraph("Quantidade de créditos:\n\n" + (int) (valor/central.recuperarAdministradorDoSistema().getValorDosCreditos())));			
			PdfPCell celula7 = new PdfPCell(new Paragraph("Email:\n\nmonteiromotos4598@gmail.com"));
			celula7.setColspan(2);
			
			PdfPCell celula8 = new PdfPCell(new Paragraph("Informacoes:\nNão receber após o vencimento\n\n\n\n "));
			celula8.setColspan(4);
			PdfPCell celula9 = new PdfPCell(new Paragraph(String.format("Pagador:\n\n%s\n%s\n ", m.getNome().toUpperCase(), m.getEmail())));
			celula9.setColspan(4);
			
			

			tabela.addCell(celula1);
			tabela.addCell(celula2);
			tabela.addCell(celula3);
			tabela.addCell(celula4);
			tabela.addCell(celula6);
			tabela.addCell(celula7);
			tabela.addCell(celula8);
			tabela.addCell(celula9);
			
			tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			doc.add(tabela);
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void gerarRelatorioFinancas(ArrayList<Mototaxista> mototaxistas) {
		Document doc = new Document();
		
		String arquivoPDF = "Relatorio_de_Finanças.pdf";
		
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
			doc.open();
			
			Paragraph paragrafo = new Paragraph("Relatório de finanças");
			paragrafo.setAlignment(1);
			doc.add(paragrafo);
			
			paragrafo = new Paragraph("");
			doc.add(paragrafo);
			
			PdfPTable tabela = new PdfPTable(3);
			
			PdfPCell celula1 = new PdfPCell(new Paragraph("Tipo"));
			PdfPCell celula2 = new PdfPCell(new Paragraph("Data"));
			PdfPCell celula3 = new PdfPCell(new Paragraph("Valor"));
			
			tabela.addCell(celula1);
			tabela.addCell(celula2);
			tabela.addCell(celula3);
			
			for(Mototaxista c: mototaxistas) {
				for(int i = 0; i < c.getCreditos().size(); i++) {
					celula1 = new PdfPCell(new Paragraph("Mototaxista"));
					celula2 = new PdfPCell(new Paragraph(c.getCreditos().get(i).getData() + ""));
					celula3 = new PdfPCell(new Paragraph(c.getCreditos().get(i).getValor() + ""));
					
					tabela.addCell(celula1);
					tabela.addCell(celula2);
					tabela.addCell(celula3);
				}
				
			}
			
			doc.add(tabela);
			doc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
