package clientCountText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class ClientCountTextApplication {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		ClientFrame clientFrame = new ClientFrame();
		clientFrame.setVisible(true);
		
		// Connect to the server at localhost, port 4228
		Socket socket = new Socket (InetAddress.getLocalHost(),4228);
				
		// Update status of the connection
		clientFrame.updateConnectionStatus(socket.isConnected());
		
		String textLine = "How many words are there?";
		clientFrame.updateTextLine(textLine);
		
		//Create output stream to send text
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		outputStream.writeUTF(textLine);
		outputStream.flush();
		
		
		// Create input stream
		BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				
		// Read from network
		String countWord = bufferedReader.readLine();
		clientFrame.updateTextCount(countWord);
		
		
		outputStream.close();
		bufferedReader.close();
		socket.close();
				
		
		
	}

}
