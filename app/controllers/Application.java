package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

public class Application extends Controller {
  
        /**
    	 * Authentication
    	 */
    	public static class Login {
        
        	public String username;
        	public String password;
        
        	public String validate() {
            		if(User.authenticate(username, password) == null) {
                		return "Invalid user or password";
            		}
            		return null;
        	}
        
    	}

	    /**
    	 * Registeration
    	 */
    	public static class Regis {
        
        	public String username;
        	public String password;
        
        	public String validate() {
            		if(User.register(username, password) == false) {
                		return "Cannot register with this username";
            		}
            		return null;
        	}
        
    	}

    	/**
     	 * Login page.
     	 */
    	public static Result login() {
        	return ok(
            		login.render(form(Login.class))
        	);
    	}
    
    	/**
      	 * Handle login form submission.
     	 */
    	public static Result authenticate() {
        	Form<Login> loginForm = form(Login.class).bindFromRequest();
        	if(loginForm.hasErrors()) {
            		return badRequest(login.render(loginForm));
        	} else {
            		session("username", loginForm.get().username);
            		return redirect(routes.Home.home());
        	}
    	}

    	/**
     	 * Logout and clean the session.
     	 */
   	    public static Result logout() {
        	session().clear();
        	flash("success", "You've been logged out");
            return redirect(routes.Application.login());
    	}

    	/**
    	 * Regis Page.
    	 */
    	public static Result regis() {
    		return ok(
    			regis.render(form(Regis.class))
    		);	
    	}

    	/**
    	 * Handle regis form submission.
    	 */
    	public static Result register() {
    		Form<Regis> regisForm = form(Regis.class).bindFromRequest();
    		if (regisForm.hasErrors()) {
    			return badRequest(regis.render(regisForm));
    		}
    		else {
    			return redirect(routes.Application.login());
    		}	
    	}

}