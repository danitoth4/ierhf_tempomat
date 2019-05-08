import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;


public class DistanceMonitorGUI extends AgArch
{
	GridLayout grid;
	JTextField distanceField;
	JFrame frame;
	JButton setDistanceButton;
	
	public DistanceMonitorGUI()
	{
		super();
		
		setDistanceButton = new JButton("Set Distance!");
		setDistanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try 
				{
					Literal goal = ASSyntax.createLiteral("distanceChanged", ASSyntax.createNumber(20));
					getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
            }
        });
		
		distanceField = new JTextField();
		grid = new GridLayout(2, 1);
		frame = new JFrame("Distance Monitor");
		frame.getContentPane().setLayout(grid);
		frame.add(distanceField);
		frame.add(setDistanceButton);
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
