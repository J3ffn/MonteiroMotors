package eduardo.JanelaCorridasDisponiveis;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ListaDeAquecimento.Administrador;
import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Status;
import ListaDeAquecimento.Usuario;

public class PainelListaCorridasAdministrador extends Painel{
	public PainelListaCorridasAdministrador(ArrayList<Corrida> corridasTodasAsDisponiveis, Administrador usuario) {
		super(corridasTodasAsDisponiveis, usuario);
	}
}
