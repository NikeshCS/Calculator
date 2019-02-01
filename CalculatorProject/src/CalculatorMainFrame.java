/* Windows 7 Calculator Project
 * @Author: Nikesh Patel
 * @Professor: Ziaullah Khan
 */
import java.awt.event.*;
import javax.swing.*;

public class CalculatorMainFrame extends JFrame implements ActionListener
{ 
	String varString, varSaved, operator;
	static int valBase;
	long leftValue;
	long rightValue;
	boolean varSolved, varPushed;

   public CalculatorMainFrame()
   { 
	   varSaved = "";
	   operator = "";
	   leftValue = 0;
	   rightValue = 0;
	   valBase = 10;
	   varSolved = false;
	   varPushed = false;
	  
	   JPanel ButtonsPanel = ButtonsPanel();
	   JPanel BaseGroupPanel = BaseGroupPanel();
	   JPanel WordsGroupPanel = WordsGroupPanel();
	   JMenuBar menuBar = menuBar();
	  
	   ButtonsPanel.add(BaseGroupPanel);
	   ButtonsPanel.add(WordsGroupPanel);
	  
	   this.setJMenuBar(menuBar);
       this.add(ButtonsPanel);
   }
   
   private JPanel ButtonsPanel()
   {
	   JPanel panel1= ButtonsPanel.ButtonsPanel();
	   ButtonsPanel.oneButton.addActionListener(this);
	   ButtonsPanel.resultField.addActionListener(this);
	   ButtonsPanel.twoButton.addActionListener(this);
	   ButtonsPanel.threeButton.addActionListener(this);
	   ButtonsPanel.fourButton.addActionListener(this);
	   ButtonsPanel.fiveButton.addActionListener(this);
	   ButtonsPanel.sixButton.addActionListener(this);
	   ButtonsPanel.sevenButton.addActionListener(this);
	   ButtonsPanel.eightButton.addActionListener(this);
	   ButtonsPanel.nineButton.addActionListener(this);
	   ButtonsPanel.zeroButton.addActionListener(this);
	   ButtonsPanel.plusMinusButton.addActionListener(this);
	   ButtonsPanel.clearButton.addActionListener(this);
	   ButtonsPanel.backSpaceButton.addActionListener(this);
	   ButtonsPanel.divisonButton.addActionListener(this);
	   ButtonsPanel.cancelButton.addActionListener(this);
	   ButtonsPanel.multiplicationButton.addActionListener(this);
	   ButtonsPanel.modButton.addActionListener(this);
	   ButtonsPanel.additionButton.addActionListener(this);
	   ButtonsPanel.subtractionButton.addActionListener(this);
	   ButtonsPanel.equalButton.addActionListener(this);
	   ButtonsPanel.aButton.addActionListener(this);
	   ButtonsPanel.bButton.addActionListener(this);
	   ButtonsPanel.cButton.addActionListener(this);
	   ButtonsPanel.dButton.addActionListener(this);
	   ButtonsPanel.eButton.addActionListener(this);
	   ButtonsPanel.fButton.addActionListener(this);
	  
	   return panel1;
   }
   
   private JPanel BaseGroupPanel()
   {
	   JPanel panel1= BaseGroupPanel.BaseGroupPanel();
	   BaseGroupPanel.binaryButton.addActionListener(this);
	   BaseGroupPanel.decimalButton.addActionListener(this);
	   BaseGroupPanel.hexadecimalButton.addActionListener(this);
	   BaseGroupPanel.octalButton.addActionListener(this);
	   return panel1;
   }
   
   private JPanel WordsGroupPanel()
   {
	   JPanel panel1 = WordsGroupPanel.WordsGroupPanel();
	   WordsGroupPanel.qWordButton.addActionListener(this);
	   return panel1;
   }
   
   private JMenuBar menuBar()
   {
	   JMenuBar menuBar = MenuBar.MenuBar();
	   return menuBar;
   }
   
   public long equateOperations(long val1, long val2, String var)
	{
		long result = 0;
		if(var.equals("+"))
		{
			result = val1 + val2;
		}
		else if(var.equals("-"))
		{
			result = val1 - val2;
		}
		else if(var.equals("*"))
		{
			result = val1 * val2;
		}
		else if(var.equals("/"))
		{
			result = val1 / val2;
		}
		else if(var.equals("%"))
		{
			result = val1 % val2;
		}
		return result;
	}
   	
