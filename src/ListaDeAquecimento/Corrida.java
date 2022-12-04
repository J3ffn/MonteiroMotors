package ListaDeAquecimento;

import java.time.LocalDate;

public class Corrida {
	private long id;
	private Status status;
	
	private String enderecoDePartida;
	private String enderecoDeDestino;
	private float distancia;
	
	private boolean paraAgora;
	private LocalDate data;
	
	private Usuario usuario;
	
	private Mototaxista mototaxista;
	
	private Avaliacao avaliacao;
	
	public Corrida() {
		id = System.currentTimeMillis();
	}
	public Corrida(String enderecoDePartida, String enderecoDeDestino, float distancia, boolean paraAgora, LocalDate data, Usuario usuario) {
		this();
		this.enderecoDePartida = enderecoDePartida;
		this.enderecoDeDestino = enderecoDeDestino;
		this.distancia = distancia;
		this.paraAgora = paraAgora;
		this.data = data;
		this.usuario = usuario;
	}
	public String toString() {
		if(usuario.getSexo() == Sexo.FEMININO) {
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
		status = Status.EM_CURSO;
	}
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
