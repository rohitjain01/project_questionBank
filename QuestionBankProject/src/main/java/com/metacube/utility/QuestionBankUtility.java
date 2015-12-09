/**
 * Utility Class for project to access common functions
 *
 */
package com.metacube.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Team MJ
 *
 */
public class QuestionBankUtility {

	/**
	 * Function to encrypt password
	 * 
	 * @param passwordToHash
	 * @return encrypted password
	 */
	public static String passwordEncrypt(String passwordToHash) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++)
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));

			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	/**
	 * Function to get list of color for tag tiles
	 * 
	 * @return list of colors
	 */
	public static List<String> getTagColor() {
		List<String> tagColor = new ArrayList<String>();
		tagColor.add("red");
		tagColor.add("purple");
		tagColor.add("orange");
		tagColor.add("green");
		tagColor.add("blue");
		tagColor.add("yellow");
		tagColor.add("pink");
		tagColor.add("lime");
		tagColor.add("teal");
		return tagColor;

	}

	/**
	 * Function to get no of pages to show record of search
	 * 
	 * @param it1
	 * @param numberOfRecordsPerPage
	 * @return no Of Pages
	 */
	@SuppressWarnings("rawtypes")
	public static int getNumberOfPages(Iterator it1, int numberOfRecordsPerPage) {
		int totalNumberOfRecords = 0;
		if (it1.hasNext()) {
			Object o = it1.next();
			totalNumberOfRecords = Integer.parseInt(o.toString());
		}

		int noOfPages = totalNumberOfRecords / numberOfRecordsPerPage;
		if (totalNumberOfRecords > (noOfPages * numberOfRecordsPerPage)) {
			noOfPages = noOfPages + 1;
		}
		return noOfPages;

	}

	/**
	 * Function to get no of pages for answered questions foe implementing
	 * paginations
	 * 
	 * @param totalNumberOfRecords
	 * @param numberOfRecordsPerPage
	 * @return
	 */
	public static int getNumberOfPagesForAnswered(int totalNumberOfRecords,
			int numberOfRecordsPerPage) {

		int noOfPages = totalNumberOfRecords / numberOfRecordsPerPage;
		if (totalNumberOfRecords > (noOfPages * numberOfRecordsPerPage)) {
			noOfPages = noOfPages + 1;
		}
		return noOfPages;

	}

	/* Returns length of longest common substring of X[0..m-1] and Y[0..n-1] */
	public static int LCSubStr(String X, String Y, int m, int n) {
		// Create a table to store lengths of longest common suffixes of
		// substrings. Notethat LCSuff[i][j] contains length of longest
		// common suffix of X[0..i-1] and Y[0..j-1]. The first row and
		// first column entries have no logical meaning, they are used only
		// for simplicity of program
		int[][] LCSuff = new int[m + 1][n + 1];
		int result = 0; // To store length of the longest common substring

		/* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					LCSuff[i][j] = 0;

				else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
					result = max(result, LCSuff[i][j]);
				} else
					LCSuff[i][j] = 0;
			}
		}
		return result;
	}

	// A utility function to find maximum of two integers
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
