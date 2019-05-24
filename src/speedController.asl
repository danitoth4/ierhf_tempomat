// Agent speedController in project ier_hf_project.mas2j

/* Initial beliefs and rules */
ref_speed(0).

/* Initial goals */

/* Plans */
+!speedChanged(S) : true <- -+ref_speed(S); .print('Ref speed changed to ', S).
