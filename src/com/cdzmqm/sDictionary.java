package com.cdzmqm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class sDictionary {
	public static void main(String[] args) {
		Matcher tmp = Pattern.compile("([0-9]{4})([0-9]{4})").matcher("19911104");
		if(tmp.find())
		{
			System.out.println(tmp.group());
		}
	}
}
