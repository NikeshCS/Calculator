/* Windows 7 Calculator Project
 * @Author: Nikesh Patel
 */

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MenuBar 
{
	static StringSelection sSelection;
	static Clipboard clipboard;

	public static JMenuBar MenuBar()
	{
		 	clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		   
			Font font = new Font("Arial",Font.PLAIN, 15); 
			
		    JMenuBar menuBar= new JMenuBar();
		    
		    JMenu menuBarContentOne= new JMenu("View");
		    JMenu menuBarContentTwo= new JMenu("Edit");
		    JMenu menuBarContentThree= new JMenu("Help");
		   
		    menuBarContentOne.setFont(font);
		    menuBarContentTwo.setFont(font);
		    menuBarContentThree.setFont(font);
		  
		    menuBar.add(menuBarContentOne);
		    menuBar.add(menuBarContentTwo);
		    menuBar.add(menuBarContentThree);
		    
		    JMenuItem view = new JMenuItem(new AbstractAction("View") {
		    	public void actionPerformed(ActionEvent e) {
		    		ButtonsPanel.calculatorPanel.setVisible(true);
		    	}
		    });
		    
		    JMenuItem hide = new JMenuItem(new AbstractAction("Hide") {
		    	public void actionPerformed(ActionEvent e) {
		    		ButtonsPanel.calculatorPanel.setVisible(false);
		    	}
		    });
		   
		    JMenuItem copy = new JMenuItem(new AbstractAction("Copy") {
		    	public void actionPerformed(ActionEvent e) {
		    		sSelection = new StringSelection(ButtonsPanel.resultField.getText());
		    		clipboard.setContents(sSelection,null);
		    	}
		    });
		    
		    JMenuItem help = new JMenuItem(new AbstractAction("Help") {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
		    			Desktop.getDesktop().browse(new URL("https://support.microsoft.com/en-us/products/windows?os=windows-10").toURI());
		    		} catch (Exception f) {
		    			f.printStackTrace();
		    		}
		    	}
		    });
		    
		    JMenuItem about = new JMenuItem(new AbstractAction("About") {
		    	public void actionPerformed(ActionEvent e) {
		    		JFrame frame = new JFrame("About");
		    		JTextArea label = new JTextArea("This Windows 7 calculator replica was created by Nikesh Patel");
		    		frame.add(label);
		    		frame.setSize(600, 600);
		    		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		    		frame.setVisible(true);
		    	}
		    });
		    
		    menuBarContentOne.add(view);
		    menuBarContentOne.add(hide);   
		    menuBarContentTwo.add(copy); 
		    menuBarContentThree.add(help);
		    menuBarContentThree.add(about);
		    
		    return menuBar;
	}
}
