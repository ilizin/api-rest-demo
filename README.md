# api-rest-demo

This demo project shows how to easily build an api rest with springboot.

Springboot is full of properties and annotations, find the code fully commented about how to use a bunch of them.

**Annotations:** @Configuration, @ControllerAdvice, @ExceptionHandler, @RestController, @RequestMapping, @Value, @Autowired, @Qualifier, 
@GetMapping, @PathVariable, @Lazy. @Service, @PostConstruct, @PreDestroy, @Primary, @Scope, @SpringBootApplication, 
@SpringBootTest, @AutoConfigureMockMvc

**Properties:** management.endpoints.web.exposure.include, management.info.env.enabled, management.endpoints.web.exposure.exclude, 
spring.security.user.name, spring.security.user.password, server.port, server.servlet.context-path, server.servlet.session.timeout,
logging.level, logging.file.name, spring.main.lazy-initialization, spring.application.name, spring.main.banner-mode, logging.level, 
spring.banner.location, springdoc.swagger-ui.enabled, spring.banner.location, springdoc.api-docs.enabled

## Description

## Installation

1. Make sure have installed at lest the *jdk17*, this is necessary because the spring boot version is *3.4.1* 
```
ilizin@ilizin:~$ java -version
openjdk version "17.0.2" 2022-01-18
OpenJDK Runtime Environment (build 17.0.2+8-86)
OpenJDK 64-Bit Server VM (build 17.0.2+8-86, mixed mode, sharing)
ilizin@ilizin:~$ 
```
1. Clone de repository:
```
git clone git@github.com:ilizin/api-rest-demo.git
```
2. Run the <i>mvn clean install</i> command to run the tests and install the project:
```
ilio.zincone@OS-IZincone MINGW64 /c/ilio/repos/api-rest-demo (main)
$ mvn clean install
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< org.springframework.boot:api-rest-demo >---------------
[INFO] Building api-rest-demo 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] Tests run: 31, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.4.2:jar (default-jar) @ api-rest-demo ---
[INFO] Building jar: C:\ilio\repos\api-rest-demo\target\api-rest-demo-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot:3.4.1:repackage (repackage) @ api-rest-demo ---
[INFO] Replacing main artifact C:\ilio\repos\api-rest-demo\target\api-rest-demo-0.0.1-SNAPSHOT.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to C:\ilio\repos\api-rest-demo\target\api-rest-demo-0.0.1-SNAPSHOT.jar.original
[INFO]
[INFO] --- install:3.1.3:install (default-install) @ api-rest-demo ---
[INFO] Installing C:\ilio\repos\api-rest-demo\pom.xml to C:\Users\ilio.zincone\.m2\repository\org\springframework\boot\api-rest-demo\0.0.1-SNAPSHOT\api-rest-demo-0.0.1-SNAPSHOT.pom
[INFO] Installing C:\ilio\repos\api-rest-demo\target\api-rest-demo-0.0.1-SNAPSHOT.jar to C:\Users\ilio.zincone\.m2\repository\org\springframework\boot\api-rest-demo\0.0.1-SNAPSHOT\api-rest-demo-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  20.041 s
[INFO] Finished at: 2025-08-24T20:04:25+02:00
[INFO] ------------------------------------------------------------------------
```

## Usage

1. Have the project installed on your machine, see [Installation](##Installation)
2. Run the <i>mvn spring-boot:run</i> command to start it.
3. Validate the console shows a message indicating the project is up and running:
```
ilizin@ilizin:~/repos/api-rest-demo$ mvn spring-boot:run
[INFO] Scanning for projects...
....
2025-04-20T08:30:39.687+02:00  INFO 22208 --- [api-rest-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8081 (http) with context path '/api-rest-demo'
2025-04-20T08:30:39.703+02:00  INFO 22208 --- [api-rest-demo] [           main] m.i.s.s.a.ApiRestDemoApplication         : Started ApiRestDemoApplication in 3.639 seconds (process running for 4.322)
```
4. Access the swagger UI page from the link: http://localhost:8081/api-rest-demo/swagger-ui/index.html

## Structure

It's a maven based project, therefore the structure is standard, more details about the maven project director layout  [here](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

## Contributing

Contributions are welcome! If you have an alternative solution or an improvement to an existing solution, feel free to contribute. Follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature-new-solution).
3. Commit your changes (git commit -m 'Add new solution for problem X').
4. Push to the branch (git push origin feature-new-solution).
5. Open a pull request.

## Contact

GitHub: [ilizin](https://github.com/ilizin)

## References

* Mauro Saita. (Unknown). *Algoritmo di Erone.* <br/>
  Retrieved from http://maurosaita.it/05quinta/matematica/appunti/algoritmo_di_Erone.pdf
* Spring documentation. (Unknown). *Testing the Web Layer.* <br/>
  Retrieved from https://spring.io/guides/gs/testing-web
* Akbar Karimi. (Unknown). *Fastest Algorithm to Find Prime Numbers.* <br/>
  Retrieved from https://www.baeldung.com/cs/prime-number-algorithms
* Spring documentation. (Unknown). *Controller Advice.* <br/>
  Retrieved from https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-advice.html
* Spring documentation. (Unknown). *Exceptions.* <br/>
  Retrieved from https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-exceptions.html
* Abhinav Pandey. (11-05-2024). *Setting Example and Description with Swagger.* <br/>
  Retrieved from https://www.baeldung.com/swagger-set-example-description
* Sampada Wagde. (01-08-2024). *Spring REST Docs vs OpenAPI.* <br/>
  Retrieved from https://www.baeldung.com/spring-rest-docs-vs-openapi
  