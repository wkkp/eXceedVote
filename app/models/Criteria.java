package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="criteria")
public class Criteria extends Model {
	@Id
	public Integer id;
	
	@Required
	public String name;

	public static Finder<Integer,Criteria> find = new Finder(
		Integer.class,Criteria.class);

	public static List<Criteria> all(){
		return find.all();
	}

	public static void create(Criteria criteria){
		criteria.save();
	}

	public static void delete(Integer id){
		find.ref(id).delete();
	}

	
}