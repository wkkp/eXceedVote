package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;

import models.*;

/**
 * Controller of criteria .
 */
@Security.Authenticated(Secured.class)
public class CriteriaController extends Controller {
		
	static Form<Criteria> criteriaForm = form(Criteria.class);

	// public static Result index() {
	//   return redirect(routes.Application.task());
	// ok(index.render("Your new application is ready."));
	// }

	public static Result criteria(){

		if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
			return ok(views.html.adminCriteria.render(Criteria.all(),criteriaForm, User.findByUsername(request().username())));
		}
 		else
			return redirect(routes.Home.home());
		}

	public static Result newCriteria(){
		
		Form<Criteria> filledForm = criteriaForm.bindFromRequest();
		if(filledForm.hasErrors()){
			return badRequest(views.html.adminCriteria.render(Criteria.all(),filledForm, User.findByUsername(request().username())));
		} else {

			if(Criteria.checkExistCriteria(filledForm.get())){
				Criteria.create(filledForm.get());
				return redirect(routes.CriteriaController.criteria());
			}

			else{
				return redirect(routes.CriteriaController.criteria());
			}
		}
	}

	public static Result getCriteria(Long id){
		return ok(views.html.adminCriteriaEdit.render(Criteria.all(),criteriaForm, User.findByUsername(request().username()),Criteria.getCriteria(id) ));
	}

	public static Result editCriteria(Long id){
		
		Form<Criteria> filledForm = criteriaForm.bindFromRequest();

		Criteria.editCriteria(id,filledForm.get());

		return redirect(routes.CriteriaController.criteria());
	}	

	public static Result deleteCriteria(Long id) {
		//System.out.println("----------------------");
		Criteria.delete(id);
		return redirect(routes.CriteriaController.criteria());
		//return ok("Hello");
	}

}
