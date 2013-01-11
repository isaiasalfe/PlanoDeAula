package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="PROFESSOR")
public class Professor extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	@Column(name="NOME")
	public String nome;
	
	@Required
	@Column(name="TELEFONE")
	public String telefone;
	
	public String descricao;
	
	@Required
	public String email;

	@Required
	public String senha;
	
	@OneToMany(mappedBy="professor")
	public List<Sala> salas;
	
	
	
	
	
	
	
	
	public static Finder<Long, Professor> find = new Finder<Long, Professor>(Long.class, Professor.class);
	
	
	public static List<Professor> findAll(){
		
		List<Professor> professores = find.all(); 
		
		if(professores == null)
			return new ArrayList<Professor>();
		else
			return professores;
		
		
	}
	
	
	public static Professor findById(Long id){
		
		return find.byId(id);
		
	}
	
	public static void create(Professor professor){
		professor.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	
	
	
	
	
	
}
