package dao;

import java.util.*;
import javax.persistence.*;
import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import models.*;

@Entity
@Table(name="user")
public class UserDao 
{
	private static final long serialVersionUID = 1L;
	private int ballotqnty;
	// public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);
		/**
	 * Authenticate a User.
 	 */
	public static User authenticate(String username, String password) {
		return User.find.where()
            	   .eq("username", username)
        		   .eq("password", password)
    		       .findUnique();
	}

	/**
 	 * Regis a User.
 	 */
	public static int register(String username, String password, String verifyPassword) {
		User u = User.find.where()
	    	         .eq("username", username)
	            	 .findUnique();

	    if (u != null)
	    	return 0;
	    else if (!username.equals("") && !password.equals("") && !verifyPassword.equals("")) {
			if (password.equals(verifyPassword)) {
				if (u == null) {
					User newUser = new User(username, password);
					newUser.save();
					return 1;
				}
			}
			else
					return 2;
		}
		
		return 0;
	}

	public static User findByUsername(String username) 
	{
		return User.find.where()
                   .eq("username", username)
        		   .findUnique();
	}

	public void useBallot(int qnty) 
	{
		this.ballotqnty -= qnty;
	}
	public static int getUserTypeId(User user) {
 		return user.type_id;	
 	}
}