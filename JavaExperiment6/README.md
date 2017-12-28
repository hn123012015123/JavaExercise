
  1.对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。
  
 思路： 对于多线程的处理采用synchronized方法，也就是把getInstance()方法变成同步（synchronized)方法
  
  public static synchronized ChocolateBoilerThread getInstance() 
	{ 
	  if (uniqueInstance==null){ 
	  uniqueInstance = new ChocolateBoilerThread(); 
	} 
	  return uniqueInstance; 
	} 
  
  运行结果：
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment6/ResultPictures/ChocolateBoilerThread.png)
  
  
  2.利用4个线程分段求和1~100
线程1计算1~25之和；线程2计算26~50之和；以此类推
要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果

思路：
重写run方法

public void run() {
			for(;start<=end;start++) {
				number+=start;
			}
			isEnd =true;
		}
		

为每个线程设置工作区间

public void setArea(int start,int end) {
			this.start = start;
			this.end = end;
			isEnd = false;
			new Thread(this).start();
		}
		
定义四个线程，分别执行分段和操作

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
	
运行结果：	
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment6/ResultPictures/SumThread.png)