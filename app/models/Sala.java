package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="SALA")
public class Sala extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String nome;
	
	@Required
	public String disciplina;
	
	public String descricao;
	
	public String escola;
	
	@ManyToOne
	@JoinColumn(name="ID_PROFESSOR", referencedColumnName="ID" )
	public Professor professor;
	
	@OneToMany(mappedBy="sala")
	@OrderBy(value="numero")
	public List<Aula> aulas;

	
	
	
	
	
	
	
	public static Finder<Long, Sala> find = new Finder<Long, Sala>(Long.class, Sala.class);
	
	
	public static Sala findById(Long id){
		
		return find.byId(id);
		
	}
	
	public static List<Sala> findAll(){
		
		List<Sala> salas = find.all(); 
		
		if(salas == null)
			return new ArrayList<Sala>();
		else
			return salas;
		
		
	}
	
	public static void create(Sala sala){
		
		sala.save();
	}
	
	public static void editar(Sala sala){
		sala.update();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	
}
