package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

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

	
}