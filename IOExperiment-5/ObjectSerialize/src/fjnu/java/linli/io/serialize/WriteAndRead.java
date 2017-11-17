package fjnu.java.linli.io.serialize;

import java.io.*;
import java.util.List;

public class WriteAndRead {

	public static <T> void writeObjectToFile(List<T> list) {
		File file = new File("F:\\student.bin");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(list);
			objOut.flush();
			objOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> List<T> readObjectFromFile() {
		File file = new File("F:\\student.bin");
		FileInputStream in;
		List<T> object = null;
		try {
			in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			object = (List<T>) objIn.readObject();
			objIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (List<T>) object;
	}
}
