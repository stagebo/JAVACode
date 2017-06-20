package com.dyi.string;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileToHexString {
	public static void main(String[] agrs) throws Exception {
		File file = new File("G:\\img\\17ƒÍ5‘¬ ”‡«Ô”Í ÃÏΩÚ\\QQÕº∆¨20170529233828.jpg");

		String hexData = fileToHexString(file);
		System.out.println(hexData);
	}

	public static String fileToHexString(File file) throws IOException {
		if (!file.exists() && !file.isFile()) {
			return null;
		}
		long fileLength = file.length();
		byte[] b = new byte[(int) fileLength];

		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
		int k = fis.read(b);
		if (k == -1) {
			return null;
		}

		int line = 0;
		StringBuilder buf = new StringBuilder();
		for (byte d : b) {
			buf.append(String.format("%02x  ", d));
			line++;
			if (line % 16 == 0)
				buf.append("\n");
		}
		buf.append("\n");
		return buf.toString();
	}
}
