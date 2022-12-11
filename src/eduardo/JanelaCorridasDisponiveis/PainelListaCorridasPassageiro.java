package eduardo.JanelaCorridasDisponiveis;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ListaDeAquecimento.CentralDeInformacoes;
import ListaDeAquecimento.Corrida;
import ListaDeAquecimento.Mototaxista;
import ListaDeAquecimento.Passageiro;
import ListaDeAquecimento.Persistencia;
import ListaDeAquecimento.Status;

public class PainelListaCorridasPassageiro extends Painel{
	
	public PainelListaCorridasPassageiro(ArrayList < Corrida > corridasTodasAsDisponiveis, Passageiro usuario) {
		super(corridasTodasAsDisponiveis, usuario);
	}
}
