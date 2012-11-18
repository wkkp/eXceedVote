package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;

import models.*;

/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class VoteController extends Controller {

	static Form<Criteria> criteriaForm = form(Criteria.class);
	static Form<Project> projectForm = form(Project.class);


	public static Result vote(){
  		return ok(vote.render(Project.findAllProject()
  				      , Criteria.all()
  				      , criteriaForm
  				      , Exceed.getUserInSession())
  		);
	}

	public static Result saveProject(Long id){
		return ok(vote.render(Project.findAllProject()
				      , Criteria.all()
				      , criteriaForm
				      , Exceed.getUserInSession())
		);
	}

	public static Result voteForProject() {
		Form<Criteria> cff = criteriaForm.bindFromRequest();
		System.out.println(cff.get().name);
		return TODO;	
	}
  
}
