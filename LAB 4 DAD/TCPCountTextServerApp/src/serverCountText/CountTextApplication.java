package serverCountText;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CountTextApplication {

	public static void main(String[] args) throws IOException {

		// Launch server frame
		ServerFrame serverFrame = new ServerFrame();
		serverFrame.setVisible(true);
		
		// Connect server socket to a port
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		CountText countText = new CountText();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		serverFrame.updateServerStatus(false);
		while(true)
		{
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			serverFrame.updateServerStatus(clientSocket.isConnected());
			
			// Create input stream to read client's text
			DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
			String text = inputStream.readUTF();
			
			
			String countWord= countText.getCountText(text);
			
			
			// Create stream to write data on the network.s
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
			outputStream.writeBytes(countWord);
			outputStream.flush();
			
			// Close socket
			clientSocket.close();
			inputStream.close();
			outputStream.close();
			
			
			
			
			// Update requests status
			serverFrame.updateRequestStatus(text);
			serverFrame.updateRequestStatus("Number of words from client's text: " + countWord + " words");
			serverFrame.updateRequestStatus(
					"Accepted connection from the client. Total request = "+ ++totalRequest);
			
		}
		
		
	}

}
