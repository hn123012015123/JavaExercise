package com.linli;

public class ClamPizza extends pizza{

	@Override
	public void prepare() {
		System.out.println("ClamPizza准备");
		
	}

	@Override
	public void bake() {
		System.out.println("ClamPizza烘焙");
		
	}

	@Override
	public void cut() {
		System.out.println("ClamPizza切割");
		
	}

	@Override
	public void box() {
		System.out.println("ClamPizza装包");
		
	}

}
