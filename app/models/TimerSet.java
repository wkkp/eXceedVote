package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
/*
	Set valid time of voting by date.
*/
public class TimerSet extends Model {
	
	private static int day;
	private static int month;
	private static int year;
	private static int hr;
	private static int min;
	private static int sec;
	
	public TimerSet(int day,int month,int year,int hr,int min, int sec){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hr = hr;
		this.min = min;
		this.sec = sec;
	}

	public TimerSet(int day,int month,int year){
		 this.day = day;
		this.month = month;
		this.year = year;
	}

	public static int getDay(){
		return day;
	}

	public static int getMonth(){
		return month;
	}

	public static int getYear(){
		return year;
	}

	public int getHr(){
		return hr;
	}

	public int getMin(){
		return min;
	}

	public int getSec(){
		return sec;
	}

}