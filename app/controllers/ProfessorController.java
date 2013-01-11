package controllers;

import models.Professor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ProfessorController extends Controller{

	
	static Form<Professor> professorForm = form(Professor.class);
	
	
	public static Result professor(){
		
		return ok(views.html.professor.render(null, professorForm));
	}
	
	public static Result professores(){
		
		return ok(views.html.professor.render(Professor.findAll(), professorForm));
	}
	
	public static Result newProfessor(){
		
		Form<Professor> formularioProfessor = professorForm.bindFromRequest();
		
		if(formularioProfessor.hasErrors()){
			return badRequest(views.html.professor.render(Professor.findAll(), formularioProfessor));
		}else{
			Professor.create(formularioProfessor.get());
			return redirect(routes.ProfessorController.professores());
		}
	}
	
	public static Result deleteProfessor(Long id){
		return TODO;
	}
	
	public static Result professorPerfil(Long id){
		
		Professor professor = Professor.findById(id);
		return ok(views.html.professorPerfil.render(professor));
	}
	
	
	
}
