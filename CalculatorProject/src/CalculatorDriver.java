/* Windows 7 Calculator Project
 * @Author: Nikesh Patel
 */
import javax.swing.JFrame;

public class CalculatorDriver 
{
   public static void main(String[] args)
   {
       CalculatorMainFrame calculator = new CalculatorMainFrame();
       calculator.setTitle("Calculator");
       calculator.setSize(745,655);
       calculator.setVisible(true);
       calculator.setResizable(false);
       calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