   public void numberChecking()
   {
	   if(varSolved)
	   {
		   ButtonsPanel.resultField.setText("");
		   varSolved = false;
		   varString = "";
	   }
	   else if (!operator.isEmpty() && !varSaved.isEmpty() && !varSaved.equals(" "))
	   {
		   ButtonsPanel.resultField.setText("");
		   varSaved = " ";
	   }
	   
	   if(ButtonsPanel.resultField.getText().equals("0"))
	   {
		   ButtonsPanel.resultField.setText("");
	   }
	   if(ButtonsPanel.resultField.getText().equals("Error") || ButtonsPanel.resultField.getText().equals("Can't divide by zero"))
	   {
		   ButtonsPanel.resultField.setText("");
	   }
	   varPushed = true;   
	}
   
   public void operationCheck()
   {
	   if(ButtonsPanel.resultField.getText().equals("Error") || ButtonsPanel.resultField.getText().equals("Can't divide by zero"))
	   {
		   ButtonsPanel.resultField.setText("0");
		   return;
	   }
	   if(!varPushed)
	   {
		   return;
	   }
	   if(ButtonsPanel.resultField.getText().equals("0"))
	   {
		   leftValue = 0;
	   }
	   else if(varSaved.isEmpty())
	   {
		   varSaved = ButtonsPanel.resultField.getText();
		   if(BaseGroupPanel.decimalButton.isSelected())
		   {
			   leftValue = Long.parseLong(varSaved);
		   }
		   else if(BaseGroupPanel.binaryButton.isSelected())
		   {
			   leftValue = Long.parseLong(varSaved, 2);
		   }
		   else if(BaseGroupPanel.octalButton.isSelected())
		   {
			   leftValue = Long.parseLong(varSaved,8);
		   }
		   else if(BaseGroupPanel.hexadecimalButton.isSelected())
		   {
			   leftValue = Long.parseLong(varSaved, 16);
		   }
	   }
	   else if(!varSaved.isEmpty() && !operator.isEmpty() && leftValue!= 0)
	   {
		   if(BaseGroupPanel.decimalButton.isSelected())
		   {
			   rightValue = Long.parseLong(ButtonsPanel.resultField.getText());
			   ButtonsPanel.resultField.setText(Long.toString(equateOperations(leftValue, rightValue, operator)));
			   leftValue = equateOperations(leftValue, rightValue, operator);
			   rightValue = 0;;
		   }
		   else if(BaseGroupPanel.binaryButton.isSelected())
		   {
			   rightValue = Long.parseLong(ButtonsPanel.resultField.getText(), 2);
			   ButtonsPanel.resultField.setText(Long.toBinaryString(equateOperations(leftValue,rightValue,operator)));
			   leftValue = equateOperations(leftValue,rightValue,operator);
			   rightValue = 0;
		   }
		   else if(BaseGroupPanel.octalButton.isSelected())
		   {
			   rightValue = Long.parseLong(ButtonsPanel.resultField.getText(), 8);
			   ButtonsPanel.resultField.setText(Long.toOctalString(equateOperations(leftValue,rightValue,operator)));
			   leftValue = equateOperations(leftValue,rightValue,operator);
			   rightValue = 0;
		   }
		   else if(BaseGroupPanel.hexadecimalButton.isSelected())
		   {
			   rightValue = Long.parseLong(ButtonsPanel.resultField.getText(), 16);
			   ButtonsPanel.resultField.setText(Long.toHexString(equateOperations(leftValue,rightValue,operator)));
			   leftValue = equateOperations(leftValue,rightValue,operator);
			   rightValue = 0;
		   }
		   varSolved = true;
	   }
	   varPushed = false;
   }
   
   public static void updateBitsArea(String s)
   {
	   try {
	           Long val = Long.parseLong(s,valBase);
	           String setBitsArea = String.format("%64s", Long.toBinaryString(val)).replace(' ', '0');
	          
		   setBitsArea(setBitsArea);
	   }
	   catch(NumberFormatException n)
	   {
		   ButtonsPanel.resultField.setText("Error ");
	   }
   }
   
