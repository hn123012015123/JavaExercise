package fjnu.java.linli.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferFile {

	public void BufferCopy() throws Exception{
		 File file = new File("F:\\ex.txt");   //源文件
	        File file2 = new File("F:\\copy1.txt");//缓冲复制文件

	        //指定读写格式为gbk
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "gbk"));
	        try {
	        	int len = br.read();  
	            while(-1 != len)  
	            {  
	                //逐个写入  
	                bw.write(len);  
	                //逐个读取  
	                len = br.read();  
	            }  
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            br.close();
	            bw.close();
	        }
	    
	}

}
