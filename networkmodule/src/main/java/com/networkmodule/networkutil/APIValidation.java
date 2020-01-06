package com.networkmodule.networkutil;

public class APIValidation {

	public static boolean isResponseValid(int responseCode) {

		boolean isValid;
		if (responseCode == 2000) {
			isValid = true;
		} else if (responseCode == 2001) {
			isValid = true;
		} else if (responseCode == 2002) {
			isValid = true;
		} else if (responseCode == 2003) {
			isValid = true;
		} else if (responseCode == 2004) {
			isValid = true;
		} else if (responseCode == 1000) {
			isValid = false;
		} else if (responseCode == 1001) {
			isValid = false;
		} else if (responseCode == 1002) {
			isValid = false;
		} else if (responseCode == 1003) {
			isValid = false;
		} else if (responseCode == 1004) {
			isValid = false;
		} else if (responseCode == 1005) {
			isValid = false;
		} else if (responseCode == 1006) {
			isValid = false;
		} else if (responseCode == 1007) {
			isValid = false;
		} else if (responseCode == 1008) {
			isValid = false;
		} else if (responseCode == 1009) {
			isValid = false;
		} else if (responseCode == 1010) {
			isValid = false;
		} else if (responseCode == 1011) {
			isValid = false;
		} else if (responseCode == 1012) {
			isValid = false;
		} else if (responseCode == 1013) {
			isValid = false;
		} else if (responseCode == 1014) {
			isValid = false;
		} else if (responseCode == 1015) {
			isValid = false;
		} else {
			isValid = false;
		}

		return isValid;
	}
}
