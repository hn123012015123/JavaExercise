package com.linli.two;

public class RunYear {
	
	public int low;
	public int high;
	
	public RunYear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RunYear(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	
	public void judge(){
		low=1990;
		high=2007;
		System.out.println("1990至2007年中闰年有：");
		for(int i=low;i<=high;i++){
			if(((i%4==0)&&(i%100!=0))||(i%400==0)){
				System.out.println(i+"年");
			}
		}
		
		
		
	}

	public static void main(String[] args) {
		RunYear r=new RunYear();
		r.judge();
		

	}

}
