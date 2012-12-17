package dao;


import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import models.*;
@Entity
@Table(name="ballot")
public class BallotDao 
{
    private static final long serialVersionUID = 1L;

	// public static Finder<Long,Ballot> find = new Finder(Long.class, Ballot.class);

	public BallotDao()
	{
		
    }
	
	public static void saveBallot(Ballot ballot, User user) 
	{
		user.ballotqnty -= ballot.score;
		user.update();
		ballot.save();
	}


}