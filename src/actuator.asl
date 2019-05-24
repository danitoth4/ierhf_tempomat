// Agent actuator in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).
distance(0).
prev_distance(0).

/* Initial goals */
!avoid_collision.
!follow_ref_speed.

/* Plans */
+!speed_changed(S) : true <- -+ref_speed(S); .print("Ref speed changed to ", S); .send(speedController, achieve, ref_speed_changed(S)).
+!distance_changed(D1,D2) : true <- -+prev_distance(D1); -+distance(D2); .print("Distances changed to ", D1, ", ", D2); distance(D1,D2); .send(distanceMonitor, achieve, distance_changed(D1,D2)).
+!avoid_collision : slow_down[source(distanceMonitor)] <- .send(speedController, achieve, slow_down); -slow_down[source(distanceMonitor)]; !avoid_collision.
+!follow_ref_speed : accelerate[source(distanceMonitor)] & ~slow_down[source(speedController)] <- .send(speedController, achieve, accelerate).
+!follow_ref_speed : slow_down[source(speedController)] <- .send(speedController, achieve, accelerate).
