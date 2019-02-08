/* Windows 7 Calculator Project
 * @Author: Nikesh Patel
 */
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WordsGroupPanel 
{
	 static public JPanel wordsPanel;
	 static JRadioButton qWordButton, dWordButton, wordButton, byteButton;
	 static ButtonGroup wordsPanelGroup;

	public static JPanel WordsGroupPanel()
	{
		Font font = new Font("Arial",Font.PLAIN, 15); 
	    wordsPanel = new JPanel();
	    wordsPanel.setLayout(new GridLayout(4,1));
	    wordsPanel.setBounds(20, 380, 140, 170);
	    wordsPanel.setBorder(BorderFactory.createLineBorder(null,1));	
	    
	    qWordButton = new JRadioButton("Qword");
	    qWordButton.setSelected(true);
	    qWordButton.setFont(font);
	       
	    dWordButton = new JRadioButton("Dword");
	    dWordButton.setEnabled(false);
	    dWordButton.setVisible(true);
	    dWordButton.setFont(font);
	      
	    wordButton = new JRadioButton("Word");
	    wordButton.setEnabled(false);
	    wordButton.setVisible(true);
	    wordButton.setFont(font);
	       
	    byteButton = new JRadioButton("Byte");
	    byteButton.setEnabled(false);
	    byteButton.setVisible(true);
	    byteButton.setFont(font);
	      
	    wordsPanelGroup = new ButtonGroup();
	    wordsPanelGroup.add(qWordButton);
	    wordsPanelGroup.add(dWordButton);
	    wordsPanelGroup.add(wordButton);
	    wordsPanelGroup.add(byteButton);
	     
	    wordsPanel.add(qWordButton);
	    wordsPanel.add(dWordButton);
	    wordsPanel.add(wordButton);
	    wordsPanel.add(byteButton);
	    
	    return wordsPanel;
	}

}
