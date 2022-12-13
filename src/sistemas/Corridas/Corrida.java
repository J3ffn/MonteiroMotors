package sistemas.Corridas;

import java.time.LocalDateTime;

import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.Sexo;
import sistemas.Usuários.Usuario;

public class Corrida {
	private long id;
	private Status status;

	private String enderecoDePartida;
	private String enderecoDeDestino;
	private float distancia;

	private boolean paraAgora;
	private LocalDateTime data;

	private Usuario usuario;

	private Mototaxista mototaxista;

	private Avaliacao avaliacao;

	private ValorCorrida valorCorrida;

	public Corrida() {
		id = System.currentTimeMillis();
	}

	public Corrida(String enderecoDePartida, String enderecoDeDestino, float distancia, boolean paraAgora,
			LocalDateTime data, Usuario usuario, ValorCorrida valor) {
		this();
		this.enderecoDePartida = enderecoDePartida;
		this.enderecoDeDestino = enderecoDeDestino;
		this.distancia = distancia;
		this.paraAgora = paraAgora;
		this.data = data;
		this.valorCorrida = valor;

		this.usuario = usuario;
	}

	public String toString() {
		if (usuario.getSexo() == Sexo.FEMININO) {
			return String.format("%s pede para pegá-la em %s", usuario.getNome(), this.enderecoDePartida);
		} else {
			return String.format("%s pede para pegá-lo em %s", usuario.getNome(), this.enderecoDePartida);
		}
	}

	public long getId() {
		return id;
	}

	public String getEnderecoDePartida() {
		return enderecoDePartida;
	}

	public void setEnderecoDePartida(String enderecoDePartida) {
		this.enderecoDePartida = enderecoDePartida;
	}

	public String getEnderecoDeDestino() {
		return enderecoDeDestino;
	}

	public void setEnderecoDeDestino(String enderecoDeDestino) {
		this.enderecoDeDestino = enderecoDeDestino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getDistancia() {
		return distancia;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isParaAgora() {
		return paraAgora;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Mototaxista getMototaxista() {
		return mototaxista;
	}

	public void setMototaxista(Mototaxista mototaxista) {
		this.mototaxista = mototaxista;
		status = Status.REINVINDICADA;
	}

	public ValorCorrida getValor() {
		return valorCorrida;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