   public static void setBitsArea(String s)
   {
	   String val1 = "   ";
	   String val2 = "           ";
	   String val3 = "                                                                     ";
	   String val4 = "                                                       ";
	   String val5 = "                                                         ";
	   
	   ButtonsPanel.bitsArea.setText(val1 + s.substring(0, 4) + val2 + s.substring(4,8) + val2 + s.substring(8,12) + val2 + s.substring(12,16) + 
			   						val2 + s.substring(16,20) + val2 + s.substring(20,24) + val2 + s.substring(24,28) + val2 + s.substring(28,32) + 
			   						"\n" + val1 + "63" + val3 + "47" + val4 + "32" + "\n" + val1 + s.substring(32,36) + val2 + s.substring(36,40) +
			   						val2 + s.substring(40,44) + val2 + s.substring(44,48) + val2 + s.substring(48,52) + val2 + s.substring(52,56) + 
			   						val2 + s.substring(56,60) + "           " + s.substring(60,64) + "\n" + val1 + "31" + val3 + "15" + val5 + "0" );
   }
   
   public void boundsCheckParse(String s)
   {
	   s = ButtonsPanel.resultField.getText() + s;
	   if(BaseGroupPanel.decimalButton.isSelected())
	   {
		   try {
			   ButtonsPanel.resultField.setText(Long.toString(Long.parseLong(s)));
		   }
		   catch(NumberFormatException n)
		   {
			   return;
		   }
	   }
	   else if(BaseGroupPanel.binaryButton.isSelected())
	   {
		   try {
			   ButtonsPanel.resultField.setText(Long.toBinaryString(Long.parseLong(s,2)));
		   }
		   catch(NumberFormatException n)
		   {
			   return;
		   }
	   }
	   else if(BaseGroupPanel.octalButton.isSelected())
	   {
		   try {
			   ButtonsPanel.resultField.setText(Long.toOctalString(Long.parseLong(s,8)));
		   }
		   catch(NumberFormatException n)
		   {
			   return;
		   }
	   }
	   else if(BaseGroupPanel.hexadecimalButton.isSelected())
	   {
		   try {
			   ButtonsPanel.resultField.setText(Long.toHexString(Long.parseLong(s,16)));
		   }
		   catch(NumberFormatException n)
		   {
			   return;
		   }
	   }
   }
  
