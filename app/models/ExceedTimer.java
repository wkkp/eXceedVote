package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="exceedtimer")
public class ExceedTimer extends Model {

	@Id
	public Long id;
	public int year;
	public int month;
	public int day;
	public int hour;
	public int minute;
	public int second;

	private static final long serialVersionUID = 1L;

	public static Finder<Long, ExceedTimer> find = new Finder(Long.class, ExceedTimer.class);

	public ExceedTimer() {
	
	}

	public static ExceedTimer getTimer() {

		if (find.where().eq("id", Long.valueOf(1)).findUnique() == null) {
			System.out.println("check");
			ExceedTimer ext = new ExceedTimer();
			ext.id = Long.valueOf(1);
			ext.year = 2013;
			ext.month = 1;
			ext.day = 1;
			ext.hour = 12;
			ext.minute = 30;
			ext.second = 30;
			ext.save();
		}

		return find.where().eq("id", Long.valueOf(1)).findUnique();

	}

	public static void saveTimer(ExceedTimer ext) {
		ext.id = Long.valueOf(1);
		ext.update();
	}
}