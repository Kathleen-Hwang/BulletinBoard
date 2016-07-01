package com.github.kathleenhwang.etc;

public class Util {
	public static boolean hasValue(final String value) {
		if (value == null || value.equals(""))
			return false;

		return true;
	}
}
