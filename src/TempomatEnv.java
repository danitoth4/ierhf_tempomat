// Environment code for project ier_hf_project.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;

public class TempomatEnv extends Environment {

    private Logger logger = Logger.getLogger("ier_hf_project.mas2j."+TempomatEnv.class.getName());

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		try
		{
			addPercept(ASSyntax.parseLiteral("percept(demo)"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action+", but not implemented!");
        if (true) { // you may improve this condition
             informAgsEnvironmentChanged();
        }
        return true; // the action was executed with success
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}
