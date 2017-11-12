package fjun.linli.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;
 
public class FileTree {
    
        
    public static void printFile(File file) {
    	File[] fileLists = file.listFiles(); // 如果是目录，获取该目录下的内容集合 
    	ArrayList<File> fl1 = new ArrayList<File>();//获取该目录下的文件
    	ArrayList<File> fl2 = new ArrayList<File>();//获取该目录下的文件夹
    	Format simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	File f = new File("F://io.txt");
    	try {
			BufferedWriter w = new BufferedWriter(new FileWriter(f));
		 	for (int m = 0; m < fileLists.length; m++) { // 循环遍历这个集合内容
        	
	        	if (fileLists[m].isDirectory() ) {
	        		fl2.add(fileLists[m]);
	           
	        }else 
	        	continue;
	         }
	       Collections.sort(fl2);
	      for(int n=0;n<fl2.size();n++) {
	    	 Date d2 =new Date(fl2.get(n).lastModified());
	        	String datastring2 = simpleFormat.format(d2);
	        	 System.out.println(fl2.get(n).getName()+"\t"+datastring2);
	        	String s="文件夹名："+fl2.get(n).getName()+"\t"+"修改时间："+datastring2+"\r\n";
	    	  w.write(s);
	    	  
	      }
	        	   	
	    	for (int i = 0; i < fileLists.length; i++) { // 循环遍历这个集合内容        	
	        	if (fileLists[i].isFile() ) {
	        		fl1.add(fileLists[i]);           
	        }else 
	        	continue;
	         }
	       Collections.sort(fl1);
	      for(int j=0;j<fl1.size();j++) {
	    	   Date d1 =new Date(fl1.get(j).lastModified());
	        	String datastring1 = simpleFormat.format(d1);
	        	
	        	 System.out.println(fl1.get(j).getName()+"\t"+datastring1+"\t"+fl1.get(j).length());
	        	 
	        	 String  s1 = "文件名："+fl1.get(j).getName()+"\t"+"修改时间："+datastring1+"\t"+"文件大小："+fl1.get(j).length()+"字节"+"\r\n";
	        	 w.write(s1);
	      }
	     w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}