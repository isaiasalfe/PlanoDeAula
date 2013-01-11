package controllers;

import models.Aula;
import models.Sala;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class AulaController extends Controller{

	static Form<Aula> aulaForm = form(Aula.class);
	
	public static Result aulas(Long idSala){
		
		Sala sala = Sala.findById(idSala);
		
		return ok(views.html.aula.render(sala, aulaForm));
	}
	
	public static Result newAula(Long idSala){
		
		Form<Aula> formularioAula = aulaForm.bindFromRequest();
		
		if(formularioAula.hasErrors()){
			
			Sala sala = Sala.findById(idSala);
			return badRequest(views.html.aula.render(sala, formularioAula));
		
		}else{
			
			Aula aula = formularioAula.get();

			if(aula.id != null){
				
				Aula.editar(aula);
			
			}else{
				aula.sala = Sala.findById(idSala);
				Aula.create(aula);
			}
			
			return redirect(routes.AulaController.aulas(idSala));
		}
	}
	
	public static Result deleteAula(Long id){

		Aula aula = Aula.findById(id);
		
		Sala sala = Sala.findById(aula.sala.id);
		Aula.delete(id);

		return ok(views.html.aula.render(sala, aulaForm));
	}
	
	
	public static Result editarAula(Long id, Long idSala){
		
		Aula aula = Aula.findById(id);
		
		if(aula == null){
			Sala sala = Sala.findById(idSala);
			return ok(views.html.aula.render(sala, aulaForm));
		}
		
		Sala sala = Sala.findById(idSala);
		return ok(views.html.aula.render(sala, aulaForm.fill(aula)));
		
	}
	
}
