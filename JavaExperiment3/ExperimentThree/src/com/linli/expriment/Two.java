package com.linli.expriment;

public class Two {
	public static void main(String[] args) {
	One o=new One();
	o.classpb();
	//o.classpv();//同包不同类私有方法不可访问
	o.classpt();
	o.classdf();

	}
}
