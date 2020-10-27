package main.data.io;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
	public static void write(String data, String path) throws IOException {
		FileWriter out = null;

		try {
			out = new FileWriter(path);

			out.write(data);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public static String read(String path) throws IOException {
		FileInputStream file = null;
		Scanner scanner = null;

		try {
			StringBuilder data = new StringBuilder();

			file = new FileInputStream(path);

			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				data.append(scanner.nextLine());
				data.append("\n");
			}

			return data.toString();

		} finally {
			if (file != null) {
				file.close();
			}
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
