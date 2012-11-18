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
public class ProjectController extends Controller {

	static Form<Project> projectForm = form(Project.class);

	public static Result projects() {
		 if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
     		return ok(project.render(Project.findAllProject()
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
      		return ok(projectlist.render(Project.findAllProject(), User.findByUsername(request().username())));	
	}
  	
	public static Result addProject() {
		Form<Project> filledForm = projectForm.bindFromRequest();

		if(filledForm.hasErrors()) {
			return badRequest(views.html.project.render(Project.findAllProject()
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
