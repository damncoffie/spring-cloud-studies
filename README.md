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
    - can use DiscoveryClient instance or RestTemplate instance hooked with Ribbon


Ribbon:
- client side load balancer
- auto integrates with service-discovery (Eureka)
- built in failure resiliency (Hystrix)
</pre>
