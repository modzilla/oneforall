package xyz.ofa.cmd;

public class DashFlag extends Flag{
	private String s, l;

	public DashFlag(String longArg, String shortArg) {
		this.s = shortArg;
		this.l = longArg;
	}
	public String getLong() {
		return l;
	}

	public String getShort() {
		return s;
	}
	public boolean hasLong(){
		return l != null;
	}
}
