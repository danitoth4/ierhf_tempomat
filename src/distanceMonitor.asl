// Agent distanceMonitor in project ier_hf_project.mas2j

/* Initial beliefs and rules */
distance(0).
prev_distance(0).
actual_speed(0).
max_speed(0).

/* Initial goals */

/* Plans */
+!distance_changed(D1,D2) : true <- -+prev_distance(D1); -+distance(D2); .print("Distances changed to ", D1, ", ", D2); !calculate.
+!actual_speed_changed(S) : true <- -+actual_speed(S); .print("Actual speed changed to ", S); !calculate.
+!calculate : true <- ?distance(D); ?actual_speed(S); internal.calculateDesiredSpeed(D, S, X); -+max_speed(X).
+?speed_change(X) : actual_speed(A) & max_speed(M) & A > M <- X = slow_down.
+?speed_change(X) : actual_speed(A) & max_speed(M) & A < M <- X = accelerate.
