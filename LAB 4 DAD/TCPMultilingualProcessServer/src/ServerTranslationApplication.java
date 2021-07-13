import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=null;
		try {
			
			// Bind server socket to a port
			int portNo=4228;
			serverSocket = new ServerSocket(portNo);
			
			TranslatorServerFrame serverFrame = new TranslatorServerFrame();
			serverFrame.setVisible(true);
			
			serverFrame.updateServerStatus(false);
			Translator translator= new Translator();
			int totalRequest=0;
			
			while(true)
			{
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				serverFrame.updateServerStatus(clientSocket.isConnected());
				
				
				int languageOption,text;
				DataInputStream iS1 = new DataInputStream(clientSocket.getInputStream());
				languageOption= iS1.readInt();
				text= iS1.readInt();
				
				
				String result = translator.chooseLanguage(languageOption, text);
				
				// create stream to write data on network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				serverFrame.updateRequestStatus(result);
				// send data to client
				outputStream.writeUTF(result);
				outputStream.flush();
				
				
				serverFrame.updateRequestStatus("Language Option "+ languageOption);
				
				iS1.close();
				
				clientSocket.close();
				outputStream.close();
			}
			
			
			
		}catch(IOException ioe)
		{
			if(serverSocket!= null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
