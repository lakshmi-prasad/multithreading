package designpatt_Singleton;

/*
Singleton pattern is one of the most commonly used patterns in Java. 
It is used to control the number of objects created by preventing external instantiation and modification. 
This concept can be generalized to systems that operate more efficiently when only one object exists, or that 
restrict the instantiation to a certain number of objects, such as:

private constructor - no other class can instantiate a new object.
private reference - no external modification.
public static method is the only place that can get an object.
*/

public class SingletonExample {
	public static void main(String[] args) {
		System.out.println(MySingleton.INSTANCE);
	}

}
//from stackoverflow - enum singleton
 enum MySingleton {
	    INSTANCE;
	    private MySingleton() {
	        System.out.println("Here");
	    }
}

//LAZY mode:
class CTO {
	private static CTO ctoObj = new CTO();
	
	private CTO() {}
	
	public static CTO getCTO() {
		if (ctoObj == null) {
			ctoObj = new CTO();
		}
		return ctoObj;
	}
}

class CEO {
	//CEO is declared final so that it will always contain the same object reference.
	private static final CEO ceoObj = new CEO();
	
	private CEO() {}
	
	public static CEO getCEO() {
		return ceoObj;
	}
}
