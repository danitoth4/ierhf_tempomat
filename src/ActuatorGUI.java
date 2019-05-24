import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;


public class ActuatorGUI extends AgArch
{
	GridLayout grid;
	JTextField referenceSpeedField;
	JFrame frame;
	JButton setSpeedButton;
	JTextField distance_t_1_Field;
	JTextField distance_t_Field;
	JButton setDistanceButton;
	
	
	public ActuatorGUI()
	{
		super();
		
		referenceSpeedField = new JTextField("refs");
		distance_t_1_Field = new JTextField("t-1");
		distance_t_Field = new JTextField("t");
		setSpeedButton = new JButton("Set speed!");
		setDistanceButton = new JButton("Set distance!");
		
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
		
		setDistanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try 
				{
					Literal goal = ASSyntax.createLiteral("distanceChanged", ASSyntax.createNumber(Double.parseDouble(distance_t_1_Field.getText())), ASSyntax.createNumber(Double.parseDouble(distance_t_Field.getText())) );
					getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
            }
        });
		
		grid = new GridLayout(3, 2);
		frame = new JFrame("Tempomat");
		frame.getContentPane().setLayout(grid);
		frame.add(distance_t_1_Field);
		frame.add(referenceSpeedField);
		frame.add(distance_t_Field);
		frame.add(setSpeedButton);
		frame.add(setDistanceButton);
		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
}
