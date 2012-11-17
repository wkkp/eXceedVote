package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;

import models.*;

public class VoteController extends Controller {
  	static Form<Criteria> criteriaForm = form(Criteria.class);
	static Form<Project> projectForm = form(Project.class);


  public static Result vote(){
  	return ok(views.html.vote.render(Project.findAllProject(),Criteria.all()));
  }

  public static Result saveProject(Long id){
  	return ok(views.html.vote.render(Project.findAllProject(),Criteria.all()));
  }

  
}