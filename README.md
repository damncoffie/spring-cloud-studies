<pre>
Spring Cloud studies and demo

Project consists of a few modules:

1. Configuration Server (config-server-app)
    - points to git repo with application.yml, which contains uri to eureka server
2. Eureka server (eureka-server-app)
    - you can check a dashboard UI in browser http://localhost:8010/
3. Three eureka clients apps (eureka-client-app- 1-2-3)
    - they fetch data from config server to retrieve eureka server uri, then register themselves on it
    - each has an GET endpoint which returns a random word
4. Sentence app (eureka-client-sentence-app)
    - makes call to three clients mentioned above to comprise a sentence
    - has 3 controllers:
        - use DiscoveryClient instance to find a service's URI by client-id and make a call to that URI
            with RestTemplate
        - use @LoadBalanced-annotated RestTemplate, which is automatically hooked into Ribbon, make a 
            call to "http://" + serviceIdInEureka
        - use feign clients (@FeignClient("SERVICE-ID-IN-EUREKA")) to call word clients.
            calls backed by @HystrixCommand(fallbackMethod = "getFallbackVerb")

Spring bus update feature in config-server-app and config-client-app:
    - Client get properties the same way as eureka-clients, but can use spring-bus config update.
    - The goal is to update config property without restarting a client app.
    - Server and client both has an actuator and spring-bus dependencies. This dependency is smart enough to be aware on 
        which side it's being run (client or server).
    - Client has two controllers:
        - with @RefreshScope and @Value for props
	    - with @ConfigurationProperties with prefix
    - Spring bus uses RabbitMQ (you need to start it beforehand).
    - Server exposes bus-refresh actuator endpoint by property:
        management.endpoints.web.exposure.include: health,info,bus-refresh
    - When property is changed (e.g. on a remote github repo) you can call a config server's actuator endpoint:
        http://localhost:8081/actuator/bus-refresh
    - Change will be propagated to a client.

About technologies:

Eureka:
- client discovery service

Ribbon:
- client side load balancer
- auto integrates with service-discovery (Eureka)
- built in failure resiliency (Hystrix)

Feign:
- declarative rest client
- allows you to write calls to rest services with no implementation code
- alternative to rest template
- integration with Eureka (can use client-id as a url)

Hystrix:
- isolates the points of access between the services, stops cascading failures across them and provides the 
    fallback options.
- open http://localhost:8020/hystrix. When prompted, 
    enter http://localhost:8020/actuator/hystrix.stream as the host to monitor.
</pre>
