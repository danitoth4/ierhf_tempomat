// Internal action code for project ier_hf_project.mas2j

package internal;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class calculateDesiredSpeed extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        // execute the internal action
        ts.getAg().getLogger().info("executing internal action 'internal.calculateDesiredSpeed'");
		
		double t = (double)args[0] / (double)args[1];
		int i = (int)Math.floor(t);
		return i * 5;
    }
}

