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
public class SystemController extends Controller {

	public static Result system() {
		return ok(views.html.adminSystem.render(User.findByUsername(request().username())));
	}
}