// Agent distanceMonitor in project ier_hf_project.mas2j

/* Initial beliefs and rules */
distance(0).
prev_distance(0).
actual_speed(0).

/* Initial goals */

/* Plans */
+!distance_changed(D1,D2) : true <- -+prev_distance(D1); -+prev_distance(D2); .print("Distances changed to ", D1, ", ", D2).
+!actual_speed_changed(S) : true <- -+actual_speed(S); .print("Actual speed changed to ", S).
