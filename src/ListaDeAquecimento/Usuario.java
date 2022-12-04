package ListaDeAquecimento;
import java.time.LocalDate;


public abstract class Usuario{
	private String nome;
	private Sexo sexo;
	private String senha;
	private LocalDate dataDeNascimento;
	private String email;
	private String id;
	private boolean perfilAtivo;
	
	public Usuario(String nome, String sexo, String email, String senha, LocalDate i) {
		this.nome = nome;
		this.sexo = Sexo.valueOf(sexo.toUpperCase());
		this.dataDeNascimento = i;
		this.email = email;
		id = email;
		setPerfilAtivo(true);
	}
	
	public Usuario(String nome, String sexo, String email, String senha) {
		this(nome, sexo, senha, email, null);
	}
	
	public boolean fazerLogin(String senha_2) throws SenhaIncorretaException, PerfilDesativadoException{
		//Depois de verificar se o usuário existe na central com o recuperarUsuarioComEmail, apenas verifica se a senha é igual
		return (senha_2.equals(senha) && perfilAtivo);
	}
	
	public String toString() {
		return nome;
	}
	
	public String getId() {
		return id;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public String getNome() {
		return nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPerfilAtivo() {
		return perfilAtivo;
	}
	public void setPerfilAtivo(boolean perfilAtivo) {
		this.perfilAtivo = perfilAtivo;
	}
	public static void main(String[] args) {
		Administrador adm = new Administrador("Desconhecido", "Masculino", "jjjj", "bolo", null);
		Credito c = new Credito(adm);
		System.out.println(c.getValor());
		adm.atualizarValorDosCreditos(0.4f);
		System.out.println(c.getValor());
		Credito c2 = new Credito(adm);
		System.out.println(c2.getValor());
	}
}