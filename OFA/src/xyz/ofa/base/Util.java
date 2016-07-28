package xyz.ofa.base;

public class Util {
	public static RuntimeException sneakyThrow(Throwable t){
	    if (t == null)
	        throw new NullPointerException();
	    Util.sneakyThrow0(t);
	    return null;
	}
	@SuppressWarnings("unchecked")
	private static <T extends Throwable> void sneakyThrow0(Throwable t) throws T {
	    throw (T) t;
	}
}
