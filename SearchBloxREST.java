import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class SearchBloxREST {

/**
* @param args
*/
public static void main(String[] args) {

StringBuffer buffer = new StringBuffer();
java.net.URL url;
String result;
String line;
String response = "";
URLConnection connection;

try {
url = new URL( "http://localhost:8080/searchblox/api/rest/add" );
connection = url.openConnection( );
connection.setDoOutput( true );
OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
buffer.append("<?xml version='1.0' encoding='utf-8'?><searchblox licenseid='302C02140D9128DD59B531EEA28B2D35770A28A0653ECA68021479151B41E6042FED8F76E73AFCC02F0CAE33DE37'>");
buffer.append("<document colname='Custom_Collection' location='" + args[0] + "'></document>");
buffer.append("<title boost='1'>My custom title " + args[0]+ "</title>");
buffer.append("<keywords boost='1'>");
buffer.append( "Keyword1, ");
buffer.append("</keywords>");
buffer.append("<category>category1</category>");
buffer.append("</searchblox>");
result = new String( buffer.toString().getBytes(), "UTF-8" );
System.out.println( "\n *INDEX XML * \n\n" + result + "\n\n");
wr.write( result );
wr.flush();
wr.close();

BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
while ((line = rd.readLine()) != null) {
response += line;
}
wr.close();
rd.close();

System.out.println( "\n *INDEX RESPONSE XML * \n\n" + response + "\n\n"); 

}
catch(Exception e){
System.out.println("Errors...");
}
}
}

