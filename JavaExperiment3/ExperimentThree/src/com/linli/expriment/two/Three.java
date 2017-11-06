package com.linli.expriment.two;

import com.linli.expriment.One;

public class Three {

	public static void main(String[] args) {
		One o=new One();
		o.classpb();
		//o.classpv();//不同包不同类私有方法不可访问
		//o.classpt();//不同包不同类protected不可访问
		//o.classdf();//不同包不同类default不可访问


	}

}
