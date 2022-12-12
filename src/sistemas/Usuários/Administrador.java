package sistemas.Usuários;

import java.time.LocalDate;

public class Administrador extends Usuario {
	private float valorDosCreditos = 0.50f;

	public Administrador(String nome, String sexo, String email, String senha, LocalDate i) {
		super(nome, sexo, email, senha, i);
		this.setTipoDeConta(TipoDeConta.ADMINISTRADOR);
	}

	public String recuperarCargo() {
		return "Administrador";
	}

	public void atualizarValorDosCreditos(float novoValor) {
		valorDosCreditos = novoValor;
	}

	public float getValorDosCreditos() {
		return valorDosCreditos;
	}
}
