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
		if(args[0].isNumeric() && args[1].isNumeric())
		{
			double t = ((NumberTermImpl)args[0]).solve() / ((NumberTermImpl)args[1]).solve();
			int i = (int)Math.floor(t);
			return un.unifies(args[3], i * 5);
		}
		return false;
    }
}

