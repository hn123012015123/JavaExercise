package com.linli.two;

public class GradeScore {
	public String ToGradeScore(double[] a){
	
	int s;
	for(int i=0;i<a.length;i++){
		 s=(int)a[i]/10;
		switch(s){
		case 0:System.out.println(a[i]+":������");break;
		case 1:System.out.println(a[i]+":������");break;
		case 2:System.out.println(a[i]+":������");break;
		case 3:System.out.println(a[i]+":������");break;
		case 4:System.out.println(a[i]+":������");break;
		case 5:System.out.println(a[i]+":������");break;
		case 6:System.out.println(a[i]+":����");break;
		case 7:System.out.println(a[i]+":��");break;
		case 8:System.out.println(a[i]+":��");break;
		case 9:System.out.println(a[i]+":��");break;
		case 10:System.out.println(a[i]+":��");break;
		
		}
		
	}
	return null;
	}

	public static void main(String[] args) {
		GradeScore g=new GradeScore();
		double[] a=new double[]{56,78,96,81,63};
		g.ToGradeScore(a);

	}

}
