package xyz.ofa.util;

public class Misc {
	/**
	 * Splits a given String into equal sized chunks
	 * @param sdata String data
	 * @param maxSize Maximum chunk size
	 * @return A 2 dimensional Array containing the chunks
	 */
	public static char[][] splitEqual(String sdata,int maxSize){
		int l = sdata.length();
		int num = l / maxSize;
		char[][] data = new char[num][maxSize];
		for(int i = 0; i < num; i++){
			char[] d = sdata.substring(i * maxSize,i * (maxSize+1) > l ? l : i * (maxSize+1)).toCharArray();
			data[i]=d;
		}		
		return data;
	}
}
