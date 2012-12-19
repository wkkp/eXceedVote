package models;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

class ExceedTimer {

	public int hour;
	public int minute;
	public int second;

	public Timer timer;

	public ExceedTimer(int hour, int minute, int second) {
		timer = new Timer();
		timer.schedule(new RemindTask(), hour*60*60*1000 + minute*60*1000 + second*1000);
	}

	class RemindTask extends TimerTask {
		public void run() {
			timer.cancel();
		}
	}

}