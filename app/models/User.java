package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="user")
public class User extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public int type_id;
	@Constraints.Required
	public String username;
	@Constraints.Required
	public String password;
	public int ballotqnty;
	//private String nontri_account;
	private static final long serialVersionUID = 1L;

	public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Authenticate a User.
 	 */
	public static User authenticate(String username, String password) {
		return find.where()
            	   .eq("username", username)
        		   .eq("password", password)
    		       .findUnique();
	}

	/**
 	 * Regis a User.
 	 */
	public static int register(String username, String password, String verifyPassword) {
		User u = find.where()
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

	public static User findByUsername(String username) {
		return find.where()
                   .eq("username", username)
        		   .findUnique();
	}

	public void useBallot(int qnty) {
		this.ballotqnty -= qnty;
	}
	public static int getUserTypeId(User user) {
 		return user.type_id;	
 	}

}