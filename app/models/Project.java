package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long pid;
	public String name;
	@Column(columnDefinition = "TEXT")
	public String description;
	
	private static final long serialVersionUID = 1L;

	public static Finder<Long, Project> find = new Finder(Long.class, Project.class);

	public static void createProject(Project project) { 
		project.save();
	}

	public static List<Project> findAllProject(){
		return find.all();
	}

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

	public static void delete(Long id){
		 find.ref(id).delete();
	}	
}
