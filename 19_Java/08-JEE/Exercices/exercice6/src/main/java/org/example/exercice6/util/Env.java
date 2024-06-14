package org.example.exercice6.util;

import io.github.cdimascio.dotenv.Dotenv;

//TODO Ne trouve pas le .env
public class Env {
    private static Dotenv dotenv;

    static {
        try {
            dotenv = Dotenv.configure()
                    .directory("src/main/resources")
                    .filename(".env")
                    .load();
            System.out.println("Dotenv loaded");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getEnv(String key) {
        System.out.println("variable environnement-> " + key + ": " + dotenv.get(key));
        return dotenv.get(key);
    }
}
