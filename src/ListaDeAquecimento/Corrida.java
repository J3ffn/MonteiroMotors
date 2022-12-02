package ListaDeAquecimento;


public class Corrida {
	private long id;
	private String enderecoDePartida;
	private String enderecoDeDestino;
	private float distancia;
	private Passageiro passageiro;
	
	public Corrida() {
		id = System.currentTimeMillis();
	}
	public Corrida(String enderecoDePartida, String enderecoDeDestino, float distancia, Passageiro passageiro) {
		this();
		this.enderecoDePartida = enderecoDePartida;
		this.enderecoDeDestino = enderecoDeDestino;
		this.distancia = distancia;
		this.passageiro = passageiro;
	}
	public String toString() {
		if(passageiro.getSexo() == Sexo.FEMININO) {
			return String.format("%s pede para pegá-la em %s", passageiro.getNome(), this.enderecoDePartida);
		} else {
			return String.format("%s pede para pegá-lo em %s", passageiro.getNome(), this.enderecoDePartida);
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
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public float getDistancia() {
		return distancia;
	}
	
}
