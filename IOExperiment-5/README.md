JAVA�����ʵ��-IO

ʵ��һ ����IO����
�Ӽ��̽����ֽ���
д�뵽��ǰĿ¼�µ�src.txt�ļ���
��src.txt�ļ����ݸ��Ƶ���ǰĿ¼��dest.txt�ļ���
��dest.txt�ļ�������ʾ����Ļ��

ʵ��˼·��1.ͨ���ն��������ݲ�д��src.txt�ļ���
System.out.println("�����뱣�浽src.txt�����ݣ�");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
2.ͨ������CopyFile���file Copy(File f1,File f2)
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
          ʵ���ļ����ݵĸ��Ʋ������f2�ļ������ͨ���������ȡ�ļ�����ʾ���նˡ�
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
				System.out.println("�ļ���ȡʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
���н����
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/BaseIOOperate.png)


ʵ��� ��ȡϵͳ���ļ���
��ȡĳ��Ŀ¼�µ�Ŀ¼��Ϣ��Ŀ¼�ӿ���̨���롣
Ŀ¼��Ϣ������Ŀ¼�µ������ļ����ļ��е��б�����ÿ���ļ�����ʾ�����ƣ��޸����ڡ�����ÿ���ļ���ʾ�����ƣ��޸����ںʹ�С��
Ŀ¼����Ϣд�����ļ��С�ע�⣬�ļ���Ϣ���Ȱ����ͷ��࣬�ļ�����ǰ���ļ��ں󣬲������Ǹ��԰����ļ����ַ�����˳������
��չ�Լ���ѧ���֣�����JAVA��GUI��Swing�ȣ�����һ�����׵��ļ��������

ʵ��˼·����printFile(File file)������ʵ��ʵ��Ҫ�����ȶ���һ���ļ������ȡ��Ŀ¼�µ����ݼ��ϣ�
�ִ�������ArrayList�ֱ��ȡĿ¼�µ��ļ��к��ļ�������ArrayList��sort���������ļ��к��ļ�������
�����Ҫ����Ϣת���ַ����ٴ����ļ���
1.����Ŀ¼���ļ��м��ļ������ļ��б�����ArrayList f12�ﲢ����
BufferedWriter w = new BufferedWriter(new FileWriter(f));
		 	for (int m = 0; m < fileLists.length; m++) { // ѭ�����������������
        	
	        	if (fileLists[m].isDirectory() ) {
	        		fl2.add(fileLists[m]);
	           
	        }else 
	        	continue;
	         }
	       Collections.sort(fl2);

2.1.����Ŀ¼���ļ��м��ļ������ļ�������ArrayList f11�ﲢ����
for (int i = 0; i < fileLists.length; i++) { // ѭ�����������������        	
	        	if (fileLists[i].isFile() ) {
	        		fl1.add(fileLists[i]);           
	        }else 
	        	continue;
	         }
	       Collections.sort(fl1);
3.�ȱ����ļ�����Ϣ���ٱ����ļ���Ϣ

���н����
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/CompareCopyFile.png)

ʵ���� ����������IO
�ô�����Ͳ���������ַ���ʵ���ļ����ƣ����ȽϺ�ʱ�����

ʵ��˼·��1.ʵ�ִ�����ĸ���
public void BufferCopy() throws Exception{
		 File file = new File("F:\\ex.txt");   //Դ�ļ�
	        File file2 = new File("F:\\copy1.txt");//���帴���ļ�

	        //ָ����д��ʽΪgbk
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "gbk"));
	        try {
	        	int len = br.read();  
	            while(-1 != len)  
	            {  
	                //���д��  
	                bw.write(len);  
	                //�����ȡ  
	                len = br.read();  
	            }  
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            br.close();
	            bw.close();
	        }
	    
	}
2.ʵ�ֲ�������ĸ���
public void UnbufferCopy() throws Exception{
			File f1 = new File("F:\\ex.txt");
			File f2 = new File("F:\\copy2.txt");
			
			if(!f1.exists()){
				throw new IOException("�ļ������ڣ�");
			}
			
			//ʵ�����������������
			InputStream is = new FileInputStream(f1);
			OutputStream os = new FileOutputStream(f2);
			try {
	        	int len = is.read();  
	            while(-1 != len)  
	            {  
	            	 //���д��   
	                os.write(len);  
	                //�����ȡ   
	                len = is.read();  
	            }  
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            is.close();
	          os.close();
	        }

		}
3.������Ը���ʱ�䣺
long startTime1 = System.currentTimeMillis();    //��ȡ��ʼʱ��
		BufferFile bf = new BufferFile();
		bf.BufferCopy();
		long endTime1 = System.currentTimeMillis();    //��ȡ����ʱ��
		System.out.println("�������ֽ�������ʱ�䣺" + (endTime1 - startTime1) + "ms");    //�����������ʱ��

		//���������ֽ�������
		long startTime2 = System.currentTimeMillis();
		UnbufferFile uf = new UnbufferFile();
		uf.UnbufferCopy();
		long endTime2 = System.currentTimeMillis();
		System.out.println("���������ֽ�������ʱ�䣺" + (endTime2 - startTime2) + "ms");  

���н����
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/FileTree.png)
ʵ���� �������л�
��Student��ʾѧ�������԰���{studentID, name, sex} (ѧ�ţ��������Ա�)��
ʹ�����л���������Student��ѧ����Ϣ���ļ�list.txt���룬������ѧ���������С�
ע�⣬�����������Ա������֯��String���ͣ���ѧ�ſ�����StringҲ������Long��
ʹ��ObjectOutputStream���Ѿ������ѧ����Ϣд�����ļ���student.bin���С�
ʹ��ObjectInputStream����student.bin���еĶ�����Ϣ���������ʾ�ڿ���̨�С�

ʵ��˼·��1.��ȡlist.txt�ļ�:ʹ�� 
            while (in.hasNextLine()) { // ���ж�ȡ
            String s = in.nextLine();
            int idx = s.indexOf(" ");
            int idx1 = s.indexOf(" ",idx+1);
            String s0 = s.substring(0, idx);
            String s1 = s.substring(idx + 1, idx1);
            String s2 = s.substring(idx1 + 1, s.length());
            String[] arrs = { s0, s1,s2 };
            data.add(arrs);
        }
       ��ȡÿ�е�����String�ֶΣ�ʹ������arrs���棬�ٽ�arrs���浽ArrayList�
2.����ѧ������        for (int i = 0; i < data.size(); i++) {
           
        	Student s = new Student();
        	String[] arr = (String[]) data.get(i);
        	s.setStudentID(arr[0]);
        	s.setName(arr[1]);
        	s.setSex(arr[2]);
        	list.add(s);
                 }
����ȡ�����ֶηֱ𸳸�ÿ��ѧ������
3.ʹ��ѧ�Ž�������public static void sortStringMethod(List list){
	    	Collections.sort(list,new Comparator(){
	    		@Override
	    		public int compare(Object o1, Object o2){
	    			Student stu1 = (Student)o1;
	    			Student stu2 = (Student)o2;
	    			return stu1.getStudentID().compareTo(stu2.getStudentID());
	    		}
	    	});
                 }
4.ʹ��ObjectOutputStream���Ѿ������ѧ����Ϣд�����ļ���student.bin���С�
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
5.ʹ��ObjectInputStream����student.bin���еĶ�����Ϣ���������ʾ�ڿ���̨�С�
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
ע�⣺�������л������ǵ�student.bin�������Ϊ���룬���������л���õ�������������ʾ��
���н����
![image](http://github.com/hn123012015123/JavaExercise/readme_add_pic/raw/master/ObjectSerialize.png)