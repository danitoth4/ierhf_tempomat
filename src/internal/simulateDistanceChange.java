// Internal action code for project ier_hf_project.mas2j

package internal;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class simulateDistanceChange extends DefaultInternalAction {

	
    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        // execute the internal action
        ts.getAg().getLogger().info("executing internal action 'internal.simulateDistanceChange'");
        
		double dist_t_1 = ((NumberTermImpl)args[0]).solve();
		double dist_t = ((NumberTermImpl)args[1]).solve();
		double speed_t_1 = ((NumberTermImpl)args[2]).solve();
		double speed_t = ((NumberTermImpl)args[3]).solve();
		
		double other = dist_t - dist_t_1 + speed_t_1;
		
		
        // everything ok, so returns true
        return true;
    }
}

