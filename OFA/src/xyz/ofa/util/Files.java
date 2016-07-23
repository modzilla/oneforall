package xyz.ofa.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public abstract class Files {
	/**
	 * Synchronously Reads a whole File returning its Content in the given encoding
	 * @param path The path to the File
	 * @param encoding The Encoding of the File
	 * @return Content of the File
	 * @throws IOException
	 */
	public static String readFile(String path,Charset encoding) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),encoding));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
	/**
	 * Writes a given String to a new or existing file
	 * @param data Your data to write
	 * @param path Path to the file
	 * @param encoding Your output encoding
	 * @throws IOException
	 */
	public static void writeFile(String data, String path, Charset encoding) throws IOException{
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),encoding));
		char[][] rdata = Misc.splitEqual(data, 100);
		for(char[] d : rdata)
			br.write(d);
		br.close();
	}
}
