package fjnu.java.linli.net.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyTcp extends JFrame { // 创建类MyTcp

	private static final long serialVersionUID = 1L;

	private BufferedReader reader; // 创建BufferedReader对象
	private PrintWriter writer; // 声明PrintWriter类对象

	private ServerSocket server; // 创建ServerSocket对象
	private Socket socket; // 创建Socket对象socket

	private JTextPane jTextPane = new JTextPane();       //创建JTextPane对象
	private Document document = jTextPane.getDocument(); //创建Document对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	
	public MyTcp(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // 实例化对象

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(jTextPane);
		cc.add(tf, "South"); // 将文本框放在窗体的下部
		sendMessageToClient();
	}

	void getserver() {
		try {
			server = new ServerSocket(8998); // 实例化Socket对象
			document.insertString(document.getLength(), ("服务器套接字已经创建成功\n"), null);
			while (true) { // 如果套接字是连接状态
				socket = server.accept(); // 实例化Socket对象
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				getClientMessage(); // 调用getClientMessage()方法
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}

	private void getClientMessage() {
		try {
			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得客户端信息					
					MutableAttributeSet attr = new SimpleAttributeSet();
					StyleConstants.setForeground(attr, new Color(255, 0, 0));
					document.insertString(document.getLength(), ("客户端发送的信息:" + reader.readLine() + "\n"), attr);
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

	private void sendMessageToClient() {

		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				try {
					document.insertString(document.getLength(), ("服务器发送的消息:" + tf.getText() + "\n"), null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				tf.setText(""); // 将文本框清空
			}
		});

	}

	public static void main(String[] args) { // 主方法
		MyTcp tcp = new MyTcp("服务器"); // 创建本类对象
		tcp.setSize(400, 400); // 设置窗体大小
		tcp.setVisible(true); // 将窗体显示
		tcp.getserver();      //创建服务器
		tcp.getClientMessage();   //获取客户端信息
	}
}
