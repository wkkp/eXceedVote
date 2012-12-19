package models;

import java.util.*;

/*
	Ballot box contains quantity of this ballot.
*/
public class BallotBox {

	public int ballot_qnty;
	
	public BallotBox() {
	}	
	
	public static boolean checkQuantity(User user, BallotBox box) {

		System.out.println("greeting");
		
		if (box.ballot_qnty <= user.ballotqnty)
			return true;
		else
			return false;	
	}
		
}