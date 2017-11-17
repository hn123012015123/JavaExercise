package fjnu.java.linli.io.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "F:\\list.txt";
        Scanner in = new Scanner(new File(path));
        List data = new ArrayList();
        ArrayList list = new ArrayList();
        while (in.hasNextLine()) {
            // 按行读取
            String s = in.nextLine();
            int idx = s.indexOf(" ");
            int idx1 = s.indexOf(" ",idx+1);
            String s0 = s.substring(0, idx);
            String s1 = s.substring(idx + 1, idx1);
            String s2 = s.substring(idx1 + 1, s.length());
            String[] arrs = { s0, s1,s2 };
            data.add(arrs);
        }
        for (int i = 0; i < data.size(); i++) {
           
        	Student s = new Student();
        	String[] arr = (String[]) data.get(i);
        	s.setStudentID(arr[0]);
        	s.setName(arr[1]);
        	s.setSex(arr[2]);
        	list.add(s);
        	//String[] arr = (String[]) data.get(i);
            //System.out.println("第" + (i + 1) + "行:" + arr[0] + "\t" + arr[1]+ "\t" + arr[2]);
        }
        ArrayListSort as = new ArrayListSort();
        as.sortStringMethod(list);
        
    
        
        WriteAndRead wr = new WriteAndRead();
        wr.writeObjectToFile(list);
        List<Student> lists=wr.readObjectFromFile();
        for (int i = 0; i < lists.size(); i++)  {
            System.out.println("学号："+lists.get(i).getStudentID()+"     姓名："+lists.get(i).getName()+"     性别："+lists.get(i).getSex());  
    }  
    }  
        
    
    
   
}
