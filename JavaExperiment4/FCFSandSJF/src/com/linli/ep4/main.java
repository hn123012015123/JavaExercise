package com.linli.ep4;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		WriteText wr=new WriteText();
		wr.WriteText();
		FcfsAndSjf fs=new FcfsAndSjf();
		try {
			fs.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