   @Override
   public void actionPerformed(ActionEvent e) 
	{
	   varString = ButtonsPanel.resultField.getText();
	   if(e.getSource() == ButtonsPanel.zeroButton)
		{
			numberChecking();
			if(ButtonsPanel.resultField.getText().equals("0"))
			{
				ButtonsPanel.resultField.setText("");
				boundsCheckParse("0");
			}
			else
			{
				boundsCheckParse("0");
			}
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.aButton)
		{
			numberChecking();
			boundsCheckParse("A");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.bButton)
		{
			numberChecking();
			boundsCheckParse("B");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.cButton)
		{
			numberChecking();
			boundsCheckParse("C");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.dButton)
		{
			numberChecking();
			boundsCheckParse("D");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.eButton)
		{
			numberChecking();
			boundsCheckParse("E");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.fButton)
		{
			numberChecking();
			boundsCheckParse("F");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.oneButton)
		{
			numberChecking();
			boundsCheckParse("1");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else  if(e.getSource() == ButtonsPanel.twoButton)
		{
			numberChecking();
			boundsCheckParse("2");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else  if(e.getSource() == ButtonsPanel.threeButton)
		{
			numberChecking();
			boundsCheckParse("3");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.fourButton)
		{
			numberChecking();
			boundsCheckParse("4");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.fiveButton)
		{
			numberChecking();
			boundsCheckParse("5");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.sixButton)
		{
			numberChecking();
			boundsCheckParse("6");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.sevenButton)
		{
			numberChecking();
			boundsCheckParse("7");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.eightButton)
		{
			numberChecking();
			boundsCheckParse("8");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.nineButton)
		{
			numberChecking();
			boundsCheckParse("9");
			updateBitsArea(ButtonsPanel.resultField.getText());
		}
	   else if(e.getSource() == ButtonsPanel.additionButton)
	   {
		   operationCheck();
		   operator = "+";
		   updateBitsArea(ButtonsPanel.resultField.getText());
	   }
	   else if(e.getSource() == ButtonsPanel.subtractionButton)
	   {
		   operationCheck();
		   operator = "-";
		   updateBitsArea(ButtonsPanel.resultField.getText());
	   }
	   else if(e.getSource() == ButtonsPanel.multiplicationButton)
	   {
		   operationCheck();
		   operator = "*";
		   updateBitsArea(ButtonsPanel.resultField.getText());
	   }
	   else if(e.getSource() == ButtonsPanel.divisonButton)
	   {
		   operationCheck();
		   operator = "/";
		   updateBitsArea(ButtonsPanel.resultField.getText());
	   }
	   else if(e.getSource() == ButtonsPanel.equalButton)
	   {
		   if(ButtonsPanel.resultField.getText().equals("Can't divide by zero") || ButtonsPanel.resultField.getText().equals("Error"))
		   {
			   return;
		   }
		   else if(!operator.isEmpty() && !varPushed)
		   {
			   return;
		   }
		   rightValue = Long.parseLong(ButtonsPanel.resultField.getText(),valBase);
		   
		   if(!operator.isEmpty())
		   {
			   if(!operator.equals("/") && rightValue == 0)
			   {
				   ButtonsPanel.resultField.setText("Can't divide by zero");
				   updateBitsArea("0");
			   }
		   
			   else if(operator.equals("%") && rightValue == 0)
			   {
				   ButtonsPanel.resultField.setText("Error");
				   updateBitsArea("0");
			   }
			   else
			   {
				   if(BaseGroupPanel.decimalButton.isSelected())
				   {
					   ButtonsPanel.resultField.setText(Long.toString(equateOperations(leftValue,rightValue,operator)));
				   }
				   else if(BaseGroupPanel.binaryButton.isSelected()) 
				   {
					   ButtonsPanel.resultField.setText(Long.toBinaryString(equateOperations(leftValue,rightValue,operator)));
				   }
				   else if(BaseGroupPanel.octalButton.isSelected()) 
				   {
					   ButtonsPanel.resultField.setText(Long.toOctalString(equateOperations(leftValue,rightValue,operator)));
				   }
				   else if(BaseGroupPanel.hexadecimalButton.isSelected()) 
				   {
					   ButtonsPanel.resultField.setText(Long.toHexString(equateOperations(leftValue,rightValue,operator)));
				   }
				   updateBitsArea(ButtonsPanel.resultField.getText());
				   leftValue = equateOperations(leftValue,rightValue,operator);
			   }
			   
		   }
		   operator = "";
		   varSaved = "";
		   varSolved = true;
	   }
	 
	   else if(e.getSource() == ButtonsPanel.clearButton)
	   {
		   varString = "";
		   varSaved = "";
		   leftValue = 0;
		   rightValue = 0;
		   operator = "";
		   varSolved = false;
		   ButtonsPanel.resultField.setText("0");
		   updateBitsArea("0");
	   }
	   else if(e.getSource() == ButtonsPanel.cancelButton)
	   {
		   ButtonsPanel.resultField.setText("0");
		   updateBitsArea("0");
	   }
	   else if(e.getSource() == ButtonsPanel.backSpaceButton)
	   {
		   varString = ButtonsPanel.resultField.getText();
		   if(varString.equals("Error") || varString.equals("Can't divide by zero"))
		   {
			   ButtonsPanel.resultField.setText("0");
			   return;
		   }
		   if(varString.isEmpty())
		   {
			   ButtonsPanel.resultField.setText("0");
			   return;
		   }
		   else if(varString.length() == 1)
		   {
			   ButtonsPanel.resultField.setText("0");
			   varString = "0";
		   }
		   else
		   {
			   varString = varString.substring(0, varString.length()-1);
			   ButtonsPanel.resultField.setText(varString);
		   }
		   updateBitsArea(ButtonsPanel.resultField.getText());
		   
	   }
	   else if(e.getSource() == ButtonsPanel.plusMinusButton)
	   {
		   if(ButtonsPanel.resultField.getText().equals("Error") || ButtonsPanel.resultField.getText().equals("Can't divide by zero"))
		   {
			   return;
		   }
		   String text = ButtonsPanel.resultField.getText();
		  
		   Long number;
		   if(valBase == 10)
		   {
			   number = (Long.parseLong(text) * -1);
			   ButtonsPanel.resultField.setText(Long.toString(number));
		   }
		   else if(valBase == 2)
		   {
			   number = (Long.parseLong(text,2) * -1);
			   ButtonsPanel.resultField.setText(Long.toBinaryString(number));
		   }
		   else if(valBase == 8)
		   {
			   number = (Long.parseLong(text,8 * -1));
			   ButtonsPanel.resultField.setText(Long.toOctalString(number));
		   }
		   else if(valBase == 16)
		   {
			   number = (Long.parseLong(text,16));
			   ButtonsPanel.resultField.setText(Long.toHexString(number));
		   }
		   updateBitsArea(ButtonsPanel.resultField.getText());
	   }
	   else if(e.getSource() == ButtonsPanel.modButton)
	   {
		   operationCheck();
		   operator = "%";
		   updateBitsArea(ButtonsPanel.resultField.getText());
	   }
	   else if(e.getSource() == BaseGroupPanel.decimalButton || e.getSource() == BaseGroupPanel.binaryButton || e.getSource() == BaseGroupPanel.octalButton || e.getSource() == BaseGroupPanel.hexadecimalButton)
	   {
		   if(e.getSource() == BaseGroupPanel.decimalButton)
		   {
			   if(valBase == 10)
			   {
				   
			   }
			   else if(valBase == 2)
			   {
				   ButtonsPanel.resultField.setText(Long.toString(Long.parseLong(ButtonsPanel.resultField.getText(),2)));
				   BaseGroupPanel.binaryButton.setSelected(false);
			   }
			   else if(valBase == 8)
			   {
				   ButtonsPanel.resultField.setText(Long.toString(Long.parseLong(ButtonsPanel.resultField.getText(),8)));
				   BaseGroupPanel.octalButton.setSelected(false);
			   }
			   else if(valBase == 16)
			   {
				   ButtonsPanel.resultField.setText(Long.toString(Long.parseLong(ButtonsPanel.resultField.getText(),16)));
				   BaseGroupPanel.hexadecimalButton.setSelected(false);
			   }
			   BaseGroupPanel.decimalButton.setSelected(true);
			   ButtonsPanel.aButton.setEnabled(false);
			   ButtonsPanel.bButton.setEnabled(false);
			   ButtonsPanel.cButton.setEnabled(false);
			   ButtonsPanel.dButton.setEnabled(false);
			   ButtonsPanel.eButton.setEnabled(false);
			   ButtonsPanel.fButton.setEnabled(false);
			   ButtonsPanel.zeroButton.setEnabled(true);
			   ButtonsPanel.oneButton.setEnabled(true);
			   ButtonsPanel.twoButton.setEnabled(true);
			   ButtonsPanel.threeButton.setEnabled(true);
			   ButtonsPanel.fourButton.setEnabled(true);
			   ButtonsPanel.fiveButton.setEnabled(true);
			   ButtonsPanel.sixButton.setEnabled(true);
			   ButtonsPanel.sevenButton.setEnabled(true);
			   ButtonsPanel.eightButton.setEnabled(true);
			   ButtonsPanel.nineButton.setEnabled(true);
			   updateBitsArea(ButtonsPanel.resultField.getText());
		   
		   }
		   else if(e.getSource() == BaseGroupPanel.binaryButton)
		   {
			   if(valBase == 10)
			   {
				   ButtonsPanel.resultField.setText(Long.toBinaryString(Long.parseLong(ButtonsPanel.resultField.getText())));
				   BaseGroupPanel.octalButton.setSelected(false);
			   }
			   else if(valBase == 2)
			   {
				   
			   }
			   else if(valBase == 8)
			   {
				   ButtonsPanel.resultField.setText(Long.toBinaryString(Long.parseLong(ButtonsPanel.resultField.getText(),8)));
				   BaseGroupPanel.octalButton.setSelected(false);
			   }
			   else if(valBase == 16)
			   {
				   ButtonsPanel.resultField.setText(Long.toBinaryString(Long.parseLong(ButtonsPanel.resultField.getText(),16)));
				   BaseGroupPanel.hexadecimalButton.setSelected(false);
			   }
			   BaseGroupPanel.binaryButton.setSelected(true);
			   valBase = 2;
			   ButtonsPanel.aButton.setEnabled(false);
			   ButtonsPanel.bButton.setEnabled(false);
			   ButtonsPanel.cButton.setEnabled(false);
			   ButtonsPanel.dButton.setEnabled(false);
			   ButtonsPanel.eButton.setEnabled(false);
			   ButtonsPanel.fButton.setEnabled(false);
			   ButtonsPanel.zeroButton.setEnabled(true);
			   ButtonsPanel.oneButton.setEnabled(true);
			   ButtonsPanel.twoButton.setEnabled(false);
			   ButtonsPanel.threeButton.setEnabled(false);
			   ButtonsPanel.fourButton.setEnabled(false);
			   ButtonsPanel.fiveButton.setEnabled(false);
			   ButtonsPanel.sixButton.setEnabled(false);
			   ButtonsPanel.sevenButton.setEnabled(false);
			   ButtonsPanel.eightButton.setEnabled(false);
			   updateBitsArea(ButtonsPanel.resultField.getText());
		   }
		   else if(e.getSource() == BaseGroupPanel.octalButton)
		   {
			   if(valBase == 10)
			   {
				   ButtonsPanel.resultField.setText(Long.toOctalString(Long.parseLong(ButtonsPanel.resultField.getText())));
				   BaseGroupPanel.decimalButton.setSelected(false);
			   }
			   else if(valBase ==2)
			   {
				   ButtonsPanel.resultField.setText(Long.toOctalString(Long.parseLong(ButtonsPanel.resultField.getText(), 2)));
				   BaseGroupPanel.binaryButton.setSelected(false);
			   }
			   else if(valBase == 8)
			   {
				   
			   }
			   else if(valBase == 16)
			   {
				   ButtonsPanel.resultField.setText(Long.toOctalString(Long.parseLong(ButtonsPanel.resultField.getText(), 16)));
				   BaseGroupPanel.hexadecimalButton.setSelected(false);
			   }
			   BaseGroupPanel.octalButton.setSelected(true);
			   valBase = 8;
			   ButtonsPanel.aButton.setEnabled(false);
			   ButtonsPanel.bButton.setEnabled(false);
			   ButtonsPanel.cButton.setEnabled(false);
			   ButtonsPanel.dButton.setEnabled(false);
			   ButtonsPanel.eButton.setEnabled(false);
			   ButtonsPanel.fButton.setEnabled(false);
			   ButtonsPanel.zeroButton.setEnabled(true);
			   ButtonsPanel.oneButton.setEnabled(true);
			   ButtonsPanel.twoButton.setEnabled(true);
			   ButtonsPanel.threeButton.setEnabled(true);
			   ButtonsPanel.fourButton.setEnabled(true);
			   ButtonsPanel.fiveButton.setEnabled(true);
			   ButtonsPanel.sixButton.setEnabled(true);
			   ButtonsPanel.sevenButton.setEnabled(true);
			   ButtonsPanel.eightButton.setEnabled(false);
			   ButtonsPanel.nineButton.setEnabled(false);
			   updateBitsArea(ButtonsPanel.resultField.getText());
		   }
		   else if(e.getSource() == BaseGroupPanel.hexadecimalButton)
		   {
			   if(valBase == 10)
			   {
				   ButtonsPanel.resultField.setText(Long.toHexString(Long.parseLong(ButtonsPanel.resultField.getText())));
				   BaseGroupPanel.decimalButton.setSelected(false);
			   }
			   else if (valBase ==2)
			   {
				   ButtonsPanel.resultField.setText(Long.toHexString(Long.parseLong(ButtonsPanel.resultField.getText(),2)));
				   BaseGroupPanel.binaryButton.setSelected(false);
			   }
			   else if(valBase == 8)
			   {
				   ButtonsPanel.resultField.setText(Long.toHexString(Long.parseLong(ButtonsPanel.resultField.getText(), 8)));
				   BaseGroupPanel.octalButton.setSelected(false);
			   }
			   else if(valBase == 16)
			   {
				   
			   }
			   BaseGroupPanel.hexadecimalButton.setSelected(true);
			   valBase = 16;
			   ButtonsPanel.aButton.setEnabled(true);
			   ButtonsPanel.bButton.setEnabled(true);
			   ButtonsPanel.cButton.setEnabled(true);
			   ButtonsPanel.dButton.setEnabled(true);
			   ButtonsPanel.eButton.setEnabled(true);
			   ButtonsPanel.fButton.setEnabled(true);
			   ButtonsPanel.zeroButton.setEnabled(true);
			   ButtonsPanel.oneButton.setEnabled(true);
			   ButtonsPanel.twoButton.setEnabled(true);
			   ButtonsPanel.threeButton.setEnabled(true);
			   ButtonsPanel.fourButton.setEnabled(true);
			   ButtonsPanel.fiveButton.setEnabled(true);
			   ButtonsPanel.sixButton.setEnabled(true);
			   ButtonsPanel.sevenButton.setEnabled(true);
			   ButtonsPanel.eightButton.setEnabled(true);
			   ButtonsPanel.nineButton.setEnabled(true);
			   updateBitsArea(ButtonsPanel.resultField.getText());
			   
		   }   	   
	   }
	}
}
  