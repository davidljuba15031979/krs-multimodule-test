# Draft

### Reference Documentation
For further reference, please consider the following sections:

* [Clean architecture (Moduliths)](https://speakerdeck.com/thombergs/o-2019?slide=35)

### Start application

Start application: 

#####Start MongoDB

``` docker-compose -f krs-docker/docker-compose.yml up -d mongo mongo-express```

#####Start Spring

```gradle --info run -x test```

##### Request -> response
```
curl -X POST http://localhost:8080/course | jq

{
  "courseId": "4ba18471-f4ca-4ac4-b502-f93280d9b5ef",
  "name": "Kotlin learn with Spring"
}
```


### Install

* Docker
* Intellij plugin for [Kotlintest](https://github.com/kotlintest/kotlintest)

### Cleanup

##### Stop MongoDB

```docker-compose -f krs-docker/docker-compose.yml down --remove-orphans```
