package dao;

import java.util.*;
import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import models.*;
import javax.persistence.*;

@Entity
@Table(name="criteria")
public class CriteriaDao 
{
	// public static Finder<Long,Criteria> find = new Finder(Long.class,Criteria.class);

	public static List<Criteria> all()
	{
		 return Criteria.find.all();
	}

	public static void create(Criteria criteria)
	{
		criteria.save();
	}

	public static void delete(Long id){
		 Criteria.find.ref(id).delete();
	}

	public static boolean checkExistCriteria(Criteria criteria)
	{
		String query = "find criteria where name = :name";

		Criteria c = Criteria.find.setQuery(query)
		.setParameter("name",criteria.name)
		.findUnique();
		
		if(c == null)
		{
			return true;
		}

		else
		{
			return false;
		}
		
	}
} 