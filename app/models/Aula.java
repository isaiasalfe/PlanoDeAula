package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="AULA")
public class Aula extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String nome;
	
	public String descricao;
	
	public Integer numero;
	
	@ManyToOne
	@JoinColumn(name="ID_SALA", referencedColumnName="ID" )
	public Sala sala;

	
	
	
	
	
	
	
	public static Finder<Long, Aula> find = new Finder<Long, Aula>(Long.class, Aula.class);
	
	public static Aula findById(Long id){
		
		return find.byId(id);
		
	}
	
	public static List<Aula> findAll(){
		
		List<Aula> aulas = new ArrayList<Aula>();
		
		try {
			
			aulas = find.all();
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(aulas == null)
			return new ArrayList<Aula>();
		else
			return aulas;
		
	}
	
	public static void create(Aula aula){
		aula.save();
	}
	
	public static void editar(Aula aula){
		aula.update();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	
}
