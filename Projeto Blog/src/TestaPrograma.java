import java.text.ParseException;

public class TestaPrograma {
	
	public static void main(String[] args) throws ParseException {
		
		Usuario u1 = new Usuario(101, "Rodrigo", "rodrigo1", "senha1234");
		Usuario u2 = new Usuario(201, "Marcela", "marcela22", "1234senha");
		Usuario u3 = new Usuario(301, "Joana", "joaninha", "juana");
		
		u1.criaNovaPostagem(new Postagem(5, "A volta dos que nao foram", "Ninguem foi"));
		u1.criaNovaPostagem(new Postagem(8, "A volta dos que Foram", "Todo mundo foi"));
		u1.getPostagem(2).setDataPublicacao("16/02/2021 18:00");
		u1.criaNovaPostagem(new Postagem(11, "Quem nao foi ficou", "Alguns ficaram para tras"));
		u1.getPostagem(3).setDataPublicacao("22/04/2021 17:30");
		
		u2.criaNovaPostagem(new Postagem(25, "O principe", "Um pricipe rico"));
		u2.getPostagem(1).setDataPublicacao("20/04/2021 12:00");
		u2.criaNovaPostagem(new Postagem(28, "Nasa", "Foguete lancado este ano"));
		u2.getPostagem(2).setDataPublicacao("23/12/2020 11:00");
		u2.criaNovaPostagem(new Postagem(30, "SpaceX", "Empresa privada possui contrato com Nasa"));
		
		u3.criaNovaPostagem(new Postagem(40, "Robinho", "Jogador ganha homenagem"));
		u3.criaNovaPostagem(new Postagem(45, "Derivadas", "Muito usado na matematica aplicada a fisica"));
		
		
		Blog blog = new Blog();
		
		blog.autenticaUsuario(u1, "rodrigo1", "senha1234");
		blog.autenticaUsuario(u2, "marcela22", "1234senha");
		blog.autenticaUsuario(u3, "joaninha", "jUana");
		
		blog.adicionarPostagem(u1, u1.getPostagem(1));
		blog.adicionarPostagem(u1, u1.getPostagem(2));
		blog.adicionarPostagem(u1, u1.getPostagem(3));
		
		blog.adicionarPostagem(u2, u2.getPostagem(1));
		blog.adicionarPostagem(u2, u2.getPostagem(2));
		blog.adicionarPostagem(u2, u2.getPostagem(3));
		
		blog.adicionarPostagem(u3, u3.getPostagem(1));
		
		blog.publicarPostagem(u1, 1); //1 parametro = usuario publicando; 2 parametro = indice da postagem adicionada.
		blog.publicarPostagem(u1, 2); //Neste exemplozinho foram adicionadas 6 postagens.
		blog.publicarPostagem(u1, 3); 
		blog.publicarPostagem(u2, 4);
		blog.publicarPostagem(u2, 5);
		blog.publicarPostagem(u2, 6);
		
		blog.listarPostagensPublicadas();  
		
		//blog.listarTodasAsPostagens();       //comentado para nao poluir ainda mais o console
		
		blog.apagarPostagem(u1, u1.getPostagem(2));
		
		//blog.listarTodasAsPostagens();
		
	}

}
