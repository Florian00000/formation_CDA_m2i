# Annexes exercices quarkus avec Keycloak poour l'authentification et Kong pour l'Api gateway


Commande pour lancer le conteneur keycloack et lui assigner des vraibles d'environnements pour un compte utilisateur
```bash
docker run --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -p 8180:8080 quay.io/keycloak/keycloak:17.0.0 start-dev
```

Dépendendances utilisées par keycloack
```xml
 <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-oidc</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-oidc-token-propagation-reactive</artifactId>
 </dependency>
```

[exemple sur github de realm = configuration de sécurité avec utilisateurs pwd](https://github.com/vbhayden/keycloak-federation-examples/blob/master/keycloak/keycloak-config/realms/example-realm.json)

 


A rajouter dans le application.properties
```
quarkus.oidc.auth-server-url=http://localhost:8180/realms/master #realms par défaut (master)
quarkus.oidc.client-id=e-commerce #id du client (e-commerce)
quarkus.oidc.credentials.secret=secret #secret 
```
 
url pour générer un token   
`http://localhost:8180/realms/master/protocol/openid-connect/token`

param de la requete `body x-www-form-urlencoded`
```
client_id    e-commerce
grant_type   password
username     username
password     password
```
Renvoie un bearer token

pour les requetes rajouter le bearer token
```
Authorization   Bearer [token]
```

créer un docker compose pour Kong
```yml
version: '3'
services:
  kong-database:
    image: postgres:latest
    environment:
      POSTGRES_USER: kong
      POSTGRES_DB: kong
      POSTGRES_PASSWORD: kong
    networks:
      - kong-net
    healthcheck:
      test: [ "CMD", "pg_isready", "-U", "kong" ]
      interval: 10s
      timeout: 5s
      retries: 5
    restart: on-failure
    
    
  kong-migrations:
    image: kong:latest
    command: kong migrations bootstrap
    container_name: kong-migrations
    networks:
      - kong-net
    depends_on:
      kong-database:
        condition: service_healthy
    environment:
      KONG_DATABASE: postgres
      KONG_PG_HOST: kong-database
      KONG_PG_DATABASE: kong
      KONG_PG_USER: kong
      KONG_PG_PASSWORD: kong
    restart: on-failure


  kong:
    image: kong:latest
    restart: on-failure
    depends_on:
      kong-database:
        condition: service_healthy
    environment:
      KONG_DATABASE: postgres
      KONG_PG_HOST: kong-database
      KONG_PG_USER: kong
      KONG_PG_PASSWORD: kong
      KONG_PG_DATABASE: kong
      KONG_PROXY_ACCESS_LOG: /dev/stdout
      KONG_ADMIN_ACCESS_LOG: /dev/stdout
      KONG_PROXY_ERROR_LOG: /dev/stderr
      KONG_ADMIN_ERROR_LOG: /dev/stderr
      KONG_ADMIN_LISTEN: 0.0.0.0:8001
    ports:
      - "8000:8000"
      - "8443:8443"
      - "8001:8001"
      - "8444:8444"
    networks:
      - kong-net
networks:
  kong-net:
```

lancer avec la commande

```bash 
docker-compose -f docker-compose-kong.yml -up -d
``` 