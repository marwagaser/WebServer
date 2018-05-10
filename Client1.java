import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class Client1 {
	static JFrame pur;
	static JPanel panel;
	static JButton b1;
	static JButton b2;
	static JButton b3;
	static JButton b4;
	static JButton b5;
	static JButton b6;
	static JButton b7;
	static JButton b8;
	static JButton b9;
	static JButton b10;
	static JButton b11;
	static JButton b12;
	static TextArea ta;
	static JButton t;
	static String request;
	static String newrequest;
	// public static String newrequest = "";

	public static void readin(String fn, JTextComponent pane) {
		try {
			FileReader fr = new FileReader(fn);
			pane.read(fr, null);
			fr.close();
		} catch (IOException e) {
			// System.err.println(e);
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {

		pur = new JFrame();
		JTextComponent textpane = new JTextArea();

		pur.setLayout(new GridLayout());
		pur.setSize(5000, 5000);
		panel = new JPanel();
		// We will add buttons here
		b1 = new JButton();
		b1.setText("Text 1");
		b2 = new JButton();
		b2.setText("Text 2");
		b3 = new JButton();
		b3.setText("Text 3");
		b4 = new JButton();
		b4.setText("Text 4");
		b5 = new JButton();
		b5.setText("JPEG 1");
		b6 = new JButton();
		b6.setText("JPEG 2");
		b7 = new JButton();
		b7.setText("PNG 1");
		b8 = new JButton();
		b8.setText("PNG 2");
		b9 = new JButton();
		b9.setText("MP4 1");
		b10 = new JButton();
		b10.setText("MP4 2");
		b11 = new JButton();
		b11.setText("404 Error");
		b12 = new JButton();
		b12.setText("Close");

		t = new JButton();
		t.setText("hiz");
		t.setText("trr");
		ta = new TextArea(100, 100);
		ta.setBackground(Color.PINK);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b10);
		panel.add(b11);
		panel.add(b12);
		panel.add(ta);
		panel.add(t);
		t.setVisible(false);
		panel.add(textpane);
		pur.add(panel);
		pur.setVisible(true);

		Socket clientSocket = new Socket("marwagaser", 6789);// 80 not working
		DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		////////////////////////
		Thread outgoingmsg = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				// take intput msg from user

				// ****************************************8888
				String msg = "";

				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET dblec.txt Http/1.1\n Host: www.google.com\ntxt\nConnection: KeepAlive";
						newrequest = "GET dblec.txt Http/1.1\nwww.google.com\ntxt\nKeepAlive";
						String response = "200 OK";
						readin("DocRoot/dblec.txt", textpane);
						final JScrollPane pane = new JScrollPane(textpane);
						pane.setPreferredSize(new Dimension(600, 600));
						panel.add(textpane);
						ta.setText("");

						////////////////////////////////////
						try {
							outToServer.writeUTF(newrequest);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						panel.add(ta);
						////////////////////////////////////////
						// JOptionPane.showMessageDialog (null, ManageClients.response, "Title",
						//////////////////////////////////////// JOptionPane.INFORMATION_MESSAGE);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET oslec.txt Http/1.1\n Host: www.google.com\ntxt\nConnection: KeepAlive";

						 newrequest = "GET oslec.txt Http/1.1\nwww.google.com\ntxt\nKeepAlive";
						String response = "200 OK";
						JLabel j = new JLabel();
						j.setText(newrequest);
						
						readin("DocRoot/oslec.txt", textpane);
						final JScrollPane pane = new JScrollPane(textpane);
						pane.setPreferredSize(new Dimension(600, 600));
						panel.add(textpane);
						////////////////////////////////////
						ta.setText("");
						try {
							outToServer.writeUTF(newrequest);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						panel.add(ta);
						panel.add(j);
						////////////////////////////////////////
						// JOptionPane.showMessageDialog (null, ManageClients.response, "Title",
						//////////////////////////////////////// JOptionPane.INFORMATION_MESSAGE);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET selec.txt Http/1.1\n Host: www.google.com\ntxt\nConnection: Close";
						
						 newrequest = "GET selec.txt Http/1.1\nwww.google.com\ntxt\nclose";
						String response = "200 OK";
						readin("DocRoot/selec.txt", textpane);
						final JScrollPane pane = new JScrollPane(textpane);
						pane.setPreferredSize(new Dimension(600, 600));
						panel.add(textpane);
						////////////////////////////////////
						ta.setText("");
						try {
							outToServer.writeUTF(newrequest);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);
						Client1.b1.setEnabled(false);
						Client1.b2.setEnabled(false);
						Client1.b3.setEnabled(false);
						Client1.b4.setEnabled(false);
						Client1.b5.setEnabled(false);
						Client1.b6.setEnabled(false);
						Client1.b7.setEnabled(false);
						Client1.b8.setEnabled(false);
						Client1.b9.setEnabled(false);
						Client1.b10.setEnabled(false);
						Client1.b11.setEnabled(false);

					}

				});

				b4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);
						
						request="Method:GET networkslec.txt Http/1.1\n Host: www.google.com\ntxt\nConnection: KeepAlive";

						 newrequest = "GET networkslec.txt Http/1.1\nwww.google.com\ntxt\nKeepAlive";
						String response = "200 OK";
						readin("DocRoot/networkslec.txt", textpane);
						final JScrollPane pane = new JScrollPane(textpane);
						pane.setPreferredSize(new Dimension(600, 600));
						panel.add(textpane);
						////////////////////////////////////
						ta.setText("");
						try {
							outToServer.writeUTF(newrequest);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						panel.add(ta);
						////////////////////////////////////////
						// JOptionPane.showMessageDialog (null, ManageClients.response, "Title",
						//////////////////////////////////////// JOptionPane.INFORMATION_MESSAGE);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);
					}

				});

				b5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET cat.jpg Http/1.1\n Host: www.google.com\njpg\nConnection: KeepAlive";

						 newrequest = "GET cat.jpg Http/1.1\nwww.google.com\njpeg\nKeepAlive";
						// String response = "200 OK";

						BufferedImage image;
						ta.setText("");

						try {
							image = ImageIO.read(new File("DocRoot/cat.jpg"));
							JLabel wIcon = new JLabel((Icon) new ImageIcon(image));
							panel.add(wIcon);
							outToServer.writeUTF(newrequest);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);
						
						request="Method:GET dog.jpg Http/1.1\n Host: www.google.com\njpg\nConnection: KeepAlive";

						 newrequest = "GET dog.jpg Http/1.1\nwww.google.com\njpeg\nKeepAlive";
						// String response = "200 OK";

						BufferedImage image;
						ta.setText("");

						try {
							image = ImageIO.read(new File("DocRoot/dog.jpg"));
							JLabel wIcon = new JLabel((Icon) new ImageIcon(image));
							panel.add(wIcon);
							outToServer.writeUTF(newrequest);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});
				b7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET messenger.png Http/1.1\n Host: www.google.com\npng\nConnection: KeepAlive";

						 newrequest = "GET messenger.png Http/1.1\nwww.google.com\npng\nKeepAlive";
						// String response = "200 OK";

						BufferedImage image;
						ta.setText("");

						try {
							image = ImageIO.read(new File("DocRoot/messenger.png"));
							JLabel wIcon = new JLabel((Icon) new ImageIcon(image));
							panel.add(wIcon);
							outToServer.writeUTF(newrequest);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET twitter.png Http/1.1\n Host: www.google.com\npng\nConnection: KeepAlive";

						 newrequest = "GET twitter.png Http/1.1\nwww.google.com\npng\nKeepAlive";
						// String response = "200 OK";

						BufferedImage image;
						ta.setText("");

						try {
							image = ImageIO.read(new File("DocRoot/twitter.png"));
							JLabel wIcon = new JLabel((Icon) new ImageIcon(image));
							panel.add(wIcon);
							outToServer.writeUTF(newrequest);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET Vid1.mp4 Http/1.1\n Host: www.google.com\nmp4\nConnection: KeepAlive";

						 newrequest = "GET Vid1.mp4 Http/1.1\nwww.google.com\nmp4\nKeepAlive";
						// String response = "200 OK";

						ta.setText("");

						try {
							Desktop.getDesktop().open(new File("DocRoot/Vid1.mp4"));
							outToServer.writeUTF(newrequest);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);

						request="Method:GET Vid2.mp4 Http/1.1\n Host: www.google.com\nmp4\nConnection: KeepAlive";

						 newrequest = "GET Vid2.mp4 Http/1.1\nwww.google.com\nmp4\nKeepAlive";
						// String response = "200 OK";

						ta.setText("");

						try {
							Desktop.getDesktop().open(new File("DocRoot/Vid2.mp4"));
							outToServer.writeUTF(newrequest);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);
					}
				});

				b11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(b1);
						panel.add(b2);
						panel.add(b3);
						panel.add(b4);
						panel.add(b5);
						panel.add(b6);
						panel.add(b7);
						panel.add(b8);
						panel.add(b9);
						panel.add(b10);
						panel.add(b11);
						panel.add(b12);
						
						request="Method:GET twitterz.png Http/1.1\n Host: www.google.com\npng\nConnection: KeepAlive";


						 newrequest = "GET twitterz.png Http/1.1\nwww.google.com\npng\nKeepAlive";
						// String response = "200 OK";

						BufferedImage image;
						ta.setText("");

						try {
							outToServer.writeUTF(newrequest);
							image = ImageIO.read(new File("DocRoot/twitterz.png"));

						} catch (IOException e1) {
							// TODO Auto-generated catch block

						}
						panel.add(ta);
						pur.setContentPane(panel);
						pur.repaint();
						pur.invalidate();
						pur.validate();
						pur.setVisible(true);

					}
				});

				b12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							outToServer.writeUTF("close");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						pur.setVisible(false);

					}
				});

			}

		});

		Thread incomingmsg = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// String display;
				while (true) {

					try {
						String showIT = inFromServer.readUTF();
						ta.append("The response : \n");

						ta.append(showIT);
						ta.append("\n");
						ta.append("The request : \n");
						ta.append(request);
						// System.out.println(showIT);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});

		// start both reads
		outgoingmsg.start();
		incomingmsg.start();
		// String newrequest="";/////////////////////////////////

		// start both reads

	}

	/*
	 * public static void Composedmsg(JButton button, String message,
	 * DataOutputStream outToServer) {// ADD TEXTFIELD FE EL // MSG Thread
	 * outgoingmsg = new Thread(new Runnable() {
	 * 
	 * @Override public void run() {
	 * 
	 * button.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
	 * method stub // while (true) { String msg = message;
	 * 
	 * try { outToServer.writeUTF(msg); } catch (IOException e2) { // TODO
	 * Auto-generated catch block e2.printStackTrace(); } } // }
	 * 
	 * }); }
	 * 
	 * }); outgoingmsg.start();
	 * 
	 * }
	 * 
	 * public static void ReceivedMsg(DataInputStream inFromServer, TextArea ja) {
	 * 
	 * Thread incomingmsg = new Thread(new Runnable() {
	 * 
	 * @Override public void run() { // TODO Auto-generated method stub // String
	 * display; while (true) {
	 * 
	 * try { String showIT = inFromServer.readUTF(); ja.append(showIT);
	 * System.out.println(showIT);
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * }
	 * 
	 * }); incomingmsg.start();
	 * 
	 * }
	 */
}

// }