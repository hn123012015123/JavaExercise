
  1.��ʵ�����еĵ���ģʽ���и��죬ʹ��֧�ֶ��̣߳��������̰߳�ȫ�ġ�
  
 ˼·�� ���ڶ��̵߳Ĵ������synchronized������Ҳ���ǰ�getInstance()�������ͬ����synchronized)����
  
  public static synchronized ChocolateBoilerThread getInstance() 
	{ 
	  if (uniqueInstance==null){ 
	  uniqueInstance = new ChocolateBoilerThread(); 
	} 
	  return uniqueInstance; 
	} 
  
  ���н����
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment6/ResultPictures/ChocolateBoilerThread.png)
  
  
  2.����4���̷ֶ߳����1~100
�߳�1����1~25֮�ͣ��߳�2����26~50֮�ͣ��Դ�����
Ҫ���߳�1���֮��ִ���߳�2��֮��ִ���߳�3�����ִ���߳�4
��ӡÿ����ͽ�����Լ������ܽ�������ֱ��ӡ��һ����ͽ�����ڶ�����ͽ������������ͽ�������Ķ���ͽ�������յ���ͽ��

˼·��
��дrun����

public void run() {
			for(;start<=end;start++) {
				number+=start;
			}
			isEnd =true;
		}
		

Ϊÿ���߳����ù�������

public void setArea(int start,int end) {
			this.start = start;
			this.end = end;
			isEnd = false;
			new Thread(this).start();
		}
		
�����ĸ��̣߳��ֱ�ִ�зֶκͲ���

int num = 0;
		ThreadHandred[] arrayThread = new ThreadHandred[4];
		int[] arrayNum = new int[arrayThread.length];
		ThreadTest test = new ThreadTest();
		ThreadHandred myThread;
		for (int i = 0; i < arrayThread.length; i++) {
			myThread = test.new ThreadHandred();
			myThread.setArea(num+=1, num+=24);
			myThread.run();
			arrayThread[i] = myThread;
			
		}
	
���н����	
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment6/ResultPictures/SumThread.png)