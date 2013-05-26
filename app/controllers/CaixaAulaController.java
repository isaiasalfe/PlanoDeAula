package controllers;

import models.Aula;
import models.CaixaAula;
import models.Sala;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CaixaAulaController extends Controller{

	static Form<CaixaAula> caixaAulaForm = form(CaixaAula.class);
	
	static Form<Aula> aulaForm = form(Aula.class);
	
	
	public static Result newCaixaAula(Long idAula){
		
		Form<CaixaAula> formularioCaixaAula = caixaAulaForm.bindFromRequest();
		
		if(formularioCaixaAula.hasErrors()){
			
			Aula aula = Aula.findById(idAula);
			
			Sala sala = aula.sala;
			return badRequest(views.html.aula.render(sala, aulaForm, caixaAulaForm));
		
		}else{
			
			CaixaAula caixaAula = formularioCaixaAula.get();
			Aula aula = Aula.findById(idAula);
			
			if(caixaAula.id != null){
				
				CaixaAula.editar(caixaAula);
			
			}else{
				
				caixaAula.aula = aula;
				
				CaixaAula.create(caixaAula);
			}
			
			return redirect(routes.AulaController.aulas(aula.sala.id));
		}
	}
	
}
