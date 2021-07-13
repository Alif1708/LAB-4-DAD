package clientCountText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class ClientFrame extends JFrame{
	
private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblTextCount;
	private JLabel lblStatusValue;
	private JTextArea txtTextLine;
	
	// Private attributes for frame size
	private int width = 700;
	private int height = 500;
	


	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public ClientFrame () {
		
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
		this.setResizable(false);
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblTextCount = new JLabel("-");
		lblTextCount.setBounds(453, 149, 41, 42);
		lblStatusValue = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	
	
	
	/**
	 * This method update the status of connection to the server.
	 * 
	 * @param connStatus: Connection status (true/false)
	 */
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	/**
	 * This method creates and arrange Swing components to display status of 
	 * client's connection to the server.
	 * 
	 * @param font
	 * @return Swing components organized in a panel.
	 */
	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection Status: ");
		
		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);
		
		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
		
	}
	
	/**
	 * This method creates and arrange Swing components to text count retrieve from 
	 * the server.
 	 *
	 */
	private JPanel getTextCountPanel(Font font) {
		
		
		// Create component to display text count retrieve from the server
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		JLabel lblTitle = new JLabel ("Number Of Words In Text: ");
		lblTitle.setBounds(91, 149, 338, 42);
		JLabel lblText = new JLabel("Text :");
		lblText.setBounds(91, 62, 77, 46);
		txtTextLine = new JTextArea();
		txtTextLine.setEditable(false);
		txtTextLine.setText("How many words are there?");
		txtTextLine.setBounds(178, 62, 384, 46);
		
		
		// Style the component
		lblTitle.setFont(font);
		lblTextCount.setFont(font);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setOpaque(true);
		lblTextCount.setBackground(Color.WHITE);
		lblTextCount.setOpaque(true);
		lblText.setBackground(Color.WHITE);
		lblText.setFont(new Font("Serif", Font.PLAIN, 30));
		lblText.setOpaque(true);
		txtTextLine.setFont(new Font("Serif", Font.PLAIN, 30));
		panel.setLayout(null);
		
		
		
		
		
				
		// Organize components into panel
		panel.add(lblTitle);
		panel.add(lblTextCount);
		panel.add(lblText);
		panel.add(txtTextLine);
		
		
		
		
		return panel;
	} 
	
		
	
	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		// Get server date's panel and add to frame
		JPanel center = getTextCountPanel(font);
		getContentPane().add(center, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}
	
	public void updateTextLine(String text)
	{
		txtTextLine.setEditable(true);
		txtTextLine.setText(text);
		txtTextLine.setEditable(false);
	}
	
	
	public void updateTextCount(String countWord)
	{
		
		lblTextCount.setText(countWord);
	}
	
	
}
