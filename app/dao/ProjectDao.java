package dao;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;
import play.*;
import play.mvc.*;
import play.data.*;
import javax.persistence.*;
import models.*;

@Entity
@Table(name="project")
public class ProjectDao 
{
	private static final long serialVersionUID = 1L;

	// public static Finder<Long, Project> find = new Finder(Long.class, Project.class);

	public static void createProject(Project project) 
	{ 
		project.save();
	}

	public static List<Project> findAllProject()
	{
		return Project.find.all();
	}

	public static boolean checkExistProject(Project project){
		String query = "find project where name = :name";

		Project p = Project.find.setQuery(query)
		.setParameter("name",project.name)
		.findUnique();

		if(p == null){
			return true;
		}

		else{
			return false;
		}
	}

	public static void delete(Long id){
		 Project.find.ref(id).delete();
	}	
}