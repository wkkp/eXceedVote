// package models;

// import java.util.*;

// import play.db.ebean.*;
// import play.data.validation.Constraints.*;

// import javax.persistence.*;

// @Entity
// @Table(name="vote")
// public class Vote extends Model {
	
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.AUTO)
// 	public Long id;
// 	public Long user_id;
// 	public Long project_id;
// 	public int type_id;
// 	public double score;

// 	//private String nontri_account;
// 	private static final long serialVersionUID = 1L;

// 	//public static Finder<Long, User> find = new Finder(Long.class, User.class);

// 	public User() {
// 		super();
// 	}	

// 	public static void vote(User user,Long project_id,int type_id,double score) {

// 	}

// }