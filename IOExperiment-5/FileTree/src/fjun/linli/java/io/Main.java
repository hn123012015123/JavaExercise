package fjun.linli.java.io;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        FileTree ft=new FileTree();
        System.out.println("请输入路径：");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        ft.printFile(file);
      
        }
}
