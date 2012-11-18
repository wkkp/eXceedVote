package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;

/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class Home extends Controller {

	public Home() {
		super();
	}	

	public static Result home() {
		/*return ok(home.render(
			User.find.where()
			.eq("username", request().username())
			.findUnique())
		);*/
		return ok(home.render(Exceed.getUserInSession()));
	}
}