import java.io.*;
import java.net.*;


/*

javac -Xdiags:verbose file name...
there is no main 
we get 

javac call_url.java 
call_url.java:4: error: class, interface, or enum expected
public call_url
       ^
call_url.java:9: error: class, interface, or enum expected
URLConnection urlConnection = url.openConnection();
^
call_url.java:10: error: class, interface, or enum expected
InputStream input = urlConnection.getInputStream();
^
call_url.java:12: error: class, interface, or enum expected
int data = input.read();
^
call_url.java:18: error: class, interface, or enum expected
input.close();
^
call_url.java:20: error: class, interface, or enum expected
}
^
6 errors

Added main 

javac call_url.java 
call_url.java:31: error: class, interface, or enum expected
public call_url
       ^
call_url.java:34: error: class, interface, or enum expected
    public static void main(String[] args) throws IOException 
                  ^
call_url.java:38: error: class, interface, or enum expected
URLConnection urlConnection = url.openConnection();
^
call_url.java:39: error: class, interface, or enum expected
InputStream input = urlConnection.getInputStream();
^
call_url.java:41: error: class, interface, or enum expected
int data = input.read();
^
call_url.java:47: error: class, interface, or enum expected
input.close();
^
call_url.java:48: error: class, interface, or enum expected
}
^
7 errors



Added  public class

o read a line of chars from console with an InputStream one should perform the following steps:

Use System.in to get the standard InputStream.
Create a new BufferedReader with a new InputStreamReader with the specified InputStream.
Use readLine() API method of BufferedReader to read a line of text.
Close the BufferedReader, using the close() API method,



http://personal.ekagga.com/GenericAppBeta/generic/api/getNewsCategory?news_language=English&categoryClientUniqId=theNews_uniq_id
*/
public class call_url_line
{

    public static void main(String[] args) throws IOException 
    {


 BufferedReader br = null;
String karunashraya_app_link = "http://106.51.129.9:8080/GenericApp/rest/appInfo/getAppName";
String karunashraya_app_link1 = "http://106.51.129.9:8080/GenericApp/rest/appInfo/getAppName";
String news_nib_categories = "http://personal.ekagga.com/GenericAppBeta/generic/api/getNewsCategory?news_language=English&categoryClientUniqId=theNews_uniq_id";
// String karunashraya_app_link = "http://106.51.129.9:8080/GenericApp/rest/appInfo/getAppName";
String line = null;

/*URL Object needed to tie http or such type file or link or api blunt*/
URL url = new URL(news_nib_categories);
// URL url = new URL(karunashraya_app_link);

URLConnection urlConnection = url.openConnection();

/*InputStream, using C++ ... stream can be keyboard input, file, socket */
InputStream input = urlConnection.getInputStream();

/** T get */
br = new BufferedReader( new InputStreamReader(input));
/*
Use System.in to get the standard InputStream.
Create a new BufferedReader with a new InputStreamReader with the specified InputStream.
Use readLine() API method of BufferedReader to read a line of text.
Close the BufferedReader, using the close() API method,
*/
// br = new BufferedReader(input);
/*
call_url_line.java:84: error: no suitable constructor found for BufferedReader(InputStream)
br = new BufferedReader(input);
     ^
    constructor BufferedReader.BufferedReader(Reader,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor BufferedReader.BufferedReader(Reader) is not applicable
      (argument mismatch; InputStream cannot be converted to Reader)
1 error

*/

int data = input.read();
// while(data != -1)
while( (line = br.readLine()) != null)
{
    // System.out.print((char) data);
    System.out.print(line);
    
    
    // data = input.read();
}
input.close();

boolean both_same = isEqual(karunashraya_app_link, karunashraya_app_link1);
if (both_same == true)
System.out.println("Both are same" +both_same);
else
System.out.println("Both are not same" +both_same);
}


// public static boolean isEqual(byte[] a, byte[] b) {
public static boolean isEqual(String A, String B) {

byte[] a = A.getBytes();
byte[] b = B.getBytes();
    if (a.length != b.length) {
        return false;
    }

    int result = 0;
    for (int i = 0; i < a.length; i++) {
      result |= a[i] ^ b[i];
    }
    return result == 0;
}


}