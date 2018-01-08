package fjnu.java.linli.net.chat;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class MyClien extends JFrame { // 创建类继承JFrame类
	
	private static final long serialVersionUID = 1L;
	
	private PrintWriter writer; // 声明PrintWriter类对象
	private BufferedReader reader; // 创建BufferedReader对象
	
	Socket socket; // 声明Socket对象
	
	private JTextPane jTextPane = new JTextPane();       //创建JTextPane对象
	private Document document = jTextPane.getDocument(); //创建Document对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	
	public MyClien(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // 实例化对象

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(jTextPane);
		cc.add(tf, "South"); // 将文本框放在窗体的下部
	}
	
	private void connect() { // 连接套接字方法
		try { // 捕捉异常
			socket = new Socket("127.0.0.1", 8998); // 实例化Socket对象
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			document.insertString(document.getLength(), ("客户端连接成功\n"), null);
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	private void sendMessageToServer(){
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				try {
					document.insertString(document.getLength(), ("客户端发送的消息:" + tf.getText() + "\n"), null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				tf.setText(""); // 将文本框清空
			}
		});
	}
	
	private void getServerMessage(){
		try {
			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得服务器端信息
					MutableAttributeSet attr = new SimpleAttributeSet();
					StyleConstants.setForeground(attr, new Color(255, 0, 0));    //设置字体颜色
					document.insertString(document.getLength(), ("服务器发送的信息:" + reader.readLine() + "\n"), attr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
		try {
			if (reader != null) {
				reader.close(); // 关闭流
			}
			if (socket != null) {
				socket.close(); // 关闭套接字
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { // 主方法
		MyClien clien = new MyClien("客户端"); // 创建本例对象
		clien.setSize(400, 400); // 设置窗体大小
		clien.setVisible(true); // 将窗体显示
		clien.connect(); // 调用连接方法
		clien.sendMessageToServer();  //向客户端发送消息
		clien.getServerMessage();     //接受服务器发送的消息
	}
}
