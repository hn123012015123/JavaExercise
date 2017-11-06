package com.linli.expriment;

public class One {
	
	  public  int pb;
	  private int pv;
	  protected int pt;
	  int df;
	  public void classpb() {
		  pb=1;
		  System.out.println("public权限："+pb);
	  }
	  private void classpv() {
		  pv=2;
		  System.out.println("private权限："+pv);
	  }
	  protected void classpt() {
		  pt=3;
		  System.out.println("protected权限："+pt);
		  
	  }
	  void classdf(){
		  df=5;
		  System.out.println("default权限："+df);
	  }
	 


}
