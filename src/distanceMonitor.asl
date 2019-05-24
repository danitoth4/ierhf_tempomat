// Agent distanceMonitor in project ier_hf_project.mas2j

/* Initial beliefs and rules */
distance(0).
prev_distance(0).
actual_speed(10).

/* Initial goals */

/* Plans */
+!distance_changed(D1,D2) : true <- -+prev_distance(D1); -+distance(D2); .print("Distances changed to ", D1, ", ", D2); !calculate.
+!actual_speed_changed(S) : true <- -+actual_speed(S); .print("Actual speed changed to ", S); !calculate.
+!calculate : true <- ?distance(D); ?actual_speed(S); internal.calculateDesiredSpeed(D, S, X); !send_message(X).
+!send_message(M) : actual_speed(A) & A > M <- .send(actuator, tell, slow_down).
+!send_message(M) : actual_speed(A) & A < M <- .send(actuator, tell, accelerate).
+!accelerate : true <- ?actual_speed(S); S = S + 5; -+actual_speed(S).
+!slow_down : true <- ?actual_speed(S); S = S - 5; -+actual_speed(S).
