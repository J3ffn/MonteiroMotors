package ListaDeAquecimento;


public class Corrida {
	private long id;
	private String enderecoDePartida;
	private String enderecoDeDestino;
	private float distancia;
	private Usuario usuario;
	
	public Corrida() {
		id = System.currentTimeMillis();
	}
	public Corrida(String enderecoDePartida, String enderecoDeDestino, float distancia, Usuario usuario) {
		this();
		this.enderecoDePartida = enderecoDePartida;
		this.enderecoDeDestino = enderecoDeDestino;
		this.distancia = distancia;
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
	
}
