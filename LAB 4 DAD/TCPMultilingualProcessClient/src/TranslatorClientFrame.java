import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TranslatorClientFrame extends JFrame implements ActionListener {

private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblStatusValue;
	private JLabel lblResultAns;
	private JComboBox comboBoxSentence;
	private JComboBox comboBoxOption;
	private int language, sentence;
	
	// Private attributes for frame size
	private int width = 700;
	private int height = 500;


	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public TranslatorClientFrame () {
		
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		lblStatusValue = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	
	public void updateResultAns (String resultAns) {
		
		Font font;
		
		if (language == 1)
		{	
			font = new Font("Malgun Gothic", Font.PLAIN, 30);
			this.lblResultAns.setFont(font);
		}
		else 
		{
			font = this.getFontStyle();
			this.lblResultAns.setFont(font);
		}
			
		
		this.lblResultAns.setText(resultAns);
		
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
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
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
	
	
	private JPanel getLanguangeOptionPanel (Font font) {
		
		// Create component to get client's translation option
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		JLabel lblLanguageOption = new JLabel ("Translation Language : ");

		// Set up translation language option in comboBox 
		String [] optionList = {"Bahasa Melayu","Korean","Arabic"};
		comboBoxOption = new JComboBox(optionList);
		
		// Style the component
		lblLanguageOption.setFont(font);
		lblLanguageOption.setBackground(Color.WHITE);
		lblLanguageOption.setOpaque(true);
		comboBoxOption.setFont(font);

		// Organize components into panel
		panel.add(lblLanguageOption);
		panel.add(comboBoxOption);
		
		return panel;
	} 
	
	
	private JPanel getSentencePanel (Font font)
	{
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,204,204));	
		JLabel lblSentence = new JLabel("English Sentence :");
		JButton translate= new JButton("Go");
		
		// Set up translation language option in comboBox 
		String [] sentenceList = {"Good morning","Good night","How are you?", "Thank you", 
					"Goodbye","What's up?"};
		comboBoxSentence = new JComboBox(sentenceList);
		
		// Style the component
		lblSentence.setFont(font);
		lblSentence.setBackground(Color.WHITE);
		lblSentence.setOpaque(true);
		comboBoxSentence.setFont(font);
		
		
		translate.addActionListener(this);
		
		
		
		System.out.println(language);
		panel.add(lblSentence);
		panel.add(comboBoxSentence);
		panel.add(translate);
			
		return panel;
				
	}
	
	public void waitForInputs() throws InterruptedException {
	    synchronized (this) 
	    {
	        // Make the current thread waits until a notify or an interrupt
	        wait();
	    }
	} 
	
	// panel display translation result
	private JPanel getResult (Font font)
	{
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,204,204));
		
		JLabel lblResult = new JLabel ("Translation Result : ");
		lblResultAns = new JLabel ("-");
		
		// Style the component
		lblResult.setFont(font);
		lblResult.setBackground(Color.WHITE);
		lblResult.setOpaque(true);
			
		lblResultAns.setFont(font);
		lblResultAns.setBackground(Color.WHITE);
		lblResultAns.setOpaque(true);
		
		
		// Style the component
		lblResult.setFont(font);
		lblResult.setBackground(Color.WHITE);
		lblResult.setOpaque(true);
		
		panel.add(lblResult);
		panel.add(lblResultAns);
		
			
		return panel;
		

	}
	
	
	
	// getter to get client's option at application layer
	public int getLanguage ()
	{
		return language;
	}
	
	public int getSentence ()
	{
		return sentence;
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
		
		JPanel center = getLanguangeOptionPanel(font);
		JPanel center2 = getSentencePanel(font);
		JPanel center3 = getResult(font);
		
		JPanel centerCombinePanel = new JPanel ();
		centerCombinePanel.setBackground(new Color(255,204,204));
		centerCombinePanel.add(center);
		centerCombinePanel.add(center2);
		centerCombinePanel.add(center3);
		
		getContentPane().add(centerCombinePanel,BorderLayout.CENTER);
		
				
		
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



	public void actionPerformed(ActionEvent e) {
		
			
			language = comboBoxOption.getSelectedIndex();
			sentence = comboBoxSentence.getSelectedIndex();
			
			synchronized (this)
			{
				
				this.notifyAll();
			}
			
		
		
	}
	
	
	
	
	
}
