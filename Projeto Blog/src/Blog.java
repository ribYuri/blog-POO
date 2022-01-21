import java.util.ArrayList;
import java.util.Date;

public class Blog {
	
	private ArrayList<Usuario> usuariosAutenticados = new ArrayList<Usuario>();
	private ArrayList<Postagem> postagens = new ArrayList<Postagem>();
	private ArrayList<Postagem> postsPublicados = new ArrayList<Postagem>();
	
	private Date dataAtual = new Date();

	public void adicionarPostagem(Usuario user,Postagem post) {
		if(estaAutenticado(user)) {
			this.postagens.add(post);
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Postagem adicionada!");
		} else {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Este usuario nao esta autenticado, portanto nao pode adicionar uma postagem!");
		}
	}
	
	public void publicarPostagem(Usuario userPublicando, int indicePostAdicionado) {
		indicePostAdicionado--;
		if(estaAutenticado(userPublicando) && indicePostAdicionado < this.postagens.size()) {
			this.postsPublicados.add(this.postagens.get(indicePostAdicionado));
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Postagem publicada!");
		} else
			if(indicePostAdicionado >= this.postagens.size()) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Nao ha uma postagem adicionada com este indice!");
			} else {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("O usuario nao esta autenticado, por isso nao pode publicar!");
			}
	}
	
	public void listarPostagensPublicadas() {
		for(int i=0; i<this.postsPublicados.size(); i++) {
			if((this.postsPublicados.get(i).getDataPublicacao().compareTo(this.dataAtual)) < 1) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Postagem de id: " +this.postsPublicados.get(i).getId());
				System.out.println("Titulo: " +this.postsPublicados.get(i).getTitulo());
				System.out.println("Postado por: "
				+this.usuariosAutenticados.get(procuraUsuarioPostador(this.postsPublicados.get(i).getIdUsuarioCriador())).getNome());
			}
		}
		if(this.postsPublicados.size() == 0) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Nao ha postagens publicadas ainda!");
		}
	}
	
	public void listarTodasAsPostagens() {
		for(int i=0; i< this.postagens.size(); i++) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Postagem de id: " +this.postagens.get(i).getId());
			System.out.println("Titulo: " +this.postagens.get(i).getTitulo());
			System.out.println("Adicionado por: "
			+this.usuariosAutenticados.get(procuraUsuarioPostador(this.postagens.get(i).getIdUsuarioCriador())).getNome());
		}
		if(this.postagens.size() == 0) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Nao ha postagens adicionadas ainda!");
		}
	}
	
	public void apagarPostagem(Usuario user,Postagem post) {
		if(estaAutenticado(user)) {
			for(int i=0; i< this.postagens.size(); i++) {
				if(this.postagens.get(i).getId().equals(post.getId())) {
					this.postagens.remove(i);
					System.out.println("\nPostagem removida com sucesso!");
				}
			}
		}
			
	}
	
	public void autenticaUsuario(Usuario user, String login, String senha) {
		if(user.getLogin().equals(login) && user.getSenha().equals(senha)){
			this.usuariosAutenticados.add(user);
		} else {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Usuario de nome e ID: " + user.getNome() + "; "+user.getId()+ ". Inseriu login ou senha incorretos.");
			System.out.println("Usuario nao autenticado!");
		}
	}
	
	
	private boolean estaAutenticado(Usuario user) {
		int a = 0;
		for(int i=0; i<this.usuariosAutenticados.size(); i++) {
			if(user.getId().equals(this.usuariosAutenticados.get(i).getId())) {
				a++;
			}
		}
		if(a == 1)
			return true;
		else
			return false;
	}
	
	public int procuraUsuarioPostador(int idUsuario) {
		int b = 0;
		for(int i=0; i< this.usuariosAutenticados.size(); i++) {
			if(this.usuariosAutenticados.get(i).getId().equals(idUsuario)) {
				b = i;
			}	
		}
		return b;
	}
	
}
