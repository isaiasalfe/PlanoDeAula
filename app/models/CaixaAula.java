package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="CAIXA_AULA")
public class CaixaAula extends Model{
	
	private static final long serialVersionUID = 1L;
	
	private static final Integer TIPO_CAIXA_TEXTO = 1;
	private static final Integer TIPO_CAIXA_VIDEO = 2;
	private static final Integer TIPO_CAIXA_SLIDE = 3;

	@Id
	public Long id;
	
	public String valor;
	
	public String descricao;
	
	public Integer numero;
	
	public Integer tipo;
	
	@ManyToOne
	@JoinColumn(name="ID_AULA", referencedColumnName="ID" )
	public Aula aula;

	
	
	
	
	
	public static Finder<Long, CaixaAula> find = new Finder<Long, CaixaAula>(Long.class, CaixaAula.class);
	
	public static CaixaAula findById(Long id){
		
		return find.byId(id);
		
	}
	
	public static void create(CaixaAula caixaAula){
		caixaAula.save();
	}
	
	public static void editar(CaixaAula caixaAula){
		caixaAula.update();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
}
