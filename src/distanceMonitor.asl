// Agent distanceMonitor in project ier_hf_project.mas2j



/* Initial beliefs and rules */
distance(0).


/* Initial goals */



!start.



/* Plans */



+!start : true <- .print("hello world.").

+!distanceChanged(DI) : true <- -+distance(DI); .print("Distance changed to ", DI).


