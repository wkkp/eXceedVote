package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;
/*
	Information and structure of each project.
 */
@Entity
@Table(name="project")
public class Project extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long pid;
	public String name;
	@Column(columnDefinition = "TEXT")
	public String description;
	public String imageUrl;
	public String imageUrl2;
	
	private static final long serialVersionUID = 1L;

	public static Finder<Long, Project> find = new Finder(Long.class, Project.class);

	public static void createProject(Project project) { 
		project.save();
	}

	public static List<Project> findAllProject(){
		return find.all();
	}
    /*
	*
	*	Check if this project is exist in database.
    */
	public static boolean checkExistProject(Project project){
		String query = "find project where name = :name";

		Project p = find.setQuery(query)
		.setParameter("name",project.name)
		.findUnique();

		if(p == null){
			return true;
		}

		else{
			return false;
		}
	}
	/*
	* delete project by id.
	*/
	public static void delete(Long id){
		 find.ref(id).delete();
	}

	public static Project getProject(Long pid){
		 Project p = find.where()
	    	         .eq("pid", pid)
	            	 .findUnique();
		return p;
	}

	public static void editProject(Long id,Project project){
		project.update(id);
	}	
}
