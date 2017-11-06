package com.linli;

public class PizzaStore {
	public SimplePizzaFactory si;

	public PizzaStore() {
		si=new SimplePizzaFactory();
	}


	public pizza orderPizza(String type){
		pizza pi=si.createPizza(type);
		if(type!=null){
			pi.prepare();
			pi.bake();
			pi.cut();
			pi.box();
		}
		return pi;
		
	}

}
