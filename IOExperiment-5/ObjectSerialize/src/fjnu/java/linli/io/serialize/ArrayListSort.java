package fjnu.java.linli.io.serialize;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListSort {

	 public static void sortStringMethod(List list){
	    	Collections.sort(list,new Comparator(){
	    		@Override
	    		public int compare(Object o1, Object o2){
	    			Student stu1 = (Student)o1;
	    			Student stu2 = (Student)o2;
	    			return stu1.getStudentID().compareTo(stu2.getStudentID());
	    		}
	    	});
	    	//排序
	    	for(int j = 0;j < list.size();j++){
	    		Student st = (Student)list.get(j);
	    		//System.out.println("学号:"+st.getStudentID()+"\t姓名："+st.getName()+"\t性别："+st.getSex());
	    	}
	    }
}

