package fjnu.java.linli.io;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//带缓冲字节流复制
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
	}

}
