package controllers;

import models.Aula;
import models.Professor;
import models.Sala;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class SalaController extends Controller{
	
	
	static Form<Sala> salaForm = form(Sala.class);
	
	
	public static Result sala(Long idProfessor){
		
		Professor professor = Professor.findById(idProfessor);
		return ok(views.html.sala.render(professor, salaForm));
	}
	
	public static Result salas(){
		
		return ok(views.html.sala.render(null, salaForm));
	}
	
	public static Result newSala(Long idProfessor){
		
		Form<Sala> formularioSala = salaForm.bindFromRequest();
		
		if(formularioSala.hasErrors()){
			
			return badRequest(views.html.sala.render(Professor.findById(idProfessor), formularioSala));
		}else{
			
			Sala sala = formularioSala.get();
			
			if(sala.id == null){
				
				sala.professor = Professor.findById(idProfessor);
				Sala.create(sala);
			
			}else{
				
				Sala.editar(sala);
			}
			return redirect(routes.ProfessorController.professorPerfil(idProfessor));
			
		}
	}
	
	public static Result deleteSala(Long id){
		return TODO;
	}
	
	public static Result editarSala(Long id){
		
		Sala sala = Sala.findById(id);
		return ok(views.html.sala.render(sala.professor, salaForm.fill(sala)));
		
	}

}
