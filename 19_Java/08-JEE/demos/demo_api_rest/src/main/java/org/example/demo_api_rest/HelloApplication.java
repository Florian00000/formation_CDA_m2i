package org.example.demo_api_rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


// annotation @ApplicationPath est applique a une classe java qui extends Application
// Le chemin de @ApplcationPath indique l'url de base ou se trouve toutes les ressources JAX-RS
// http://localhost:8080/demo_api_rest_war_exploded/api/
@ApplicationPath("/api")
//@ApplicationPath("")  // http://localhost:8080/demo_api_rest_war_exploded api disponible a la racine de l'application
public class HelloApplication extends Application {

}