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
	
	public static class VoteCollector {
    
    	public Integer criteriaId;
    	public Long projectId;
    
    }	

	public static Result vote(){

		if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
     		 return ok(views.html.adminVote.render(Project.findAllProject()
  				      , Criteria.all()
  				      , criteriaForm
  				      , projectForm
  				      , User.findByUsername(request().username()))
     		 		);
 		}

    	else{
			return ok(vote.render(Project.findAllProject()
  				      , Criteria.all()
  				      , criteriaForm
  				      , projectForm
  				      , User.findByUsername(request().username()))
  					);
		}



  		
	}

	public static Result saveProject(Long id){
		return ok(vote.render(Project.findAllProject()
				      , Criteria.all()
				      , criteriaForm
				      , projectForm
				      , User.findByUsername(request().username()))
		);
	}

	public static Result voteForProject() {
		return TODO;	
	}
  
}
