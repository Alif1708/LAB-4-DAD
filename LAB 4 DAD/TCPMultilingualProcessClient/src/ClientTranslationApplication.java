import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTranslationApplication {

	public static void main(String[] args)  {
		
		TranslatorClientFrame clientFrame = new TranslatorClientFrame();
		clientFrame.setVisible(true);
		

		try {
			
			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
			
			// Update the status of the connection
			clientFrame.updateConnectionStatus(socket.isConnected());
			
			clientFrame.waitForInputs();
			
			int language = clientFrame.getLanguage();
			int sentence = clientFrame.getSentence();
			System.out.println(language);	
			
			// Send the client language option and sentence option to server
			DataOutputStream outputStream1 = new DataOutputStream (socket.getOutputStream());
			outputStream1.writeInt(language);			
			outputStream1.writeInt(sentence);
			outputStream1.flush();
			
			
			
			
			// Receive translated result from server
			DataInputStream inputStream = new DataInputStream (socket.getInputStream());
			String result = inputStream.readUTF();
			System.out.print(result);
			clientFrame.updateResultAns(result);
			
			inputStream.close();
			socket.close();
			outputStream1.close();
			
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

}
