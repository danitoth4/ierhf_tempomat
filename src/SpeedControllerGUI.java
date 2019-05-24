import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;


public class SpeedControllerGUI extends AgArch
{
	GridLayout grid;
	JTextField referenceSpeedField;
	JFrame frame;
	JButton setSpeedButton;
	
	public SpeedControllerGUI()
	{
		super();
		
		referenceSpeedField = new JTextField();
		setSpeedButton = new JButton("Set speed!");
		
		setSpeedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try 
				{
					Literal goal = ASSyntax.createLiteral("speedChanged", ASSyntax.createNumber(Double.parseDouble(referenceSpeedField.getText())));
					getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
            }
        });
		grid = new GridLayout(2, 1);
		frame = new JFrame("Speed Controller Monitor");
		frame.getContentPane().setLayout(grid);
		frame.add(referenceSpeedField);
		frame.add(setSpeedButton);
		frame.setSize(300, 100);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
