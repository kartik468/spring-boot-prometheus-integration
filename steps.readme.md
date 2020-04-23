# Steps

## Downloads

- prometheus binary from
    <https://prometheus.io/download/>

- grafana binary from
    <https://grafana.com/grafana/download?platform=windows>

## Prometheus

- Extract the zip files and execute the prometheus executable
- It will start prometheus on port 9090  (you can visit it by going <http://localhost:9090/)>
- You can configure the targets by editing prometheus.yml file
- By default prometheus adds itself as target, so we can see all the metrics exposed by prometheus.
- You can view all the targets in UI also. (Stats => Targets)
  - here you can see list of the targets
  - by clicking on these you will be navigated to the page where all the metrics exposed by that endpoint are visible

> Note: endpoint must have an api that gives all the metrics in a format that prometheus can parse. (which is text file with key value pairs)

## Grafana

- Extract the zip files and execute the grafana-server executable which is present in bin directory
- It will start grafana server on port 3000
- Default username and password are admin and admin
- First add prometheus datasource to grafana and test the connection
- Once successful go to dashboard page and here you can query all the metrics that prometheus exposes
- You can import external dashboard provided by other users.
  <https://grafana.com/grafana/dashboards>

## Spring Boot application

- Added starter files using spring boot initializer.
- Add maven below dependencies in pom xml
  
```xml
<!-- https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-enabling -->
<!-- actuator exposes various properties which are used monitor and manage your application -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<!-- prometheus dependency -->
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

- Add below properties in application.properties file

```properties
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
```

- With this our spring boot application has below endpoint which exposes various metrics
<http://localhost:8080/actuator/prometheus>

- Add this target in prometheus.yml file
- Now we can use these metrics in prometheus
  