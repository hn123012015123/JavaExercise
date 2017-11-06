package com.linli;

public class PepperoniPizza extends pizza{

	@Override
	public void prepare() {
		System.out.println("PepperoniPizza准备");
		
	}

	@Override
	public void bake() {
		System.out.println("PepperoniPizza烘焙");
		
	}

	@Override
	public void cut() {
		System.out.println("PepperoniPizza切割");
		
	}

	@Override
	public void box() {
		System.out.println("PepperoniPizza装包");
		
	}

}
