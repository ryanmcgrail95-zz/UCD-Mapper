package functions;

import time.Delta;

public class MathExt {
	public static final float INFINITY = Float.MAX_VALUE;

	public static double rnd() {
		return Math.random();
	}
	
	public static float rnd(float max) {
		return (float) rnd()*max;
	}
	public static double rnd(double max) {
		return max*rnd();
	}
	public static float rnd(float mi, float ma) {
		return mi + rnd(ma-mi);
	}
	public static float rndSign() {
		float n;
		
		do
			n = Math.round(rnd(-1,1));
		while(n == 0);
		
		return n;
	}
	
	public static int rndi(int cap) {
		return (int) (cap*rnd());
	}
	public static int rndi(int mi, int ma) {
		return (int) (mi + rnd(ma-mi));
	}
	
	
	
	
	public static float sqr(float n) {
		return n*n;
	}
	public static float calcFastInvSqrt(float x) {
		float xhalf = 0.5f*x;
	    int i = Float.floatToIntBits(x);
	    i = 0x5f3759df - (i>>1);
	    x = Float.intBitsToFloat(i);
	    x = x*(1.5f - xhalf*x*x);
	    return x;
	}

	
	public static float min(float... values) {
		float mi = values[0];
		
		for(int i = 1; i < values.length; i++)
			mi = Math.min(mi, values[i]);
		
		return mi;
	}
	public static int min(int... values) {
		int mi = values[0];
		
		for(int i = 1; i < values.length; i++)
			mi = Math.min(mi, values[i]);
		
		return mi;
	}
	
	public static float max(float... values) {
		float ma = values[0];
		
		for(int i = 1; i < values.length; i++)
			ma = Math.max(ma, values[i]);
		
		return ma;
	}
	public static int max(int... values) {
		int ma = values[0];
		
		for(int i = 1; i < values.length; i++)
			ma = Math.max(ma, values[i]);
		
		return ma;
	}
	
	public static float squareMean(float a, float b) {
		return (float) Math.sqrt(a*a + b*b);
	}
	
	// MEAN MEDIAN MODE
		public static float mean(float... values) {
			
			if(values.length == 0)
				return 0;
			
			float sum = 0;
			for(Float v : values)
				sum += v;
			
			return sum/values.length;
		}
		public static float median(float... values) {
			boolean didSwitch;
			int i, ii = values.length;
			float temp;
			
			do {
				didSwitch = false;
				
				for(i = 1; i < ii; i++)
					if(values[i] < values[i-1]) {
						didSwitch = true;
						
						temp = values[i];
						
						values[i] = values[i-1];
						values[i-1] = temp;
					}
				
				ii--;
			} while(didSwitch);
			
			return values[values.length/2];
		}

	
	public static boolean between(float mi, float value, float ma) {
		float tMi, tMa;
		if(mi < ma) {
			tMi = mi;
			tMa = ma;
		}
		else {
			tMi = ma;
			tMa = mi;
		}
		
		return (tMi <= value && value <= tMa);
	}
	
	public static int contain(int mi, int value, int ma) {
		int tMi, tMa;
		if(mi < ma) {
			tMi = mi;
			tMa = ma;
		}
		else {
			tMi = ma;
			tMa = mi;
		}
		
		return Math.max(tMi, Math.min(value, tMa));
	}
	public static float contain(float mi, float value, float ma) {
		float tMi, tMa;
		if(mi < ma) {
			tMi = mi;
			tMa = ma;
		}
		else {
			tMi = ma;
			tMa = mi;
		}
		
		return Math.max(tMi, Math.min(value, tMa));
	}

	public static float snap(float val, float grid) {return grid*Math.round(val/grid);}
	
	public static float wrap(float mi, float value, float ma) {
		float diff = ma - mi;
		
		while(value < mi)	value += diff;
		while(value > ma)	value -= diff;
		
		return value;
	}
	
	public static float interpolate(float a, float b, float frac) {
		frac = contain(0, frac, 1);
		
		return a*(1-frac) + b*frac;
	}
	public static float grid(float x, float num) {
		return x - snap(x,num);
	}
	
	public static int floor(int value, int grid) {
		return (int) Math.floor(value/grid)*grid;
	}
	public static float floor(float value, float grid) {
		return (float) Math.floor(value/grid)*grid;
	}
	
	public static int ceil(int value, int grid) {
		return (int) Math.ceil(value/grid)*grid;
	}
	public static float ceil(float value, float grid) {
		return (float) Math.ceil(value/grid)*grid;
	}
	
	public static float round(float value, float grid) {
		return (float) Math.round(value/grid)*grid;
	}
	public static float to(float start, float to, float spd) {
		return start + Delta.convert((to - start)/spd);
	}
}
