package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="ballot")
public class Ballot extends Model {

	@Id
	public Long bid;
	public Long user_id;
	public Long project_id;
	public Long criteria_id;
	public int score;
	private static final long serialVersionUID = 1L;

	public static Finder<Long,Ballot> find = new Finder(Long.class, Ballot.class);

	public Ballot() {
		super();	
	}

	public static void saveBallot(Ballot ballot, User user) {
		if (user.ballotqnty >= ballot.score) {
			user.ballotqnty -= ballot.score;
			user.update();
			ballot.save();
		}
	}

}