package models;

import java.util.*;
/*import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;*/

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