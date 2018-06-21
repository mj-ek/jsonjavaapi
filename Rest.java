/**

java is installed at
 /usr/lib/jvm/java-8-oracle/jre/bin/java

*/

import java.io.*;
import java.net.*;

public class Rest {

    public static void main(String[] args) throws IOException 
    {
        // URL url = new URL(" http://apps.karunashraya.org:8080/GenericApp/rest/appInfo/getAppName");
        // URL url = new URL("https://swapi.co/api/people/1/");
        URL url = new URL("https://apps.karunashraya.org:8080/GenericApp/rest/appInfo/getAppName");
        /*
java Rest 
Exception in thread "main" javax.net.ssl.SSLException: Unrecognized SSL message, plaintext connection?
	at sun.security.ssl.InputRecord.handleUnknownRecord(InputRecord.java:710)
	at sun.security.ssl.InputRecord.read(InputRecord.java:527)
	at sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:983)
	at sun.security.ssl.SSLSocketImpl.performInitialHandshake(SSLSocketImpl.java:1385)
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1413)
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1397)
	at sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:559)
	at sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:185)
	at sun.net.www.protocol.http.HttpURLConnection.getOutputStream0(HttpURLConnection.java:1334)
	at sun.net.www.protocol.http.HttpURLConnection.getOutputStream(HttpURLConnection.java:1309)
	at sun.net.www.protocol.https.HttpsURLConnectionImpl.getOutputStream(HttpsURLConnectionImpl.java:259)
	at Rest.main(Rest.java:36)

        */
        URL url = new URL("http://apps.karunashraya.org:8080/GenericApp/rest/appInfo/getAppName");
        /*
        java Rest 
Exception in thread "main" java.io.IOException: Server returned HTTP response code: 405 for URL: http://apps.karunashraya.org:8080/GenericApp/rest/appInfo/getAppName
	at sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1894)
	at sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1492)
	at Rest.main(Rest.java:33)


        */
        String query = "";

        //make connection
        URLConnection urlc = url.openConnection();

        //use post mode
        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(false);

        //send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
        ps.print(query);
        ps.close();

        //get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc
            .getInputStream()));
        String l = null;
        while ((l=br.readLine())!=null) {
            System.out.println(l);
        }
        br.close();
    }
}

/*
java Rest 
Exception in thread "main" java.io.IOException: Server returned HTTP response code: 405 for URL: http://apps.karunashraya.org:8080/GenericApp/rest/appInfo/getAppName
	at sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1894)
	at sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1492)
	at Rest.main(Rest.java:28)

*/
