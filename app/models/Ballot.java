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
	
	public Ballot(Long uid, Long pid, Long cid) {
		super();
		this.user_id = uid;
		this.project_id = pid;
		this.criteria_id = cid;
	}

	public static void saveBallot(Ballot ballot, User user, int qnty) {
		Long tuser_id = ballot.user_id;
		Long tproject_id = ballot.project_id;
		Long tcriteria_id = ballot.criteria_id;
		
		for (int i = 0; i < qnty; i++) {
			Ballot b = new Ballot(tuser_id, tproject_id, tcriteria_id);
			b.save();
		}
	}
}
