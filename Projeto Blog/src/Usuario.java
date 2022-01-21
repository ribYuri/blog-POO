import java.util.ArrayList;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	private int indicePost = 0;
	
	private ArrayList<Postagem> postagens = new ArrayList<Postagem>();
	
	public Usuario(int id, String nome, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	
	public Integer getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public String getLogin() {
		return this.login;
	}
	public String getSenha() {
		return this.senha;
	}
	
	public void criaNovaPostagem(Postagem post) {
		this.postagens.add(post);
		this.postagens.get(this.indicePost).setIdUsuarioCriador(this.id);
		this.indicePost++;
	}
	
	public Postagem getPostagem(int indice) {
		indice--;
		if(indice < this.postagens.size()) {
			Postagem post = this.postagens.get(indice);
			return post;
		} else {
			System.out.println("Nao existe um post criado para esta posicao informada, retornando o primeiro post feito");
		    return this.postagens.get(0);
		}
	}
	

}
