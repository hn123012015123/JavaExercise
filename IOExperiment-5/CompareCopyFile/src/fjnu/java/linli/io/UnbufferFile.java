package fjnu.java.linli.io;

	import java.io.*;

	public class UnbufferFile {
		public void UnbufferCopy() throws Exception{
			File f1 = new File("F:\\ex.txt");
			File f2 = new File("F:\\copy2.txt");
			
			if(!f1.exists()){
				throw new IOException("文件不存在！");
			}
			
			//实例化输入流和输出流
			InputStream is = new FileInputStream(f1);
			OutputStream os = new FileOutputStream(f2);
			try {
	        	int len = is.read();  
	            while(-1 != len)  
	            {  
	            	 //逐个写入   
	                os.write(len);  
	                //逐个读取   
	                len = is.read();  
	            }  
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            is.close();
	          os.close();
	        }

		}
}
