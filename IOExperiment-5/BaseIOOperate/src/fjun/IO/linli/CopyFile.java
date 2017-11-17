package fjun.IO.linli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFile {
   public void fileCopy(File s1,File s2) {
	   FileInputStream fi = null;
	   FileOutputStream fo = null;
	   FileChannel in = null;
	   FileChannel out = null;
	  
	   try {
		fi=new FileInputStream(s1);
		fo=new FileOutputStream(s2);
		   in=fi.getChannel();
		   out=fo.getChannel();
		   in.transferTo(0, in.size(), out);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			fi.close();
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
   }
}
