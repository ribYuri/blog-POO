import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Postagem {
	
	private Integer id;
	private String titulo;
	private String texto;
	private Date datapublicacao = new Date();
	
	private Integer idUsuarioCriador;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public Postagem(int id, String titulo, String texto) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public void setDataPublicacao(String dataPublicacao) throws ParseException {
		this.datapublicacao = formato.parse(dataPublicacao);
	}
	
	public Integer getId() {
		return this.id;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public String getTexto() {
		return this.texto;
	}
	public Date getDataPublicacao() {
		return this.datapublicacao;
	}
	public String getDataFormatada() {
		return formato.format(this.datapublicacao);
	}
	
	public void setIdUsuarioCriador(int idUsuarioCriador) {
		if(this.idUsuarioCriador == null)
			this.idUsuarioCriador = idUsuarioCriador;
	}
	
	public Integer getIdUsuarioCriador() {
		return this.idUsuarioCriador;
	}
}
