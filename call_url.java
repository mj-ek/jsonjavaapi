import java.io.*;

import java.net.*;


/*
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
*/
public class call_url
{

    public static void main(String[] args) throws IOException 
    {

    
String link = "https://rzp_live_EaQUIRHITZk24W:c0nvbcOjgtaamSZfhAi0doUw@api.razorpay.com";

//    String link = "http://106.51.129.9:8080/GenericApp/rest/appInfo/getAppName";
URL url = new URL(link);

URLConnection urlConnection = url.openConnection();

/*InputStream, using C++ ... stream can be keyboard input, file, socket */
InputStream input = urlConnection.getInputStream();

int data = input.read();
while(data != -1)
{
    System.out.print((char) data);
    data = input.read();
    /* If I comment above line, first character prints in infinite loop
    */
}
input.close();



// After Auth
 link = "https://rzp_live_EaQUIRHITZk24W:c0nvbcOjgtaamSZfhAi0doUw@api.razorpay.com/v1/payments";


 url = new URL(link);

 urlConnection = url.openConnection();

/*InputStream, using C++ ... stream can be keyboard input, file, socket */
 input = urlConnection.getInputStream();

data = input.read();
while(data != -1)
{
    System.out.print((char) data);
    data = input.read();
    /* If I comment above line, first character prints in infinite loop
    */
}
input.close();




}
}
