package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;

import models.*;

public class CriteriaController extends Controller {
  static Form<Criteria> criteriaForm = form(Criteria.class);

  // public static Result index() {
  //   return redirect(routes.Application.task());//ok(index.render("Your new application is ready."));
  // }

  public static Result criteria(){
  	return ok(views.html.criteria.render(Criteria.all(),criteriaForm));
  }

  public static Result newCriteria(){
  	Form<Criteria> filledForm = criteriaForm.bindFromRequest();
  	if(filledForm.hasErrors()){
  		return badRequest(
  		views.html.criteria.render(Criteria.all(),filledForm) );
  	}else {
  		Criteria.create(filledForm.get());
  		return redirect(routes.CriteriaController.criteria());
  	}

  }

  public static Result deleteCriteria(Integer id) {
    //System.out.println("----------------------");
  	 Criteria.delete(id);
  	return redirect(routes.CriteriaController.criteria());
    //return ok("Hello");
	}
  
}