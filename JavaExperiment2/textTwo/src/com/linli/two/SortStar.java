package com.linli.two;

public class SortStar {
	
	public void ToSortStart(){
		int lay;
		lay=7;
		for(int s=1;s<=(lay+1)/2;s++){
			for(int a=1;a<=(lay+1)/2-s;a++){
				System.out.print(" ");
			}
		for(int b=1;b<=s*2-1;b++){
			System.out.print("*");
		}
		System.out.println();
		}
		
	for(int z=(lay+1)/2-1;z>=1;z--){
		for(int c=1;c<=(lay+1)/2-z;c++){
			System.out.print(" ");
		}
		for(int d=1;d<=z*2-1;d++){
			System.out.print("*");
		}
	System.out.println();
	}
	}

	public static void main(String[] args) {
		SortStar s=new SortStar();
		s.ToSortStart();
		

	}

}
