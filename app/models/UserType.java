package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
/**
* Type of user that can vote.
*/
@Entity
@Table (name="usertype")
public class UserType extends Model {

	@Id
	public Long tid;
	public int user_type;
	public int ballot_qnty;

	private static final long serialVersionUID = 1L;

	public UserType() {
		super();	
	}

}