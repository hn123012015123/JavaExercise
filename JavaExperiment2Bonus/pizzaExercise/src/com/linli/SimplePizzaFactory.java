package com.linli;

public class SimplePizzaFactory {
	pizza p1=new CheesePizza();
	pizza p2=new PepperoniPizza();
	pizza p3=new ClamPizza();
	public pizza createPizza(String type){
		if(type=="cheese"){
			return p1;
		}
		else if(type=="pepperoni"){
			return p2;
		}
		else if(type=="clam"){
			return p3;
		}
		else {
			pizza p4=null;
			System.out.println(" ‰»Î¥ÌŒÛ");
			return p4;
		}
		
	}

}
