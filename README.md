# api-rest-demo

This demo project shows how to easily build an api rest with springboot.

Springboot is full of <span style="color:#8A2BE2;font-weight:bold;">annotations</span> and 
<span style="color:#008000;font-weight:bold;">properties</span>, and you will find the code fully commented about how to use the following:

<img src="https://img.shields.io/badge/@Configuration-8A2BE2"/><img src="https://img.shields.io/badge/@Bean-8A2BE2"/> 
<img src="https://img.shields.io/badge/@ControllerAdvice-8A2BE2"/> 
<img src="https://img.shields.io/badge/@ExceptionHandler-8A2BE2"/> 
<img src="https://img.shields.io/badge/@RestController-8A2BE2"/>
<img src="https://img.shields.io/badge/@RequestMapping-8A2BE2"/>
<img src="https://img.shields.io/badge/@Value-8A2BE2"/> <br/>
<img src="https://img.shields.io/badge/@Autowired-8A2BE2"/>
<img src="https://img.shields.io/badge/@Qualifier-8A2BE2"/>
<img src="https://img.shields.io/badge/@GetMapping-8A2BE2"/>
<img src="https://img.shields.io/badge/@PathVariable-8A2BE2"/>
<img src="https://img.shields.io/badge/@Lazy-8A2BE2"/>
<img src="https://img.shields.io/badge/@Service-8A2BE2"/>
<img src="https://img.shields.io/badge/@PostConstruct-8A2BE2"/>
<img src="https://img.shields.io/badge/@PreDestroy-8A2BE2"/><br/>
<img src="https://img.shields.io/badge/@Primary-8A2BE2"/>
<img src="https://img.shields.io/badge/@Scope-8A2BE2"/>
<img src="https://img.shields.io/badge/@SpringBootApplication-8A2BE2"/>
<br/>
<img src="https://img.shields.io/badge/management.endpoints.web.exposure.include-008000"/>
<img src="https://img.shields.io/badge/management.info.env.enabled-008000"/>
<img src="https://img.shields.io/badge/management.endpoints.web.exposure.exclude-008000"/><br/>
<img src="https://img.shields.io/badge/spring.security.user.name-008000"/>
<img src="https://img.shields.io/badge/spring.security.user.password-008000"/>
<img src="https://img.shields.io/badge/server.port-008000"/>
<img src="https://img.shields.io/badge/server.servlet.context--path-008000"/>
<img src="https://img.shields.io/badge/server.servlet.session.timeout-008000"/><br/>
<img src="https://img.shields.io/badge/logging.level-008000"/>
<img src="https://img.shields.io/badge/logging.file.name-008000"/>
<img src="https://img.shields.io/badge/spring.main.lazy--initialization-008000"/>
<img src="https://img.shields.io/badge/spring.application.name-008000"/>
<img src="https://img.shields.io/badge/spring.main.banner--mode-008000"/><br/>
<img src="https://img.shields.io/badge/logging.level-008000"/>
<img src="https://img.shields.io/badge/spring.banner.location-008000"/>
<img src="https://img.shields.io/badge/springdoc.swagger--ui.enabled-008000"/>
<img src="https://img.shields.io/badge/spring.banner.location-008000"/>
<img src="https://img.shields.io/badge/springdoc.api--docs.enabled-008000"/>


## Description

## Installation

## Usage

1. Have the application installed on your machine
2. Run the <i>mvn spring-boot:run</i> command
3. Validate the console shows a message indicating the application is started:
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

* Mauro Saita. (Unknown). *Algoritmo di Erone.* 
  Retrieved from http://maurosaita.it/05quinta/matematica/appunti/algoritmo_di_Erone.pdf
* Spring documentation. (Unknown). *Testing the Web Layer.* 
  Retrieved from https://spring.io/guides/gs/testing-web
* Akbar Karimi. (Unknown). *Fastest Algorithm to Find Prime Numbers.* 
  Retrieved from https://www.baeldung.com/cs/prime-number-algorithms
* Spring documentation. (Unknown). *Controller Advice.* 
  Retrieved from https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-advice.html
* Spring documentation. (Unknown). *Exceptions.* 
  Retrieved from https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-exceptions.html
* Abhinav Pandey. (11-05-2024). *Setting Example and Description with Swagger.* 
  Retrieved from https://www.baeldung.com/swagger-set-example-description