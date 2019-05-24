// Agent speedController in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).
actual_speed(0).

/* Initial goals */

/* Plans */
+!ref_speed_changed(S) : true <-
	-+ref_speed(S);
	.print("Ref speed changed to ", S).

+!actual_speed_changed(S) : true <-
	-+actual_speed(S);
	.print("Actual speed changed to ", S);
	.send(distanceMonitor, achieve, actual_speed_changed(S));
	speed_t(S).

+!accelerate : true <-
	?actual_speed(S);
	NewSpeed = S + 1;
	!actual_speed_changed(NewSpeed).

+!slow_down : actual_speed(S) & S > 0 <-
	?actual_speed(S);
	NewSpeed = S - 3;
	!actual_speed_changed(NewSpeed).
	
+!slow_down : actual_speed(S) & S == 0 <-
	!maintain_speed.

+!maintain_speed : true <-
	?actual_speed(S);
	!actual_speed_changed(S).

+?speed_change(X) : actual_speed(A) & ref_speed(R) & A > R <-
	X = slow_down.

+?speed_change(X) : actual_speed(A) & ref_speed(R) & A < R <-
	X = accelerate.
