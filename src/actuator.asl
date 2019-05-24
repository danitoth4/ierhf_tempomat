// Agent actuator in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).
distance(0).
prev_distance(0).

/* Initial goals */


/* Plans */
+!speed_changed(S) : true <- -+ref_speed(S); .print("Ref speed changed to ", S); .send(speedController, achieve, ref_speed_changed(S)).
+!distance_changed(D1,D2) : true <- -+prev_distance(D1); -+prev_distance(D2); .print("Distances changed to ", D1, ", ", D2); .send(distanceMonitor, achieve, distance_changed(D1,D2)).

