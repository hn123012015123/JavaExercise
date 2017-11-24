package com.linli.ep4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FcfsAndSjf {
	 /** 
     * 读取内容 
     * @throws IOException 
     */  
    public  void read() throws IOException{  
        BufferedReader br = null;  
        String line =null;  
       /* int n=0;
        while ((line = br.readLine()) != null) { 
        	n++;
        }*/
        Process[] p=new Process[100];
        //StringBuffer buf = new StringBuffer();  
        try {  
            //根据文件路径创建缓冲输入流  
            br = new BufferedReader(new FileReader("F:\\input.txt"));
            String str = "";  
              int m=0;
              int arrTime = 0;
              int serTime = 0;
              int pid = 0;
            //循环读取文件的每一行，对需要修改的行进行修改，放入缓冲对象中  
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
                // System.out.println(m);  
                 Scanner in= new Scanner(System.in); 
                 while(true){  
                     System.out.println("请选择进程调度算法，1：FCFS 2:SJF 其他键:quit");  
                     int select=in.nextInt();  
                     if(select==1){  
                         System.out.println("----------------您选择了FCFS-------------------");  
                         FCFS(p);  
                         Out(p);  
                           
                     }  
                     else if(select==2){  
                         System.out.println("----------------您选择了SJF-------------------");  
                         Process[] processes=SJF(p);  
                         SjfOut(processes);  
                     }  
                     else{  
                         break;  
                     }  
                   
             }  
            
             
             } catch (Exception e) {  
            e.printStackTrace();  
        }finally {  
             if (br != null) {// 关闭流  
                   try {  
                       br.close();  
                   } catch (IOException e) {  
                         br = null;  
                }  
             }  
        }  
       
    }  
    	
    	
  
   //sjf输出 	
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
  
      System.out.println("---------------------------------------------------------");  
   }
          
    
      
    //fcfs输出  
    public static void Out(Process[] p){  
        DecimalFormat df = new DecimalFormat("#.00");      
        System.out.println("TaskID		ArrivalTime		ServiceTime		StartingTime		FinishingTime		TurnAroundTime		WeightTurnAroundTime");
        for(int i=0;i<p.length;i++){  
            System.out.println(p[i].pid+"\t\t"+p[i].arrivalTime+"\t\t\t"+p[i].serviceTime+"\t\t\t"+p[i].startTime+"\t\t\t"+p[i].finishTime+"\t\t\t"+p[i].WholeTime+"\t\t\t"+df.format(p[i].weightWholeTime));  
           
        }  
   
       System.out.println("---------------------------------------------------------");  
    }  
      
    //找出下一个处理的进程  
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
      
    //插入排序  
    public static void InsertSort(Process[] array) {
    	for(int i=1;i<array.length;i++) {
    		Process target=array[i];
    		int j=i-1;
    		while(j>=0&&array[j].arrivalTime>target.arrivalTime) {
    			array[j+1]=array[j];
    			j--;
    		}
    		array[j+1]=target;
    	}
    }
   
      
    //先来先服务算法  
    public static void FCFS(Process[] p){  
          
        //按到达时间对进程进行排序  
        InsertSort(p);  
                  
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
      
    //短作业优先算法  
    public static Process[] SJF(Process[] p){  
          
        //当前时间  
        int now=0;  
        //待处理list  
        List<Process> list=new LinkedList<>();  
        //结果list  
        List<Process> res=new LinkedList<>();  
        //按时间对进程进行排序  
        InsertSort(p);  
          
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
          
        while(list.size()!=0){  
            Process next=FindNextPro(list, now);  
            if(next.arrivalTime>now){  
                next.finishTime=next.arrivalTime+next.serviceTime;  
                next.startTime=next.arrivalTime;  
            }else{  
                next.finishTime=now+next.serviceTime;  
                next.startTime=now;  
            }  
            now=next.finishTime;  
            next.WholeTime=next.finishTime-next.arrivalTime;  
            next.weightWholeTime=(double)next.WholeTime/(double)next.serviceTime;  
            res.add(next);  
        }     
              
        return res.toArray(new Process[0]);  
          
    }  
      
  
} 
  
//进程的数据结构  
class Process{  
    public int arrivalTime;  
    public int serviceTime;  
    public int finishTime;  
    public int startTime;  
    public int WholeTime;  
    public double weightWholeTime;  
    public int pid;  
      
    Process(int x,int y,int id){  
        arrivalTime=x;  
        serviceTime=y;  
        pid=id;  
    }  

}
