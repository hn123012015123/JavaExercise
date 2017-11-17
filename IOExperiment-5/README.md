JAVA第五次实验-IO

实验一 基本IO操作
从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上

实现思路：1.通过终端输入内容并写入src.txt文件：
System.out.println("请输入保存到src.txt的内容：");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
2.通过调用CopyFile类的file Copy(File f1,File f2)
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
          实现文件内容的复制并保存进f2文件；最后通过输出流读取文件并显示到终端。
try{
			if(f2.isFile()&&f2.exists()){
				InputStreamReader isr =new InputStreamReader(new FileInputStream(f2),"utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				while((lineTxt=br.readLine()) != null){
					System.out.println(lineTxt);
				}
				br.close();
			}else{
				System.out.println("文件读取失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
运行结果：
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/BaseIOOperate.png)


实验二 获取系统的文件树
获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。

实现思路：在printFile(File file)函数里实现实验要求。首先定义一个文件数组获取该目录下的内容集合；
又创建两个ArrayList分别获取目录下的文件夹和文件；利用ArrayList的sort函数进行文件夹和文件的排序；
最后将需要的信息转成字符串再存入文件。
1.遍历目录下文件夹及文件，将文件夹保存在ArrayList f12里并排序
BufferedWriter w = new BufferedWriter(new FileWriter(f));
		 	for (int m = 0; m < fileLists.length; m++) { // 循环遍历这个集合内容
        	
	        	if (fileLists[m].isDirectory() ) {
	        		fl2.add(fileLists[m]);
	           
	        }else 
	        	continue;
	         }
	       Collections.sort(fl2);

2.1.遍历目录下文件夹及文件，将文件保存在ArrayList f11里并排序
for (int i = 0; i < fileLists.length; i++) { // 循环遍历这个集合内容        	
	        	if (fileLists[i].isFile() ) {
	        		fl1.add(fileLists[i]);           
	        }else 
	        	continue;
	         }
	       Collections.sort(fl1);
3.先保存文件夹信息，再保存文件信息

运行结果：
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/CompareCopyFile.png)

实验三 带缓冲区的IO
用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

实现思路：1.实现带缓冲的复制
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
2.实现不带缓冲的复制
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
3.计算各自复制时间：
long startTime1 = System.currentTimeMillis();    //获取开始时间
		BufferFile bf = new BufferFile();
		bf.BufferCopy();
		long endTime1 = System.currentTimeMillis();    //获取结束时间
		System.out.println("带缓冲字节流复制时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间

		//不带缓冲字节流复制
		long startTime2 = System.currentTimeMillis();
		UnbufferFile uf = new UnbufferFile();
		uf.UnbufferCopy();
		long endTime2 = System.currentTimeMillis();
		System.out.println("不带缓冲字节流复制时间：" + (endTime2 - startTime2) + "ms");  

运行结果：
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/FileTree.png)
实验四 对象序列化
类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，
使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。
注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。

实现思路：1.读取list.txt文件:使用 
            while (in.hasNextLine()) { // 按行读取
            String s = in.nextLine();
            int idx = s.indexOf(" ");
            int idx1 = s.indexOf(" ",idx+1);
            String s0 = s.substring(0, idx);
            String s1 = s.substring(idx + 1, idx1);
            String s2 = s.substring(idx1 + 1, s.length());
            String[] arrs = { s0, s1,s2 };
            data.add(arrs);
        }
       获取每行的三个String字段，使用数组arrs保存，再将arrs保存到ArrayList里。
2.创建学生对象：        for (int i = 0; i < data.size(); i++) {
           
        	Student s = new Student();
        	String[] arr = (String[]) data.get(i);
        	s.setStudentID(arr[0]);
        	s.setName(arr[1]);
        	s.setSex(arr[2]);
        	list.add(s);
                 }
将获取到的字段分别赋给每个学生对象。
3.使用学号进行排序：public static void sortStringMethod(List list){
	    	Collections.sort(list,new Comparator(){
	    		@Override
	    		public int compare(Object o1, Object o2){
	    			Student stu1 = (Student)o1;
	    			Student stu2 = (Student)o2;
	    			return stu1.getStudentID().compareTo(stu2.getStudentID());
	    		}
	    	});
                 }
4.使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
public static <T> void writeObjectToFile(List<T> list) {
		File file = new File("F:\\student.bin");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(list);
			objOut.flush();
			objOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
5.使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
public static <T> List<T> readObjectFromFile() {
		File file = new File("F:\\student.bin");
		FileInputStream in;
		List<T> object = null;
		try {
			in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			object = (List<T>) objIn.readObject();
			objIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (List<T>) object;
	}
注意：经过序列化读入是的student.bin里的内容为乱码，经过反序列化后得到正常的内容显示。
运行结果：
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/ObjectSerialize.png)