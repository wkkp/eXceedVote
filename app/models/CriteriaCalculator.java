package models;

import java.util.*;

public class CriteriaCalculator {
	
	static List<Project> projects;
	static List<Criteria> criteria;
	static Long[][] rank;
	static int index;

	public CriteriaCalculator() {
		projects = Project.findAllProject();
		criteria = Criteria.all();	
		rank = new Long[criteria.size()][4];
	}

	public static void calculateCriteria() {
		index = 0;

		for (Criteria c : criteria) {
			int max = 0;
			Long project = 0L;
			for (Project p : projects) {
				List<Ballot> ballots = Ballot.getBallotsByIdAndCriteriaId(p.pid, c.cid);
				if (max < ballots.size()) {
					max = ballots.size();
					project = p.pid;
				}
			}
			
			rank[index][0] = c.cid;
			rank[index][1] = project;
			rank[index][2] = Long.valueOf(max);
			rank[index][3] = Long.valueOf(index+1);
			index++;
		}	
	}

	public static Long[][] getRank() {
		return rank;
	}
}