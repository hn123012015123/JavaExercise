JAVA第四次实验：
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

模拟实现SJF（短作业优先）
SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。