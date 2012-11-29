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
		if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
     		 return ok(views.html.adminHome.render(User.findByUsername(request().username()))
     		 	);
 		}

    	else{
			return ok(home.render(
			User.findByUsername(request().username()))
			);
		}
	}
}