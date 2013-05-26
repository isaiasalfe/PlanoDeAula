package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name="ALUNO")
public class Aluno extends Model{

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
	
	@ManyToMany
	@JoinTable(name="SALA_ALUNO", 
			joinColumns={@JoinColumn(name="ID_ALUNO")},
			inverseJoinColumns={@JoinColumn(name="ID_SALA")})
	public List<Sala> salas;
	
	
	
	
	
	
	public static Finder<Long, Aluno> find = new Finder<Long, Aluno>(Long.class, Aluno.class);
	
	
	public static List<Aluno> findAll(){
		
		List<Aluno> alunos = find.all(); 
		
		if(alunos == null)
			return new ArrayList<Aluno>();
		else
			return alunos;
		
		
	}
	
	
	public static Aluno findById(Long id){
		
		return find.byId(id);
		
	}
	
	public static void create(Aluno aluno){
		aluno.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	public boolean salaJaConectada(Sala sala){
		
		if(this.salas.contains(sala))
			return true;
		
		return false;
	}
	
	
	
	
	
}
