# hibernate-demo

## Prop&oacute;sito

Este proyecto tiene como objetivo demostrar c&oacute;mo realizar consultas a una Base de datos utilizando JPA y Hibernate.

- [Pre-requisitos](#pre-requisitos)
    * [Postgres](#postgres)
- [Ejecuci&oacute;n](#ejecución)
- [Contacto](#contacto)

## Pre-requisitos

### Postgres

Por cuestiones pr&aacute;cticas, utilizaremos una imagen de Docker.

En `resources/sql/init.sql` se encuentra un script SQL con la definici&oacute;n del esquema a utilizar y algunos datos de prueba.

Abrir una terminal en la ra&iacute;z del proyecto y ejecutar:

```bash
sudo docker run --name movies-db \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=postgres \
	-e POSTGRES_DB=movies \
	-v $PWD/src/main/resources/sql:/docker-entrypoint-initdb.d/:ro \
	-p 5432:5432 \
	--rm -d postgres:12.7-alpine
```

Verificar en los logs del container que este se haya creado correctamente.

Ejecutar `sudo docker logs -f movies-db`. Se deber&aacute; encontrar una linea similar a:

```bash
...
2021-06-20T21:05:48.247618Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.25'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.
```

## Ejecuci&oacute;n

Ubicados en la ra&iacute;z del proyecto, ejecutar en la terminal:

```bash
./gradlew run
```

## Contacto

- **Ariel Gámez** (ariel.gamez@redb.ee)
- **Lautaro Aguilera** (lautaro.aguilera@redb.ee)
- **Mariano Ludueña** (mariano.luduena@redb.ee)
- **Santiago Leiva** (santiago.leiva@redb.ee)
