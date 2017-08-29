package email;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MailTest {
	public static void main(String[] args) {
		JFrame frame = new MailTestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MailTestFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	private Scanner in;
	private PrintWriter out;
	private JTextField from;
	private JTextField to;
	private JTextField smtpServer;
	private JTextArea message;
	private JTextArea comm;
	
	public MailTestFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("MailTest");
		setLayout(new GridBagLayout());
		
		add(new JLabel("From:"));
		from = new JTextField(20);
		add(from);
		
		add(new JLabel("To:"));
		to = new JTextField(20);
		add(to);
		
		add(new JLabel("SMTP server:"));
		smtpServer = new JTextField(20);
		add(smtpServer);
		
		message = new JTextArea();
		add(new JScrollPane(message));
		
		comm = new JTextArea();
		add(new JScrollPane(comm));
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel);
		
		JButton sendButton = new JButton("Send");
		buttonPanel.add(sendButton);
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							comm.setText("");
							sendMail();
						}
					}).start();
			}
		});
	}
	
	public void sendMail(){
		try {
			Socket s = new Socket(smtpServer.getText(),25);
			
			InputStream inStream = s.getInputStream();
			OutputStream outStream = s.getOutputStream();
			
			in = new Scanner(inStream);
			out = new PrintWriter(outStream);
			
			String hostName = InetAddress.getLocalHost().getHostName();
			
			receive();
			send("HELO "+hostName);
			receive();
			send("Mail from: <"+from.getText()+">");
			receive();
			send("RCPT to: <"+to.getText()+">");
			receive();
			send("DATA");
			receive();
			send(message.getText());
			send(".");
			receive();
			s.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String s) throws IOException{
		comm.append(s);
		comm.append("\n");
		
		out.print(s.replaceAll("\n", "\r\n"));
		out.print("\r\n");
		out.flush();
	}
	
	public void receive() throws IOException{
		if(in.hasNextLine()){
			String line = in.nextLine();
			comm.append(line);
			comm.append("\n");
		}
	}
}