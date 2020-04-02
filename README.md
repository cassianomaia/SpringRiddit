# Riddit
![Build Status](https://github.com/cassianomaia/SpringRiddit/workflows/Build%20Status/badge.svg?branch=develop)

A reddit like API to study spring boot.

---------------
### Running on Docker
To run on docker you should execute this commands:

```sh
$ docker build --tag riddit:1.0 .
$ docker run --publish 8000:8080 --detach --name bb riddit:1.0
```
And then, test the api on:
```sh
http://localhost:8000/user
http://localhost:8000/text
http://localhost:8000/comment
```