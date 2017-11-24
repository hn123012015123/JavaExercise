
  模拟实现FCFS（先来先服务）算法；
每个Task对象可以描述为至少包含下列属性：
taskID //任务
IDarrivalTime //到达时间
serviceTime //服务时间
startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间
turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间
任务(Task)的ID、开始时间和服务时间由文件读入。
这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。
文件列表要包含至少100个任务。

先要求实现如下要求的FCFS
当只有一个处理队列时的情况
当有两个处理队列时的情况

实验思路：一：单个队列处理
1.获取input.txt文件内容，将每行获取到的三组数据封装成Process对象数组里

                while ((line = br.readLine()) != null) {             	
                 //设置正则将多余空格都转为一个空格  
                 str=line+"\r\n";  
                 String[] dictionary =  str.split("\\s+|\\n+|\\r+|\\t+");  
                 for(int i=0;i<dictionary.length;i++){  
                    str = dictionary[0]+","+dictionary[1]+","+dictionary[2]; 
                     arrTime=Integer.valueOf(dictionary[1]).intValue(); 
                     serTime=Integer.valueOf(dictionary[2]).intValue();
                     pid=Integer.valueOf(dictionary[0]).intValue();
                    p[m]=new Process(arrTime, serTime,pid);  
                 } 
                 m++;
                 //System.out.println(arrTime+" "+serTime+" "+pid);
             }

2.插入任务，计算完成时间，判断下一个任务的到达时间是否小于等于前面任务的完成时间，如果是，
则进行下一个任务，如果不是，则等待时间到达下一个任务的到达时间。

        public static void FCFS(Process[] p){           
        //按到达时间对进程进行排序  
        //InsertSort(p);                   
        for(int i=0;i<p.length;i++){  
            //计算完成时间  
            if(i==0){  
                p[i].finishTime=p[i].arrivalTime+p[i].serviceTime;  
            }else{  
                if(p[i].arrivalTime>p[i-1].finishTime){  
                    p[i].finishTime=p[i].arrivalTime+p[i].serviceTime;  
                    p[i].startTime=p[i].arrivalTime;  
                }  
                else{  
                    p[i].finishTime=p[i].serviceTime+p[i-1].finishTime;  
                    p[i].startTime=p[i-1].finishTime;  
                }  
            }             
            //计算周转时间和带权周转时间  
            p[i].WholeTime=p[i].finishTime-p[i].arrivalTime;  
            p[i].weightWholeTime=(double)p[i].WholeTime/(double)p[i].serviceTime;          
        }  
    }  

3.打印信息

        public static void Out(Process[] p){  
        DecimalFormat df = new DecimalFormat("#.00");      
        System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
        for(int i=0;i<p.length;i++){  
            System.out.println(p[i].pid+"\t\t"+p[i].arrivalTime+"\t\t\t"+p[i].serviceTime+"\t\t\t"+p[i].startTime+"\t\t\t"+p[i].finishTime+"\t\t\t"+p[i].WholeTime+"\t\t\t"+df.format(p[i].weightWholeTime));   
        }  
	}

  运行结果：
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/fcfs1.png)

二：两个队列处理
1.获取input.txt文件里的内容，其中每行的三个数据以Tab键隔开，将获取到的信息保存到二维数组里
         
               File file=new File(filename);
		try {
			FileReader in = new FileReader(file);
			BufferedReader inp = new BufferedReader(in);
			String line = null;
			double[][] data = new double[100][8]; 
			int num = 0; 
			while ((line = inp.readLine()) != null) {
				String[] temp = line.split("\t");
				for (int i = 0; i < 3; i++) {
					data[num][i] = Double.parseDouble(temp[i]);
				}
				num++;
			}
			inp.close();
			in.close();

2.进行两个队列先来先服务处理：定义队列数组，先由第一个任务进入第一个队列，时间变量加一，第二个任务在
进入队列之前判断是否有空闲队列，有的话插入队列，没有的话则等待忙碌队列变为空闲队列再进入。

                  int[][] queue = new int[queueNum][2]; 
			double time = -1; 
			int currentTask = -1; 
			while (currentTask < 100) {
				time++;
				for (int j = 0; j < queue.length; j++) {
					if (queue[j][0] == 0 && data[currentTask+1][1]<=time) {						
						currentTask++;
						if (currentTask < 100) {
							queue[j][0] = (int)(data[currentTask][2]);
							queue[j][1]=currentTask;
							data[currentTask][3]=time;
						}
					} else if (queue[j][0] != 0) {
						queue[j][0]--;
						if (queue[j][0] == 0) {
							currentTask++;
							if(currentTask<100){
								queue[j][0] = (int)(data[currentTask][2]);
								queue[j][1]=currentTask;
								data[currentTask][3] = time;
							}							
						}
					}
				}
			}

3.打印信息

                      System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length; y++) {
					if(y!=data[x].length-1){
						System.out.print(df.format(data[x][y]) + "\t\t\t");
					}else{
						System.out.println(df1.format(data[x][y]));
					}	
				}
			}

  运行结果：
  ![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/fcfs2.png)

  模拟实现SJF（短作业优先）
SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。

按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：
当只有一个处理队列时的情况
当有两个处理队列时的情况

实验思路：一：单个队列处理

