// Agent speedController in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).
actual_speed(10).

/* Initial goals */

/* Plans */
+!ref_speed_changed(S) : true <- -+ref_speed(S); .print("Ref speed changed to ", S).
+!actual_speed_changed(S) : true <- -+actual_speed(S); .print("Actual speed changed to ", S); .send(distanceMonitor, achieve, actual_speed_changed(S)); speed_t(S); !send_message.
+!send_message : actual_speed(A) & ref_speed(R) & A > R <- .send(actuator, tell, slow_down).
+!send_message : actual_speed(A) & ref_speed(R) & A < R <- .send(actuator, tell, accelerate).
