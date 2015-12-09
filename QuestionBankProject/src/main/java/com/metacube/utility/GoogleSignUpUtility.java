/**
 * Utility Class for helping in signUp using google sign Up
 *
 */
package com.metacube.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Team MJ
 *
 */
public class GoogleSignUpUtility {

	/**
	 * Function to sign up via google oauth
	 * 
	 * @param request
	 * @param response
	 * @return string to send data regarding user
	 */
	public static String oauthSignUp(HttpServletRequest request,
			HttpServletResponse response) {
		String line, outputString = "";
		try {
			// get code

			String code = request.getParameter("code");

			String urlParameters = "code="
					+ code
					+ "&client_id=149774065229-rm1alg2dqvn37mec2fnqlb4crh0lv93r.apps.googleusercontent.com"
					+ "&client_secret=rkDaAafJTSgmJC0Q0HcF0Xfk"
					+ "&redirect_uri=http://localhost:8080/QuestionBankProject/Oauth2CallBack"
					+ "&grant_type=authorization_code";

			// post parameters
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					urlConn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			// get output in outputString

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}

			// get Access Token
			JsonObject json = (JsonObject) new JsonParser().parse(outputString);
			String access_token = json.get("access_token").getAsString();

			// get User Info
			url = new URL(
					"https://www.googleapis.com/oauth2/v1/userinfo?access_token="
							+ access_token);
			urlConn = url.openConnection();
			outputString = "";
			reader = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			writer.close();
			reader.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (ProtocolException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		return outputString;
	}

}
