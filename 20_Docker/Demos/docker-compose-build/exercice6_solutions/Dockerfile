# Image de départ
FROM nginx

MAINTAINER toto

LABEL org.opencontainers.image.authors="toto@toto"

WORKDIR /usr/share/nginx/html

COPY . . 

EXPOSE 80

CMD ["nginx","-g","daemon off;"]


# Construire l'image ( sans utilise le cache)
# docker build --no-cache -t exo6 .

# test de l'image
# docker run --name testexo6 -p 5555:80 -d exo6

