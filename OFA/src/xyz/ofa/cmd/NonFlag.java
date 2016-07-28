package xyz.ofa.cmd;

import xyz.ofa.base.exceptions.InvalidArgument;

public class NonFlag extends Flag{
	private String match;
	private boolean requireComment;
	public NonFlag(boolean commented){
		requireComment = commented;
	}
	public String getMatch(){
		return match;
	}
	public void setMatch(String match) throws InvalidArgument{
		if(requireComment)
			if(isCommented(match))
					this.match = match;
			else
				throw new InvalidArgument("Non Flag is not commented even though it is required");
		else
			this.match = match;
	}
	private boolean isCommented(String txt){
		if((!txt.contains("\"") && !txt.contains("'")))
			return false;
		if(txt.startsWith("\"") || txt.startsWith("'"))
			if(txt.endsWith("\"") || txt.endsWith("'"))
				return true;
		return false;
		
	}
}
