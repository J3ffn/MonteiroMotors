package ListaDeAquecimento;
import java.time.LocalDate;


public class Passageiro{
	private String nome;
	private Sexo sexo;
	private String senha;
	private LocalDate dataDeNascimento;
	private String email;
	private String id;
	private boolean perfilAtivo;
	
	public Passageiro(String nome, String s, LocalDate i, String email) {
		this.nome = nome;
		sexo = Sexo.valueOf(s.toUpperCase());
		this.dataDeNascimento = i;
		this.email = email;
		id = email;
		setPerfilAtivo(true);
	}
	
	public Passageiro(String nome, String sexo, String senha) {
		this.nome = nome;
		this.sexo = Sexo.valueOf(sexo.toUpperCase());
		this.senha = senha;
	}

	public Passageiro() {
		this("Desconhecido", "Masculino", "johndoe@gmail.com");
	}
	
	public boolean fazerLogin(String email_2, String senha_2) {
		//Depois de verificar se o usuário existe na central, apenas verifica se o email e a snha são iguais
		return (email_2.equals(email) && senha_2.equals(senha));
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
}