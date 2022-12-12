package sistemas.Corridas;

import sistemas.Usuários.Mototaxista;
import sistemas.Usuários.Usuario;

public class Avaliacao {
	private Corrida corrida;
	private Usuario autor;
	private Mototaxista destinatario;
	private float nota;
	private float notaMaxima = 5;
	private String comentario;

	public Avaliacao(Corrida corrida, Usuario autor, Mototaxista destinatario, float nota, String comentario) {
		this.autor = autor;
		this.destinatario = destinatario;
		if (nota <= notaMaxima)
			this.nota = nota;
		this.comentario = comentario;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		if (nota <= notaMaxima)
			this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getAutor() {
		return autor;
	}

	public Mototaxista getDestinatario() {
		return destinatario;
	}

	public float getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(float notaMaxima) {
		this.notaMaxima = notaMaxima;
	}

	public Corrida getCorrida() {
		return corrida;
	}

}
