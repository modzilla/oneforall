package xyz.ofa.util;

public abstract class Time {
	public static String prettyMilliseconds(long milliseconds) {
		int millis = (int) (milliseconds % 1000);
		int seconds = (int) (milliseconds / 1000) % 60;
		int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
		int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
		StringBuilder sb = new StringBuilder();
		if (hours > 0) {
			sb.append((char) ('0' + hours / 10)).append((char) ('0' + hours % 10)).append(":");
		}
		sb.append((char) ('0' + minutes / 10)).append((char) ('0' + minutes % 10)).append(":")
				.append((char) ('0' + seconds / 10)).append((char) ('0' + seconds % 10)).append(".")
				.append((char) ('0' + millis / 100));
		return sb.toString();
	}
}
