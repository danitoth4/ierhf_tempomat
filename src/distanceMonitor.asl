// Agent distanceMonitor in project ier_hf_project.mas2j



/* Initial beliefs and rules */



/* Initial goals */



!start.



/* Plans */



+!start : true <- .print("hello world.").

+!distanceChanged(DI) : true <- .print("Distance changed to ", DI).


