package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="SALA_ALUNO")
public class SalaAluno extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Column(name="ID_SALA")
	public Long idSala;
	
	@Column(name="ID_ALUNO")
	public Long idAluno;
	
	public SalaAluno(){
		
	}
	
	public static Finder<Long, SalaAluno> find = new Finder<Long, SalaAluno>(Long.class, SalaAluno.class);
	
	public SalaAluno(Long idSala, Long idAluno){
		this.idSala = idSala;
		this.idAluno = idAluno;
	}
	
	public static void create(SalaAluno salaAluno){
		salaAluno.save();
	}
	
}
