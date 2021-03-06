package time;

import object.primitive.Updatable;
import functions.MathExt;

public class Timer extends Updatable {
	private float time, maxTime;
	private boolean isAutomatic;
	
	
	
	// CONSTRUCTORS
		public Timer(float time, float timeMax) {
			super();
			name = "Timer";
			
			this.time = time;
			this.maxTime = timeMax;
		}
		public Timer(float timeMax) {
			super();
			
			this.time = this.maxTime = timeMax;
		}
		
		
	// NON-STATIC
		// Ticking
		public void update() {
			time = MathExt.contain(0, time-Delta.calcDeltaTime(), time);
			if(isAutomatic)
				check();
		}
		
		public void enable() {
			setDoUpdates(true);
		}
		public void disable() {
			setDoUpdates(false);
		}
		
		
		// Setting Time
		public void set(float time) {this.time = time;}
		public float get() 			{return time;}
		public void reset() 		{set(maxTime);}
		
		// Checking if Completed
		public boolean check() {
			if(time == 0) {
				reset();
				return true;
			}
			else
				 return false;
		}
		public boolean checkOnce() {
			return (time == 0);
		}
		public float getFraction() {
			return time/maxTime;
		}
		public void setMax(float mT) 	{maxTime = mT;}
		public float getMax() 			{return maxTime;}
}
