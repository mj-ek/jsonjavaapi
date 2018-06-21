import java.io.*;
import java.net.*;

import java.sun.jersey.*;

public class test_call_post
{

	public static void main()
	{

ClientConfig config = new DefaultClientConfig();
com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);

MultiValueMap formData = new MultiValueMapImpl();
formData.add("key", "value");

WebResource resource = client.resource("http://rnd.ekagga.com:8080/GenericAppBeta/rest/category/getcategory");
ClientResponse response = resource.type("application/x-www-form-urlencoded").post(ClientResponse.class, formData);


}
}