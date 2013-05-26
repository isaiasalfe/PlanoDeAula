package controllers;

import models.Aluno;
import models.Professor;
import models.Sala;
import models.SalaAluno;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class ConexaoAlunoSalaController extends Controller{

	//@Transactional(readOnly=true)
	public static Result buscarSala(Long idAluno, String codigoSala){
		
		Aluno aluno = Aluno.findById(idAluno);
		
		//Entrando na tela pela primeira vez
		if(codigoSala.equals("0"))
			return ok(views.html.conexaoAlunoSala.render(aluno, null));
		
		Sala sala = Sala.findByCodigoSala(codigoSala);
		
		//Sala não existe
		if(sala == null)
			return ok(views.html.conexaoAlunoSala.render(aluno, new Sala(0L)));
		
		//Aluno já conectado a sala
		if(aluno.salaJaConectada(sala))
			return ok(views.html.conexaoAlunoSala.render(aluno, new Sala(-1L)));
		
		//retorna a sala buscada pelo código
		return ok(views.html.conexaoAlunoSala.render(aluno, sala));
	}
	
	public static Result conectarAlunoSala(Long idAluno, Long idSala){
		
		Aluno aluno = Aluno.findById(idAluno);
		Sala sala = Sala.findById(idSala);
		
		if(aluno != null && sala != null){
			SalaAluno salaAluno = new SalaAluno(idSala, idAluno);
			SalaAluno.create(salaAluno);
		}
		
		return ok(views.html.alunoPerfil.render(aluno));
	}
	
}
