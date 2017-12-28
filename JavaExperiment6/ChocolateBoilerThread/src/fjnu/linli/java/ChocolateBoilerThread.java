package fjnu.linli.java;

public class ChocolateBoilerThread {

	private boolean empty;
	private boolean boiled;
	private static ChocolateBoilerThread uniqueInstance;
	
	private ChocolateBoilerThread() {
		empty=true;
		boiled=false;
	}
	
	public static synchronized ChocolateBoilerThread getInstance() 
	{ 
	  if (uniqueInstance==null){ 
	  uniqueInstance = new ChocolateBoilerThread(); 
	} 
	  return uniqueInstance; 
	} 
 
	public boolean isEmpty() {
		return empty;
	}
	public boolean isBoiled() {
		return boiled;
	}
	public void full() {
		if(isEmpty()) {
			System.out.println("填充巧克力和牛奶");
			empty=false;
		}
	}
	
	public void boil() {
		if(!isEmpty()&&!isBoiled()) {
			System.out.println("将混合物煮沸");
			boiled=true;
		}
	}
	public void drain() {
		if(!isEmpty()&&isBoiled()) {
			System.out.println("倒出混合物");
			empty=true;
			boiled=false;
		}
	}
	public static void main(String[] args) {
		ChocolateBoilerThread ch=new ChocolateBoilerThread();
		ch.full();
		ch.boil();
		ch.drain();
		ChocolateBoilerThread boiler2= ChocolateBoilerThread.getInstance();
	}

}
