This started with https://github.com/payne/mhack1 which is a combination of:

1. https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-jetty-ssl
1. https://spring.io/guides/gs/rest-service/
1. https://thoughtfulsoftware.wordpress.com/2015/01/25/setting-up-https-for-spring-boot-2/

Do this:

~~~~~~~~~~~~~~~~~~
gradle build
java -jar build/libs/gs-rest-service-0.1.0.jar
~~~~~~~~~~~~~~~~~~

Then visit this URL

https://localhost:8443/greeting

Here you can also visit https://localhost:8443/

I'm trying to build a simple SQL injection toy.   Where the web app that serves at https://localhost:8443/ has some SQL 
injection vulnerabilities.

I'd also like to build a simple XSS toy too.

For now I'm going to put this down.   At least until Craig emails me... 

