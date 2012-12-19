package models;

import java.util.*;

public class RankingsCalculator {

	static List<Project> projects;
	static Long[][] rank;
	static int index;

	public RankingsCalculator() {
		projects = Project.findAllProject();	
		rank = new Long[projects.size()][3];
	}

	public static void calculateRank() {
		index = 0;
		for (Project p : projects) {
			List<Ballot> ballots = Ballot.getBallotsById(p.pid);
			rank[index][0] = p.pid;
			rank[index][1] = Long.valueOf(ballots.size());
			rank[index][2] = Long.valueOf(index+1);
			index++;
		}	
	}

	public static void sortRank() {
		Long swapL;
		for (int i = 0; i < projects.size(); i++) {
			for (int j = i+1; j < projects.size(); j++) {
				if (rank[i][1] < rank[j][1]) {
					swapL = rank[i][1];
					rank[i][1] = rank[j][1];
					rank[j][1] = swapL;
					swapL = rank[i][0];
					rank[i][0] = rank[j][0];
					rank[j][0] = swapL;
				}
			}
		}
	}

	public static Long[][] getRank() {
		return rank;
	}

	public static int getSize() {
		return projects.size();
	}
}