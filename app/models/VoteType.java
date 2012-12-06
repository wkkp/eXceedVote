package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table (name="votetype")
public class VoteType extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long vid;
	public int vote_type;
	public int vote_criterion;
	
	private static final long serialVersionUID = 1L;	public VoteType() {
		super();		
	}

}