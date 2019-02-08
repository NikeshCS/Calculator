/* Windows 7 Calculator Project
 * @Author: Nikesh Patel
 */

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BaseGroupPanel extends JPanel
{
	public static JRadioButton hexadecimalButton, decimalButton, octalButton, binaryButton;

	public static JPanel basePanel;
	
	public static ButtonGroup basesPanelGroup;
	
	public static JPanel BaseGroupPanel()
	{
		Font font = new Font("Arial",Font.PLAIN, 15); 

	    basePanel = new JPanel();
	    basePanel.setLayout(new GridLayout(4,1));
	    basePanel.setBounds(20, 200, 140, 170);
	    basePanel.setBorder(BorderFactory.createLineBorder(null,1));
	      
	    decimalButton = new JRadioButton("Dec");
	    decimalButton.setSelected(true);
	    decimalButton.setFont(font);

	    binaryButton = new JRadioButton("Bin");
	    binaryButton.setFont(font);
	    octalButton = new JRadioButton("Oct");
	    octalButton.setFont(font);
	    hexadecimalButton = new JRadioButton("Hex");
	    hexadecimalButton.setFont(font);
	      
	    basesPanelGroup = new ButtonGroup();	
	    basesPanelGroup.add(hexadecimalButton);
	    basesPanelGroup.add(decimalButton);
	    basesPanelGroup.add(octalButton);
	    basesPanelGroup.add(binaryButton);
	      
	    basePanel.add(hexadecimalButton);
	    basePanel.add(decimalButton);
	    basePanel.add(octalButton);
	    basePanel.add(binaryButton);
		
	    return basePanel;	
	}
}
