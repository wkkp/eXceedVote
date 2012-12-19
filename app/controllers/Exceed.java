package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;
/**
  *    
  * 
  */
public class Exceed extends Controller {

	private static User userInSession;

	public Exceed() {

	}

	public static void setUserInSession(String username) {
		userInSession = User.find
				    .where()
				    .eq("username", username)
				    .findUnique();
	}

	public static User getUserInSession() {
		return userInSession;
	}
}