package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;

/**
 *  Home page of eXceed vote .
 */
@Security.Authenticated(Secured.class)
public class Home extends Controller {

	public Home() {
		super();
	}	

	public static Result home() {
		TimerSet ts = new TimerSet(25,12,2012);
		if(User.getUserTypeId(User.findByUsername(request().username())) == 9) {
     		 return ok(views.html.adminHome.render(User.findByUsername(request().username()))
     		 	);
 		}

    	else{
			return ok(home.render(
			User.findByUsername(request().username()),ts ) 
			);
		}
	}
}