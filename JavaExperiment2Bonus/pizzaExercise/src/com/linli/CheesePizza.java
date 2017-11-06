package com.linli;

public class CheesePizza extends pizza{

	@Override
	public void prepare() {
		System.out.println("CheesePizza准备");
		
	}

	@Override
	public void bake() {
		System.out.println("CheesePizza烘焙");
		
	}

	@Override
	public void cut() {
		System.out.println("CheesePizza切割");
		
	}

	@Override
	public void box() {
		System.out.println("CheesePizza装包");
		
	}

}
