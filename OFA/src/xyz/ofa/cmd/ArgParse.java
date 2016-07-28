package xyz.ofa.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import xyz.ofa.base.exceptions.DuplicateFlagsException;
import xyz.ofa.base.exceptions.InvalidArgument;

public class ArgParse {
	private List<DashFlag> registered;
	private Set<Flag> matched;
	private boolean requireHyphen = true;
	private NonFlag nonFlag;
	private boolean requireFlag = true;

	public ArgParse() {
		registered = new LinkedList<>();
		matched = new HashSet<>();
		nonFlag = new NonFlag(false);
	}

	public void addFlag(List<DashFlag> f) {
		registered.addAll(f);
	}

	public void addFlag(DashFlag f) {
		registered.add(f);
	}

	public List<DashFlag> getFlags() {
		return registered;
	}

	public void removeFlag(DashFlag f) {
		registered.remove(f);
	}

	public void removeFlag(int index) {
		registered.remove(index);
	}

	public void clearFlags() {
		registered.clear();
	}

	public void setRequireHyphen(boolean state) {
		requireHyphen = state;
	}

	public boolean requiresHyphen() {
		return requireHyphen;
	}

	private String noSpace(String text) {
		return text.replaceAll("\\s+", "");
	}
	private String noStartDash(String text){
		return text.replaceAll("[\\-]*", "");
	}
	private String getFlagText(String text){
		String s = noStartDash(noSpace(text));
		return s;
	}
	private char[] getMultiFlagParts(String text){
		String s = noStartDash(noSpace(text));
		return s.toCharArray();
	}
	public boolean isStringFlag(String text) throws InvalidArgument {
		String s = noSpace(text);
		if (s.length() > 2)
			if (noSpace(text).startsWith("--"))
				return true;
			else
				return false;
		else if (requireFlag)
			throw new InvalidArgument("-- is present but no parameter");
		return false;
	}
	public boolean isNormalFlag(String text) throws InvalidArgument {
		String s = noSpace(text);
		if (s.length() > 1)
			if (s.startsWith("-") && s.charAt(1) != '-')
				return true;
			else
				return false;
		else if (requireFlag)
			throw new InvalidArgument("- is present but no parameter");
		return false;
	}
	public boolean isMultiNormal(String text) throws InvalidArgument{
		String s = noSpace(text);
		if(isNormalFlag(s)){
			if(s.length() > 2)
				return true;
		}
		return false;
	}
	public boolean isNonFlag(String text) {
		if (!noSpace(text).startsWith("-"))
			return true;
		return false;
	}
	public boolean hasDuplicateFlags() {
		List<String> longF = new ArrayList<>();
		List<String> shortF = new ArrayList<>();
		for (DashFlag f : registered) {
			if (f.getLong() != null)
				if (longF.contains(f.getLong()))
					return true;
				else
					longF.add(f.getLong());
			if (shortF.contains(f.getShort()))
				return true;
			else
				shortF.add(f.getShort());
		}
		return false;
	}

	public String getNonFlagMatch() {
		return nonFlag.getMatch();
	}

	public Set<Flag> getMatches() {
		return matched;
	}

	public void parse(String... args) throws DuplicateFlagsException, InvalidArgument {
		if (hasDuplicateFlags()) {
			throw new DuplicateFlagsException();
		}
		System.out.println("Matching:");
		System.out.println(Arrays.toString(args));
		int found = 0;
		int argnum = 0;
		for(String arg : args){
			if(isMultiNormal(arg)){
				char[] a = getMultiFlagParts(arg);
				argnum += a.length;
				System.out.println("Multi: " + Arrays.toString(a));
				for(char c : a)
					for(DashFlag x : registered){
						if(x.getShort().equalsIgnoreCase(""+c))
						{
							matched.add(x);
							found++;
						}
					}
			}
			else if(isNormalFlag(arg)){
				argnum++;
				System.out.println("Normal: " + arg);
				String f = getFlagText(arg);
				for(DashFlag x : registered)
					if(x.getShort().equalsIgnoreCase(f)){
						matched.add(x);
						found++;
						break;
					}
			}
			else if(isStringFlag(arg)){
				argnum++;
				System.out.println("String: " + arg);
				String f = getFlagText(arg);
				for(DashFlag x : registered)
					if(x.hasLong())
					if(x.getLong().equalsIgnoreCase(f)){
						matched.add(x);
						found++;
					}
			}
			else if(isNonFlag(arg)){
				System.out.println("NonFlag: " + arg);
				String f = getFlagText(arg);
				nonFlag.setMatch(arg);
				matched.add(nonFlag);
			}
		}
		if(found > registered.size())
			throw new InvalidArgument("Duplicate arguments");
		if(argnum > registered.size())
			throw new InvalidArgument("Invalid Arguments");
	}
}
