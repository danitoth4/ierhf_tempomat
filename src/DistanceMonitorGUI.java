import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;


public class DistanceMonitorGUI extends AgArch
{
	JFrame frame;
	GridLayout grid;
	JTextField distanceField;
	JButton setDistanceButton;
	
	public DistanceMonitorGUI()
	{
		super();
		
		distanceField = new JTextField();
		setDistanceButton = new JButton("Set Distance!");
		setDistanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try 
				{
					Literal goal = ASSyntax.createLiteral("distanceChanged", ASSyntax.createNumber(Double.parseDouble(distanceField.getText())));
					getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
            }
        });
		grid = new GridLayout(2, 1);
		frame = new JFrame("Distance Monitor");
		frame.getContentPane().setLayout(grid);
		frame.add(distanceField);
		frame.add(setDistanceButton);
		frame.setSize(300, 100);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
