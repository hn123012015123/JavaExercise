## 实验七--网络编程

<br>一 改造教材19.2和19.3的例子，创建简单的聊天程序<br>
要求内容：<br>服务器也具有类似客户端的UI界面<br>
服务器也能够向客户端发送信息<br>
客户端和服务器端UI界面要区分各自发送和接收到的信息，比如可以使用颜色区分彼此的聊天记录<br>
#1创建服务器套接字以及IO流

			server = new ServerSocket(8998); // 实例化Socket对象
			document.insertString(document.getLength(), ("服务器套接字已经创建成功\n"), null);
			while (true) { // 如果套接字是连接状态
				socket = server.accept(); // 实例化Socket对象
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				getClientMessage(); // 调用getClientMessage()方法
			}

#2获取客户端数据

			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得客户端信息					
					MutableAttributeSet attr = new SimpleAttributeSet();
					StyleConstants.setForeground(attr, new Color(255, 0, 0));
					document.insertString(document.getLength(), ("客户端发送的信息:" + reader.readLine() + "\n"), attr);
				}
			}
			
#3向客户端发送数据,向文本框绑定响应函数

		tf.addActionListener(new ActionListener() {
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
实验结果：
	![image](https://github.com/hn123012015123/JavaExercise/blob/master/NetChatExperiment/resultPictures/result.png)