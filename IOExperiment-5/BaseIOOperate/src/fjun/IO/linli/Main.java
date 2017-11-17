package fjun.IO.linli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		System.out.println("请输入保存到src.txt的内容：");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		File f1=new File("F://src.txt");
		File f2=new File("F://dest.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f1));
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CopyFile c=new CopyFile();
		c.fileCopy(f1, f2);
		System.out.println("读取dest.txt的内容为：");
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
	}
		
}