1.获取input.txt文件内容，将每行获取到的三组数据封装成Process对象数组里

                while ((line = br.readLine()) != null) {             	
                 //设置正则将多余空格都转为一个空格  
                 str=line+"\r\n";  
                 String[] dictionary =  str.split("\\s+|\\n+|\\r+|\\t+");  
                 for(int i=0;i<dictionary.length;i++){  
                    str = dictionary[0]+","+dictionary[1]+","+dictionary[2]; 
                     arrTime=Integer.valueOf(dictionary[1]).intValue(); 
                     serTime=Integer.valueOf(dictionary[2]).intValue();
                     pid=Integer.valueOf(dictionary[0]).intValue();
                    p[m]=new Process(arrTime, serTime,pid); 
                    
                 } 
                 m++;
                 //System.out.println(arrTime+" "+serTime+" "+pid);
             }

2.定义两个集合，将处理完的任务放进res集合，将未处理的任务放入list集合，在list集合里寻找下一个任务，
找到后加入res，并从list里删除。
    
       public static Process FindNextPro(List<Process> list,int now){  
        Process pro=list.get(0);  
        int index=0;  
        for(int i=1;i<list.size();i++){  
            if(list.get(i).serviceTime<pro.serviceTime&&list.get(i).arrivalTime<=now){  
                pro=list.get(i);  
                index=i;  
            }  
        }  
        list.remove(index);  
        return pro;  
      }  


     //处理第一个进程  
       
        p[0].finishTime=p[0].arrivalTime+p[0].serviceTime;  
        p[0].WholeTime=p[0].finishTime-p[0].arrivalTime;  
        p[0].weightWholeTime=p[0].WholeTime/p[0].serviceTime;  
        res.add(p[0]);            
        now=p[0].finishTime; 

   //将剩余进程添加进待处理list  
        
       for(int i=1;i<p.length;i++){  
            list.add(p[i]);  
        }  
          
3.对集合里的信息按照taskID进行排序并打印

         public static void SjfOut(Process[] p) {
	   DecimalFormat df = new DecimalFormat("#.00");
	   for(int i=1;i<p.length;i++) {
   		Process target=p[i];
   		int j=i-1;
   		while(j>=0&&p[j].pid>target.pid) {
   			p[j+1]=p[j];
   			j--;
   		}
   		p[j+1]=target;
   	}
	   System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
       for(int i=0;i<p.length;i++){  
           System.out.println(p[i].pid+"\t\t"+p[i].arrivalTime+"\t\t\t"+p[i].serviceTime+"\t\t\t"+p[i].startTime+"\t\t\t"+p[i].finishTime+"\t\t\t"+p[i].WholeTime+"\t\t\t"+df.format(p[i].weightWholeTime));         
       }  

  运行结果：
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/sjf1.png)

二：两个队列处理
1.获取input.txt文件里的内容，其中每行的三个数据以Tab键隔开，将获取到的信息保存到二维数组里
         
               File file=new File(filename);
		try {
			FileReader in = new FileReader(file);
			BufferedReader inp = new BufferedReader(in);
			String line = null;
			double[][] data = new double[100][8]; 
			int num = 0; 
			while ((line = inp.readLine()) != null) {
				String[] temp = line.split("\t");
				for (int i = 0; i < 3; i++) {
					data[num][i] = Double.parseDouble(temp[i]);
				}
				num++;
			}
			inp.close();
			in.close();

2.定义一个队列数组，第一个任务先进入队列，到达第二个任务进入队列时，判断两个队列是否处于空闲状态，
若有空闲队列，继续判断起始时间满足条件的，而且服务时间较短的优先进入。由此类推，直至任务全部完成，


                      int[][] queue = new int[queueNum][2]; 
			int time = -1; 
			int finishedTask = 0;
			double minServiceTime=10;
			int minTask=-1;
			while (finishedTask< 100) {
				time++;
				for (int j = 0; j < queue.length; j++) {
					if (queue[j][0] == 0&&minTask!=-2) {	
							queue[j][0] = (int)(data[time][2]);
							queue[j][1]=time;
							data[time][3]=time;
							data[time][7]=1;
							break;
					} else if(queue[j][0]!=0){
						queue[j][0]--;
						if (queue[j][0] == 0) {
							minServiceTime=10;
							minTask=-1;
							finishedTask++;
							int sy=queue[j][1];
							data[sy][4]=time;
							data[sy][5] = data[sy][4] - data[sy][1];
				            data[sy][6] = data[sy][5] / data[sy][2];
				            if(time>=100){
				            	for(int k=0;k<100;k++){
				            		if(data[k][4]==0&&data[k][7]==0&&data[k][2]<minServiceTime){
				            			minServiceTime=data[k][2];
				            			minTask=k;
				            		}
				            	}
				            }else{
				            	for(int k=0;k<=time;k++){
				            		if(data[k][4]==0&&data[k][7]==0&&data[k][2]<minServiceTime){
				            			minServiceTime=data[k][2];
				            			minTask=k;
				            		}
				            	}
				            }
				            if(minTask!=-1){
				            	queue[j][0] = (int)(data[minTask][2]);
								queue[j][1]=minTask;
								data[minTask][3]=time;
								data[minTask][7]=1;
								if(minTask==time){
									minTask=-2;
								}		
				            }else{
				            	minTask=-2;
				            }
														
						}
					}
				}
			}


3.打印信息

                       System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length-1; y++) {
					if(y!=data[x].length-2){
						System.out.print(df.format(data[x][y]) + "\t\t\t");
					}else{
						System.out.println(df1.format(data[x][y]));
					}	
				}

  运行结果：
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/sjf2.png)
			}