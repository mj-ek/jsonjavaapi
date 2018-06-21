
/**

@author  MJ
https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post

Create URL object from the GET/POST URL String.
Call openConnection() method on URL object that returns instance of HttpURLConnection
Set the request method in HttpURLConnection instance, default value is GET.
Call setRequestProperty() method on HttpURLConnection instance to set request header values, such as “User-Agent” and “Accept-Language” etc.
We can call getResponseCode() to get the response HTTP code. This way we know if the request was processed successfully or there was any HTTP error message thrown.
For GET, we can simply use Reader and InputStream to read the response and process it accordingly.
For POST, before we read response we need to get the OutputStream from HttpURLConnection instance and write POST parameters into it.

@since  Praveen blasted me, .. 
*
*/

// package com.journaldev.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONArray;
import org.json.JSONObject;


public class HttpURLConnectionExample {

public static int lines = 0;
public static int len = 0;
	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "http://rnd.ekagga.com:8080/GenericAppBeta/rest/category/getcategory?appName=Karunashraya&languageType=English";

	private static final String POST_URL = "http://rnd.ekagga.com:8080/GenericAppBeta/rest/categoryDesc/getDesc";

	private static final String POST_PARAMS = "appName=Karunashraya&languageType=English&categoryName=Services";

	public static void main(String[] args) throws IOException {

		String GET_JSON = sendGET();
		  System.out.println("GET DONE" + GET_JSON);

		  parse_json(GET_JSON);
		String POST_JSON = sendPOST();
		System.out.println("POST DONE" + POST_JSON);

		parse_json(POST_JSON);
	}

/**
Parse the JSON String, Print Key value pair to Std output, better to use Stream.

*/
  private static void parse_json(String json_string)
  {
int len1 = json_string.length();
// System.out.println(len1);

int i = 0;
/**
split json by ,   won't work for nested JSON...*/
String strings[] = json_string.split(",");
len1 = strings.length;
System.out.println(len1);


for (; i< len1; i++) 
{
	System.out.println(strings[i]);
}


  }

  /**
Call Get API.

*/
	private static String sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) 
		{ // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				lines++;
			}
			in.close();

			// Count how many lines in response/
			len = response.length();

			System.out.println("\n"+ "Totally"+len + "characters"+lines+"Lines");
			return response.toString() ;
		} else {
			System.out.println("GET request not worked");
			return "";
		}

	}

  /**
Call Post API.

*/
	private static String sendPOST() throws IOException {

		
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		//mj wanted to print what goes into os.write...
		System.out.println("\n\nHello" + POST_PARAMS.getBytes());
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

//HTTP_OK is 200
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null)
			 {
				response.append(inputLine);
				lines++;
			}
			in.close();

			// print result
						// Count how many lines in response/
			 len = response.length();

			System.out.println("\n"+ "Totally"+len + "characters"+lines+"Lines");
			return response.toString();

		} else {
			System.out.println("POST request not worked");
			return "";
		}
	}

}