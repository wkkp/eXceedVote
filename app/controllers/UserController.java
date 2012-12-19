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
public class UserController extends Controller {

	public static Result userManager() {
		return ok(views.html.adminUser.render(User.getAllUsers()
											, User.findByUsername(request().username())));
	}
}