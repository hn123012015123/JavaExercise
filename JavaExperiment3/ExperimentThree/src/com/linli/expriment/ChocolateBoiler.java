package com.linli.expriment;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler() {
		empty=true;
		boiled=false;
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
		ChocolateBoiler ch=new ChocolateBoiler();
		ch.full();
		ch.boil();
		ch.drain();

	}

	

}
