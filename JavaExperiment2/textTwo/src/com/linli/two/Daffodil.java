package com.linli.two;

public class Daffodil {
	public void FingDaffodil(){
		int a;
		int b;
		int c;
		for(int i=100;i<=999;i++){
			a=(int)i/100;
			b=((int)i/10)%10;
			c=i%10;
			if(a*a*a+b*b*b+c*c*c==i){
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		Daffodil d=new Daffodil();
		System.out.println("三位数的水仙花数为：");
		d.FingDaffodil();
		

	}

}
