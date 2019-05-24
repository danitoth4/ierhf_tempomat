// Agent distanceMonitor in project ier_hf_project.mas2j

/* Initial beliefs and rules */
distance(0).
prev_distance(0).

/* Initial goals */

/* Plans */
+!distanceChanged(D1,D2) : true <- -+prev_distance(D1); -+prev_distance(D2); .print("Distances changed to ", D1, ", ", D2).
