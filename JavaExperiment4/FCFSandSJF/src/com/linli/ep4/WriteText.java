package com.linli.ep4;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class WriteText {
	public void WriteText(){	
		int []numbers = {6,2,1,3,9};
		        Random random = new Random();
		       // int index = random.nextInt(numbers.length);
		 String str = "";
	     FileWriter fw = null;
	     try {
	         // c盘生成txt文件并存入随机数
	         fw = new FileWriter("c:\\1.txt");
	         for(int i = 0; i < 100; i++){
	                 // 随机生成1~100以内的数
	        	 int index = random.nextInt(numbers.length);
	                 str =  i+1 + " " + i + " " + numbers[index];
	                 fw.write(str);
	                 fw.write("\r\n");
	                 fw.flush();
	             
	             
	         }
	     } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     } finally{
	         if(fw != null){
	             try {
	                 fw.close();
	             } catch (IOException e) {
	                 // TODO Auto-generated catch block
	                 e.printStackTrace();
	             }
	         }
	     }
	     }
	   
	
}
