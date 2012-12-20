package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

public class ExceedTimer extends Model {

	@Id
	public Integer id;
	public int day;
	public int hour;
	public int minute;
	public int second;

	private static final long serialVersionUID = 1L;

	public static Finder<Integer,ExceedTimer> find = new Finder(Integer.class, ExceedTimer.class);

	public ExceedTimer() {
	
	}

}