
  ģ��ʵ��FCFS�������ȷ����㷨��
ÿ��Task�����������Ϊ���ٰ����������ԣ�
taskID //����
IDarrivalTime //����ʱ��
serviceTime //����ʱ��
startingTime //��ʼʱ��
finishingTime //���ʱ��=��ʼʱ��+����ʱ��
turnAroundTime //��תʱ��=���ʱ��-�ﵽʱ��
weightTurnAround //��Ȩ��תʱ��=��תʱ��/����ʱ��
����(Task)��ID����ʼʱ��ͷ���ʱ�����ļ����롣
��������б��ļ������ɳ������ɣ�ÿ��һ������ﵽ������ʱ����{6,2,1,3,9}��������е����������ȡ��
�ļ��б�Ҫ��������100������

��Ҫ��ʵ������Ҫ���FCFS
��ֻ��һ���������ʱ�����
���������������ʱ�����

ʵ��˼·��һ���������д���
1.��ȡinput.txt�ļ����ݣ���ÿ�л�ȡ�����������ݷ�װ��Process����������

                while ((line = br.readLine()) != null) {             	
                 //�������򽫶���ո�תΪһ���ո�  
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

2.�������񣬼������ʱ�䣬�ж���һ������ĵ���ʱ���Ƿ�С�ڵ���ǰ����������ʱ�䣬����ǣ�
�������һ������������ǣ���ȴ�ʱ�䵽����һ������ĵ���ʱ�䡣

        public static void FCFS(Process[] p){           
        //������ʱ��Խ��̽�������  
        //InsertSort(p);                   
        for(int i=0;i<p.length;i++){  
            //�������ʱ��  
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
            //������תʱ��ʹ�Ȩ��תʱ��  
            p[i].WholeTime=p[i].finishTime-p[i].arrivalTime;  
            p[i].weightWholeTime=(double)p[i].WholeTime/(double)p[i].serviceTime;          
        }  
    }  

3.��ӡ��Ϣ

        public static void Out(Process[] p){  
        DecimalFormat df = new DecimalFormat("#.00");      
        System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
        for(int i=0;i<p.length;i++){  
            System.out.println(p[i].pid+"\t\t"+p[i].arrivalTime+"\t\t\t"+p[i].serviceTime+"\t\t\t"+p[i].startTime+"\t\t\t"+p[i].finishTime+"\t\t\t"+p[i].WholeTime+"\t\t\t"+df.format(p[i].weightWholeTime));   
        }  
	}

  ���н����
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/fcfs1.png)

�����������д���
1.��ȡinput.txt�ļ�������ݣ�����ÿ�е�����������Tab������������ȡ������Ϣ���浽��ά������
         
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

2.�����������������ȷ���������������飬���ɵ�һ����������һ�����У�ʱ�������һ���ڶ���������
�������֮ǰ�ж��Ƿ��п��ж��У��еĻ�������У�û�еĻ���ȴ�æµ���б�Ϊ���ж����ٽ��롣

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

3.��ӡ��Ϣ

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

  ���н����
  ![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/fcfs2.png)

  ģ��ʵ��SJF������ҵ���ȣ�
SJF�㷨���ȵ����ѵ���������У�����ʱ����̵��������ﲻҪ��ʵ���������ռ��

����FCFS�㷨��Ҫ��ʵ��SJF�㷨��ͬ��Ҫ�������������
��ֻ��һ���������ʱ�����
���������������ʱ�����

ʵ��˼·��һ���������д���

1.��ȡinput.txt�ļ����ݣ���ÿ�л�ȡ�����������ݷ�װ��Process����������

                while ((line = br.readLine()) != null) {             	
                 //�������򽫶���ո�תΪһ���ո�  
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

2.�����������ϣ��������������Ž�res���ϣ���δ������������list���ϣ���list������Ѱ����һ������
�ҵ������res������list��ɾ����
    
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


     //�����һ������  
       
        p[0].finishTime=p[0].arrivalTime+p[0].serviceTime;  
        p[0].WholeTime=p[0].finishTime-p[0].arrivalTime;  
        p[0].weightWholeTime=p[0].WholeTime/p[0].serviceTime;  
        res.add(p[0]);            
        now=p[0].finishTime; 

   //��ʣ�������ӽ�������list  
        
       for(int i=1;i<p.length;i++){  
            list.add(p[i]);  
        }  
          
3.�Լ��������Ϣ����taskID�������򲢴�ӡ

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

  ���н����
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/sjf1.png)

�����������д���
1.��ȡinput.txt�ļ�������ݣ�����ÿ�е�����������Tab������������ȡ������Ϣ���浽��ά������
         
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

2.����һ���������飬��һ�������Ƚ�����У�����ڶ�������������ʱ���ж����������Ƿ��ڿ���״̬��
���п��ж��У������ж���ʼʱ�����������ģ����ҷ���ʱ��϶̵����Ƚ��롣�ɴ����ƣ�ֱ������ȫ����ɣ�


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


3.��ӡ��Ϣ

                       System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length-1; y++) {
					if(y!=data[x].length-2){
						System.out.print(df.format(data[x][y]) + "\t\t\t");
					}else{
						System.out.println(df1.format(data[x][y]));
					}	
				}

  ���н����
![image](https://github.com/hn123012015123/JavaExercise/blob/master/JavaExperiment4/ResultPictures/sjf2.png)
			}