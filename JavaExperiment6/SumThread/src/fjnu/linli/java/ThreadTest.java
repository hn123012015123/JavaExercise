package fjnu.linli.java;

public class ThreadTest {

	public class ThreadHandred implements Runnable{

		private int number,start,end;
		private boolean isEnd = true;
				
		@Override
		public void run() {
			for(;start<=end;start++) {
				number+=start;
			}
			isEnd =true;
		}
		public void setArea(int start,int end) {
			this.start = start;
			this.end = end;
			isEnd = false;
			new Thread(this).start();
		}
		public int getNumber() {
			return isEnd?number:-1;
		}

	}
	public static void main(String[] args) {
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
		for (int i = 0; i < arrayNum.length;i++) {
			if (arrayThread[i].getNumber() != -1) {
				System.out.println("线程"+(i+1)+"的和为："+ arrayThread[i].getNumber());
				
			}
		}
		num = 0;
		for (int j = 0; j < arrayNum.length;) {
			if (arrayThread[j].getNumber() != -1) {
				num += arrayThread[j].getNumber();
				++j;
			}
			
		}
		System.out.println("1+2+3...99+100 = " + num);
}
	}
