package com.linli.expriment;

public class One {
	
	  public  int pb;
	  private int pv;
	  protected int pt;
	  int df;
	  public void classpb() {
		  pb=1;
		  System.out.println("publicȨ�ޣ�"+pb);
	  }
	  private void classpv() {
		  pv=2;
		  System.out.println("privateȨ�ޣ�"+pv);
	  }
	  protected void classpt() {
		  pt=3;
		  System.out.println("protectedȨ�ޣ�"+pt);
		  
	  }
	  void classdf(){
		  df=5;
		  System.out.println("defaultȨ�ޣ�"+df);
	  }
	 


}
