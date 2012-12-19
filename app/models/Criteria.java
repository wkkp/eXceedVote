package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;
/**
  * Criteria of eXceed vote.
  */
@Entity
@Table(name="criteria")
public class Criteria extends Model {
	@Id
	public Long cid;
	
	@Required
	public String name;

	public static Finder<Long,Criteria> find = new Finder(
		Long.class,Criteria.class);

	public static List<Criteria> all(){
		return find.all();
	}

	public static void create(Criteria criteria){
		criteria.save();
	}

	public static void delete(Long id){
		find.ref(id).delete();
	}

	public static Criteria getCriteria(Long cid){
		Criteria c = find.where()
	    	         .eq("cid", cid)
	            	 .findUnique();
		return c;
	}

	public static void editCriteria(Long id,Criteria criteria){
		criteria.update(id);
	}

	public static boolean checkExistCriteria(Criteria criteria){
		String query = "find criteria where name = :name";

		Criteria c = find.setQuery(query)
		.setParameter("name",criteria.name)
		.findUnique();
		
		if(c == null){
			return true;
		}

		else{
			return false;
		}
	}

	public static String findCriteriaNameById(Long id) {
		return find.ref(id).name;
	}
	
}