// Agent actuator in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).
distance(0).
prev_distance(0).

/* Initial goals */
!control_vehicle.

/* Plans */
+!control_vehicle : true <-
	-speed_change(slow_down)[source(distanceMonitor)];
	-speed_change(accelerate)[source(distanceMonitor)];
	-speed_change(slow_down)[source(speedController)];
	-speed_change(accelerate)[source(speedController)];
	.send(distanceMonitor, askOne, speed_change(X), D);
	.send(speedController, askOne, speed_change(X), S);
	+D; +S; !decide;
	.at("now +1 s", {+!control_vehicle}).
	
+!speed_changed(S) : true <-
	-+ref_speed(S);
	.print("Ref speed changed to ", S);
	.send(speedController, achieve, ref_speed_changed(S)).
							 
+!distance_changed(D1,D2) : true <-
	-+prev_distance(D1);
	-+distance(D2);
	.print("Distances changed to ", D1, ", ", D2);
	.send(distanceMonitor, achieve, distance_changed(D1,D2)).
	
+!decide : speed_change(slow_down)[source(distanceMonitor)]  & speed_change(slow_down)[source(speedController)] <-
	.send(speedController, achieve, slow_down).

+!decide : speed_change(slow_down)[source(distanceMonitor)]  & speed_change(accelerate)[source(speedController)] <-
	.send(speedController, achieve, slow_down).

+!decide : speed_change(accelerate)[source(distanceMonitor)]  & speed_change(slow_down)[source(speedController)] <-
	.send(speedController, achieve, slow_down).
	
+!decide : speed_change(accelerate)[source(distanceMonitor)]  & speed_change(accelerate)[source(speedController)] <-
	.send(speedController, achieve, accelerate).
		
+!decide : true <-
	.send(speedController, achieve, maintain_speed).
