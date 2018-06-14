package Designs;

public class DesignOOPTrafficLight {
	/*
	 * https://www.gofpatterns.com/design-patterns/module2/abstract-traffic-signal-exercise-result.php
	 */
	public abstract class TrafficSignal {

		  public final static int GO = 0;
		  public final static int CAUTION = 1;
		  public final static int STOP = 2;
		  public final static int NUMBER_OF_STATES = 3;

		  boolean passageRequested = false;
		  int state = STOP;

		  public boolean getPassageRequested() {
		    return passageRequested;
		  }

		  public void requestPassage() {
		    if (state == STOP) {
		      passageRequested = true;
		    }
		  }
		  
		  public void passageGranted() {
		    passageRequested = false;
		  }
		  
		  public void changeState() {
		    this.state = (state + 1) % NUMBER_OF_STATES;
		    if (state == GO) {
		      passageRequested = false;
		    }
		  }

		  public int getState() {
		    return state;    
		  }

		  public abstract String getMessage();
		  
		  public String toString() {
		    return "[" + getClass() + ": " + direction + " " 
		    + getMessage() + " " + passageRequested + "]";
		  
		  }
		  
		  // a simple main() method to test the class,
		  // not required by the problem specification
		  // but never a bad idea
		  public static void main(String[] args) {
		    
		    WalkSign w1 = new WalkSign(0);
		    for (int i = 0; i <= NUMBER_OF_STATES; i++) {
		      System.out.println(w1.getMessage());
		      w1.changeState();
		    }
		    
		    TrafficLight t1 = new TrafficLight(90);
		    for (int i = 0; i <= NUMBER_OF_STATES; i++) {
		      System.out.println(t1.getMessage());
		      t1.changeState();
		    }
		        
		  }
		  
		}
	
	public class TrafficLight extends TrafficSignal {
		public String getMessage() {
			switch (state) {
			case STOP:
				return "red";
			case GO:
				return "green";
			case CAUTION:
				return "yellow";
			default:
				return "illegal state";
			}
		}
	}
	
	public class WalkSign extends TrafficSignal {
		public String getMessage() {

			switch (state) {
			case STOP:
				return "Don't Walk";
			case GO:
				return "Walk";
			case CAUTION:
				return "Flashing Don't Walk";
			default:
				return "illegal state";
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
