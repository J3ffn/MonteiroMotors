package jefferson.telaDeFinancas_TERMINAR.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Persistencia;
import clebson.JanelaAdministrador;
import jefferson.UsuarioTeste;
import jefferson.telaDeAdicionarCreditos_OK.ouvintesAdicionar.OuvinteComboBox;
import jefferson.telaDeFinancas_TERMINAR.ouvintes.OuvinteDeFinancas;

@SuppressWarnings("serial")
public class TelaFinancas extends JFrame{

	private String email;
	private JFormattedTextField linhaData;
	private CentralDeInformacoes central;
	private LocalDateTime data;
	private JComboBox<String> box;
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public TelaFinancas(Administrador adm) {
		super("Finanças");
		this.email = adm.getEmail();
		
		adicionarCentral();
		
		setSize(498, 462);
		setResizable(false);
		setLocationRelativeTo(null);			
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addTitulo();
		addComboBox();
		
		// TODO remover teste
//		testeAdicionarCorridas();
		
		addBotoes(adm);

		setVisible(true);
	}
	
	private void adicionarCentral() {
		try {
			central = (CentralDeInformacoes) new Persistencia().recuperar("dados-passageiros.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addTitulo() {
		JLabel titulo = new JLabel();
		titulo.setFont(new Font("", Font.BOLD, 20));
		titulo.setBounds(0, 100, 483, 30);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText("O email será enviado para:");
		
		JLabel tituloEmail = new JLabel(email);
		tituloEmail.setBounds(0, 125, 483, 30);
		tituloEmail.setForeground(Color.red);
		tituloEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tituloEmail.setFont(new Font("", Font.BOLD, 20));
		
		JLabel informacao = new JLabel();
		informacao.setBounds(0, 155, 483, 30);
		informacao.setHorizontalAlignment(SwingConstants.CENTER);
		informacao.setText("Este é um relatório de finanças, será enviado para o email a cima");
		
		add(titulo);
		add(tituloEmail);
		add(informacao);
	}
	
	private void addBotoes(Administrador adm) {
		JButton botaoVoltar = new JButton("< voltar");
		botaoVoltar.setBounds(5, 5, 80, 20);
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaAdministrador(adm);
			}
		});
		
		JButton botaoEnviar = new JButton("Enviar");
		botaoEnviar.setBounds(180, 300, 120, 40);
		
		botaoEnviar.addActionListener(new OuvinteDeFinancas(central.recuperarUsuarioPeloEmail(email), central.getCorridas(), data, box, linhaData, central));
		
		add(botaoVoltar);
		add(botaoEnviar);
	}
	
	private void addComboBox() {
		JLabel subtitulo = new JLabel("Filtrar por:");
		subtitulo.setBounds(180, 172, 60, 40);
		
		String[] opcoes = {"Tudo", "Recentes", "Antigas"}; 
		box = new JComboBox<>(opcoes);
		box.setBounds(180, 200, 120, 40);
		
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			linhaData = new JFormattedTextField(mascara);
			linhaData.setBounds(180, 250, 120, 40);
			linhaData.setHorizontalAlignment(JFormattedTextField.CENTER);
			linhaData.setVisible(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> box = (JComboBox<String>) e.getSource();
				
				String selecionado = (String) box.getSelectedItem();
				System.out.println(selecionado);
				
				switch (selecionado) {
				case "Tudo":
					linhaData.setVisible(false);
					break;
				default:
					linhaData.setVisible(true);
				}
				
			}
		});
		
		add(subtitulo);
		add(box);
		add(linhaData);
	}
	
	
}
