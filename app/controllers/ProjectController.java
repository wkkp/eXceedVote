package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;
import views.html.admin.*;

/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class ProjectController extends Controller {

	static Form<Project> projectForm = form(Project.class);

	public static Result projects() {
		 if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
     		return ok(adminProject.render(Project.findAllProject()
 			, projectForm
			, User.findByUsername(request().username()))
 			);
 		}

    	else
 			 return redirect(routes.ProjectController.projectsList());
		}

  	public static Result deleteProject(Long id) {
		Project.delete(id);
		return redirect(routes.ProjectController.projects());
  	}

  	public static Result projectsList() {	
  			if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
     		 return ok(adminProjectList.render(Project.findAllProject()
 			 		, User.findByUsername(request().username())));
 		}

    	else
 			 return ok(projectlist.render(Project.findAllProject()
 			 		, User.findByUsername(request().username())));	
	}
  	
	public static Result addProject() {
		Form<Project> filledForm = projectForm.bindFromRequest();

		if(filledForm.hasErrors()) {
			return badRequest(adminProject.render(Project.findAllProject()
								 						, projectForm
								 						, User.findByUsername(request().username()))
			);
		} 

		else{
			if (Project.checkExistProject(filledForm.get())) {
				Project.createProject(filledForm.get());
				return redirect(routes.ProjectController.projects());
			}
			else {
				return redirect(routes.ProjectController.projects());
			}
		}
	}
}
