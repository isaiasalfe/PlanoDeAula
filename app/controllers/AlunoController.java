package controllers;

import models.Aluno;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class AlunoController extends Controller{

	
	static Form<Aluno> alunoForm = form(Aluno.class);
	
	
	public static Result aluno(){
		
		return ok(views.html.aluno.render(null, alunoForm));
	}
	
	public static Result alunos(){
		
		return ok(views.html.aluno.render(Aluno.findAll(), alunoForm));
	}
	
	public static Result newAluno(){
		
		Form<Aluno> formularioAluno = alunoForm.bindFromRequest();
		
		if(formularioAluno.hasErrors()){
			return badRequest(views.html.aluno.render(Aluno.findAll(), formularioAluno));
		}else{
			Aluno.create(formularioAluno.get());
			return redirect(routes.AlunoController.alunos());
		}
	}
	
	public static Result deleteAluno(Long id){
		return TODO;
	}
	
	public static Result alunoPerfil(Long id){
		
		Aluno aluno = Aluno.findById(id);
		return ok(views.html.alunoPerfil.render(aluno));
	}
	
	
	
}
