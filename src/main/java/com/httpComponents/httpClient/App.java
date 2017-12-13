package com.httpComponents.httpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import net.sf.json.JSONObject;


public class App {
	public static void main(String[] args) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost("http://192.168.1.112:8080/hernya");
		JSONObject jo = new JSONObject();
		jo.put("String", "name");

		try {
			StringEntity params = new StringEntity(jo.toString());
			request.addHeader("content-type", "application/json");
			request.setEntity(params);

			HttpResponse responce = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(responce.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// int serverPort = 6666;
		// String adress = "192.168.1.119";
		//
		// try {
		// InetAddress ipAdress = InetAddress.getByName(adress);
		// Socket mySocket = new Socket(adress, serverPort);
		// System.out.println("Socket is created");
		//
		// InputStream is = mySocket.getInputStream();
		// OutputStream os = mySocket.getOutputStream();
		// DataInputStream dis = new DataInputStream(is);
		// DataOutputStream dos = new DataOutputStream(os);
		//
		// String line = null;
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("Enter something:");
		//
		// while (true) {
		// line = br.readLine();
		// System.out.println("Sending");
		// dos.writeUTF(line);
		// dos.flush();
		// line = dis.readUTF();
		// System.out.println("Server: " + line);
		// System.out.println("Enter something:");
		// }
		//
		//
		// }catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}
