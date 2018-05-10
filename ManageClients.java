import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.portable.InputStream;

public class ManageClients implements Runnable {

	private static final int FILE_SIZE = 0;
	private static final String FILE_TO_RECEIVED = null;
	Scanner sc = new Scanner(System.in);
	public String clientid;
	final DataInputStream fromClient;
	final DataOutputStream outToClient;
	Socket connSocket;
	String onlineClient;

	public void GetQ() throws IOException {
		int size = server1.q.size();
		for (int i = 0; i < size; i++) {
			httprequest hr1 = server1.q.poll();
			server1.q.add(hr1);
			this.outToClient.writeUTF(hr1.host + " " + hr1.method + " " + hr1.accept + " " + hr1.connection);

		}
	}

	public ManageClients(Socket connSocket, String clientid, DataInputStream fromClient, DataOutputStream outToClient) {
		// this.onlineClient=true;
		this.onlineClient = "Yes";
		this.connSocket = connSocket;
		this.clientid = clientid;
		this.fromClient = fromClient;
		this.outToClient = outToClient;
	}

	public void run() {
		while (true) {
			try {

				String sentence = fromClient.readUTF();// MESSAGE FROM CLIENT

				System.out.println(sentence);
				String[] sen = sentence.split("\n");
				String method = sen[0];

				String host = sen[1];// esm el website

				String accept = sen[2];// type jpeg or what

				String conn = sen[3];

				String[] sMethod = method.split(" ");
				String getM = sMethod[0];// get,post
				String url = sMethod[1];// url
				String httpT = sMethod[2];// no3 el http

				if (getM.equalsIgnoreCase("GET")) {
					// do
					if (accept.equalsIgnoreCase("jpeg") || accept.equalsIgnoreCase("txt")
							|| accept.equalsIgnoreCase("png") || accept.equalsIgnoreCase("mp4")) {
						httprequest hr = new httprequest(method, host, accept, conn);
						server1.q.add(hr);
						String typez = server1.q.peek().accept;
						String conz = server1.q.peek().connection;
						String answer = exists();
						if (answer.equals("")) {
							String response = "";
							response += "Status : 202 OK\nVersion : Http/1.1\nTimeStamp : ";
							String timeStamp = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss").format(new Date());
							response += timeStamp;
							response += "\nFormat:" + typez;
							response += "\nConnection: " + conz;
							this.outToClient.writeUTF(response);
						} else {
							String response = "";
							response += "Status: 404 Not Found\n Version : Http/1.1 \n TimeStamp : ";
							String timeStamp = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss").format(new Date());
							response += timeStamp;
							response += "\n Format : " + typez;
							response += "\n Connection : " + conz;
							this.outToClient.writeUTF(response);
						}
						// GetQ();
						/*
						 * this.outToClient.writeUTF(
						 * "The server has recieved your request and it has been added to the queue of requests"
						 * );
						 */if (conz.equalsIgnoreCase("Keepalive")) {

						} else if (conz.equalsIgnoreCase("close")) {

							this.outToClient.close();
						}

					} else {
						this.outToClient.writeUTF("Wrong file format");
					}

				} else if (getM.equalsIgnoreCase("Q")) {
					httprequest hr = new httprequest(method, host, accept, conn);
					// this.outToClient.writeUTF(hr.host);
					server1.q.add(hr);

					GetQ();
				} else {
					this.outToClient.writeUTF("USE GET PLEASE");
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		

	}

	public static String getThePath() {
		httprequest http = server1.q.poll();
		String h = http.method;
		String[] s = h.split(" ");
		String thing = s[1];
		String path = "DocRoot/";
		path += thing;
		return path;
	}


	public static String exists() {
		String x = "";
		File f = new File(getThePath());
		if (f.exists()) {
			// System.out.println("success");
		} else {
			x = "404";
		}
		return x;
	}

}