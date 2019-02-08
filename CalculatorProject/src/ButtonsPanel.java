/* Windows 7 Calculator Project
 * @Author: Nikesh Patel
 */
import java.awt.*;
import javax.swing.*;

public class ButtonsPanel
{
	static JTextField resultField;
    static JButton aButton, bButton, cButton, dButton, eButton, fButton, 
	   additionButton, subtractionButton, multiplicationButton, divisonButton, equalButton, backSpaceButton,
    oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
    eightButton, nineButton, zeroButton, cancelButton, plusMinusButton, clearButton,
    squareButton, remainButton, recipricolButton, commaButton, quotButton, modButton;
    
    static JTextArea bitsArea;
   
    static JButton emptyOne, emptyTwo, emptyThree, emptyFour, emptyFive, emptySix, emptySeven, emptyEight, emptyNine,
	   emptyTen, emptyEleven, emptyTwelve, emptyThirteen, emptyFourteen, emptyFifteen; 
    
    static JPanel calculatorPanel;
    
    public static JPanel ButtonsPanel()
    {
    	//font
      	Font font = new Font("Arial",Font.PLAIN, 17); 
      	Font font2 = new Font("Arial", Font.PLAIN, 12);

        calculatorPanel = new JPanel();
        
        //null layout
        calculatorPanel.setLayout(null);
  
        //result field 
        resultField = new JTextField("0");
        resultField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        resultField.setEditable(false); 
        resultField.setBounds(20, 20, 700,70);
        resultField.setFont(new Font("Arial",Font.PLAIN, 35));
        calculatorPanel.add(resultField);
       
        //bits area
        bitsArea = new JTextArea();
        CalculatorMainFrame.updateBitsArea("0");
      
        bitsArea.setEditable(false);
        bitsArea.setBounds(20, 100, 700, 90);
        bitsArea.setFont(font);
        calculatorPanel.add(bitsArea);
        
        //individual buttons and layout
        aButton = new JButton("A");
        aButton.setFont(font);
        aButton.setBounds(310, 200, 60, 50);
        calculatorPanel.add(aButton);
       
        bButton = new JButton("B");
        bButton.setFont(font);
        bButton.setBounds(310, 260, 60, 50);
        calculatorPanel.add(bButton);
       
        cButton = new JButton("C");
        cButton.setFont(font);
        cButton.setBounds(310, 320, 60, 50);
        calculatorPanel.add(cButton);
       
        dButton = new JButton("D");
        dButton.setFont(font);
        dButton.setBounds(310, 380, 60, 50);
        calculatorPanel.add(dButton);
       
        eButton = new JButton("E");
        eButton.setFont(font);
        eButton.setBounds(310, 440, 60, 50);
        calculatorPanel.add(eButton);
       
        fButton = new JButton("F");
        fButton.setFont(font);
        fButton.setBounds(310, 500, 60, 50);
        calculatorPanel.add(fButton);
       
        oneButton = new JButton("1");
        oneButton.setFont(font);
        oneButton.setBounds(380, 440, 60, 50);
        calculatorPanel.add(oneButton);
       
        twoButton = new JButton("2");
        twoButton.setFont(font);
        twoButton.setBounds(450, 440, 60, 50);
        calculatorPanel.add(twoButton);
       
        threeButton = new JButton("3");
        threeButton.setFont(font);
        threeButton.setBounds(520, 440, 60, 50);
        calculatorPanel.add(threeButton);
       
        fourButton = new JButton("4");
        fourButton.setFont(font);
        fourButton.setBounds(380, 380, 60, 50);
        calculatorPanel.add(fourButton);
       
        fiveButton = new JButton("5");
        fiveButton.setFont(font);
        fiveButton.setBounds(450, 380, 60, 50);
        calculatorPanel.add(fiveButton);
       
        sixButton = new JButton("6");
        sixButton.setFont(font);
        sixButton.setBounds(520, 380, 60, 50);
        calculatorPanel.add(sixButton);
       
        sevenButton = new JButton("7");
        sevenButton.setFont(font);
        sevenButton.setBounds(380, 320, 60, 50);
        calculatorPanel.add(sevenButton);
       
        eightButton = new JButton("8");
        eightButton.setFont(font);
        eightButton.setBounds(450, 320, 60, 50);
        calculatorPanel.add(eightButton);
       
        nineButton = new JButton("9");
        nineButton.setFont(font);
        nineButton.setBounds(520, 320, 60, 50);
        calculatorPanel.add(nineButton);
       
        zeroButton = new JButton("0");
        zeroButton.setFont(font);
        zeroButton.setBounds(380, 500, 130, 50);
        calculatorPanel.add(zeroButton);
       
        additionButton = new JButton("+");
        additionButton.setFont(font);
        additionButton.setBounds(590, 500, 60, 50);
        calculatorPanel.add(additionButton);
       
        subtractionButton = new JButton("-");
        subtractionButton.setFont(font);
        subtractionButton.setBounds(590, 440, 60, 50);
        calculatorPanel.add(subtractionButton);
       
        multiplicationButton = new JButton("*");
        multiplicationButton.setFont(font);
        multiplicationButton.setBounds(590, 380, 60, 50);
        calculatorPanel.add(multiplicationButton);
       
        divisonButton = new JButton("/");
        divisonButton.setFont(font);
        divisonButton.setBounds(590, 320, 60, 50);
        calculatorPanel.add(divisonButton);
       
        equalButton = new JButton("=");
        equalButton.setFont(font);
        equalButton.setBounds(660, 440, 60, 110);
        calculatorPanel.add(equalButton);
       
        backSpaceButton = new JButton("\u2190");
        backSpaceButton.setFont(font);
        backSpaceButton.setBounds(380, 260, 60, 50);
        calculatorPanel.add(backSpaceButton);
       
        cancelButton = new JButton("CE");
        cancelButton.setFont(font);
        cancelButton.setBounds(450, 260, 60, 50);
        calculatorPanel.add(cancelButton);
       
        clearButton = new JButton("C");
        clearButton.setFont(font);
        clearButton.setBounds(520, 260, 60, 50);
        calculatorPanel.add(clearButton);
       
        plusMinusButton = new JButton("\u00B1");
        plusMinusButton.setFont(font);
        plusMinusButton.setBounds(590, 260, 60, 50);
        calculatorPanel.add(plusMinusButton);
       
        squareButton = new JButton("\u221A");
        squareButton.setFont(font);
        squareButton.setBounds(660, 260, 60, 50);  
        squareButton.setEnabled(false);
        calculatorPanel.add(squareButton);
       
        remainButton = new JButton("%");
        remainButton.setFont(font);
        remainButton.setBounds(660, 320, 60, 50);
        remainButton.setEnabled(false);
        calculatorPanel.add(remainButton);
       
        recipricolButton = new JButton("1/x");
        recipricolButton.setFont(font);
        recipricolButton.setBounds(660, 380, 60, 50);
        recipricolButton.setEnabled(false);
        calculatorPanel.add(recipricolButton);
       
        commaButton = new JButton(".");
        commaButton.setFont(font);
        commaButton.setBounds(520, 500, 60, 50);
        commaButton.setEnabled(false);
        calculatorPanel.add(commaButton);
       
        quotButton = new JButton("Quot");
        quotButton.setFont(font2);
        quotButton.setEnabled(false);
        quotButton.setBounds(170, 200, 60, 50);
        calculatorPanel.add(quotButton);
       
        modButton = new JButton("Mod");
        modButton.setFont(font2);
        modButton.setBounds(240, 200, 60, 50);
        calculatorPanel.add(modButton);
        
        emptyOne = new JButton(" ");
        emptyOne.setBounds(170, 260, 60, 50);
        emptyOne.setEnabled(false);
        calculatorPanel.add(emptyOne);
        
        emptyTwo = new JButton(" ");
        emptyTwo.setBounds(170, 320, 60, 50);
        emptyTwo.setEnabled(false);
        calculatorPanel.add(emptyTwo);
        
        emptyThree = new JButton(" ");
        emptyThree.setBounds(170, 380, 60, 50);
        emptyThree.setEnabled(false);
        calculatorPanel.add(emptyThree);
        
        emptyFour = new JButton(" ");
        emptyFour.setBounds(170, 440, 60, 50);
        emptyFour.setEnabled(false);
        calculatorPanel.add(emptyFour);
        
        emptyFive = new JButton(" ");
        emptyFive.setBounds(170, 500, 60, 50);
        emptyFive.setEnabled(false);
        calculatorPanel.add(emptyFive);
        
        emptySix = new JButton(" ");
        emptySix.setBounds(240, 260, 60, 50);
        emptySix.setEnabled(false);
        calculatorPanel.add(emptySix);
        
        emptySeven = new JButton(" ");
        emptySeven.setBounds(240, 320, 60, 50);
        emptySeven.setEnabled(false);
        calculatorPanel.add(emptySeven);
        
        emptyEight = new JButton(" ");
        emptyEight.setBounds(240, 380, 60, 50);
        emptyEight.setEnabled(false);
        calculatorPanel.add(emptyEight);
        
        emptyNine = new JButton(" ");
        emptyNine.setBounds(240, 440, 60, 50);
        emptyNine.setEnabled(false);
        calculatorPanel.add(emptyNine);
        
        emptyTen = new JButton(" ");
        emptyTen.setBounds(240, 500, 60, 50);
        emptyTen.setEnabled(false);
        calculatorPanel.add(emptyTen);
        
        emptyEleven = new JButton(" ");
        emptyEleven.setBounds(380, 200, 60, 50);
        emptyEleven.setEnabled(false);
        calculatorPanel.add(emptyEleven);
        
        emptyTwelve = new JButton(" ");
        emptyTwelve.setBounds(450, 200, 60, 50);
        emptyTwelve.setEnabled(false);
        calculatorPanel.add(emptyTwelve);
        
        emptyThirteen = new JButton(" ");
        emptyThirteen.setBounds(520, 200, 60, 50);
        emptyThirteen.setEnabled(false);
        calculatorPanel.add(emptyThirteen);
        
        emptyFourteen = new JButton(" ");
        emptyFourteen.setBounds(590, 200, 60, 50);
        emptyFourteen.setEnabled(false);
        calculatorPanel.add(emptyFourteen);
        
        emptyFifteen = new JButton(" ");
        emptyFifteen.setBounds(660, 200, 60, 50);
        emptyFifteen.setEnabled(false);
        calculatorPanel.add(emptyFifteen);
        
        aButton.setEnabled(false);
 	   	bButton.setEnabled(false);
 	   	cButton.setEnabled(false);
 	   	dButton.setEnabled(false);
 	   	eButton.setEnabled(false);
 	   	fButton.setEnabled(false);
 	   	
        return calculatorPanel;  
    }
}
