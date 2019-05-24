// Agent speedController in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).
actual_speed(10).

/* Initial goals */

/* Plans */
+!ref_speed_changed(S) : true <- -+ref_speed(S); .print("Ref speed changed to ", S); !send_message.
+!actual_speed_changed(S) : true <- -+actual_speed(S); .print("Actual speed changed to ", S); .send(distanceMonitor, achieve, actual_speed_changed(S)); speed_t(S); !send_message.
+!send_message : actual_speed(A) & ref_speed(R) & A > R <- .send(actuator, tell, slow_down).
+!send_message : actual_speed(A) & ref_speed(R) & A < R <- .send(actuator, tell, accelerate).
+!accelerate : true <- ?actual_speed(S); new_speed = S + 5; !actual_speed_changed(new_speed).
+!slow_down : true <- ?actual_speed(S); new_speed = S - 5; !actual_speed_changed(new_speed).
+?speed_change(X) : actual_speed(A) & ref_speed(R) & A > R <- X = slow_down.
+?speed_change(X) : actual_speed(A) & ref_speed(R) & A < R <- X = accelerate.
