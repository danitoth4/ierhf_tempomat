// Environment code for project ier_hf_project.mas2j



import jason.asSyntax.*;

import jason.environment.*;

import java.util.logging.*;



public class TempomatEnv extends Environment {



    private Logger logger = Logger.getLogger("ier_hf_project.mas2j."+TempomatEnv.class.getName());
	
	private double dist_t_1;
	private double dist_t;
	private double speed_t_1 = 0;
	private double speed_t = 0;



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
		
		try
		{
			logger.info(" [" + agName + "] doing: " + action);
	
			logger.info(action.getFunctor());
			
			for(Term t: action.getTerms())
			{
				logger.info(t.toString());
			}
			
			switch(action.getFunctor())
			{
				case "speed_t":
					if(action.getTerm(0).isNumeric())
					{
						this.speed_t = ((NumberTerm)action.getTerm(0)).solve();		
					}
					break;
				case "distance":
					if(action.getTerm(0).isNumeric())
					{
						this.dist_t_1 = ((NumberTermImpl)action.getTerm(0)).solve();		
					}		
					if(action.getTerm(1).isNumeric())
					{
						this.dist_t = ((NumberTermImpl)action.getTerm(1)).solve();		
					}
					break;
				default:
					break;
			}
		}
		catch(Exception e)
		{
			return false;
		}

        return true; // the action was executed with success

    }



    /** Called before the end of MAS execution */

    @Override

    public void stop() {

        super.stop();

    }

}


