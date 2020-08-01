

# ** SPRING BOOT KUBERNATES EXAMPLES **

* ## [DOCUMENTS](https://github.com/adarshkumarsingh83/kubernetes/tree/master/DOCUMENT)
> descripition: \
> . Contains some step by step helping document for \
> . configurations and other things 

----

* # K8 INFA SERVICES 

----

* ## [springboot-kubernates-secret](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-secret)
> descripition: \
> spring boot appliation uses k8 secret valult services \
> and return those in the restful services 


* ## [springboot-kubernates-configmap](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-configmap)
> descripition: \
> spring boot application which uses k8 configmap  \
> which is kind of confi server for the application \
> for various application configurations \
> whis is used futher for data exposing 	

----

* # MICRO SERVICES IMPLEMENATIONS  

----

* ## [springboot-kubernetes-cloud-ms](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-cloud-ms)
> descripition: \
> we have zuul and api gateway as the proxy server k8  registry as the registry server  \
> we have api-service which is aggregator service which internal request to the  \
> employee-service & address-service fetch the data and aggregate in it.  \
> we have k8 config map service which holds the configuration of the eco system \
> this project can we executed on k8 cluster  \
> this application has zuul as well as api-gateway use any one at a time 	

* ## [springboot-netflix-cloud-ms](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-netflix-cloud-ms)
> descripition: \
> this project is implemented with spring netflix cloud api where  \
> we have zuul and api gateway as the proxy server eureka as the registry server \
> we have api-service which is aggregator service which internal request to the  \
> employee-service & address-service fetch the data and aggregate in it. \
> we have external config-service which holds the configuration of the eco system \
> this project can we executed on local machine in default profile and in docker compose  \
> finally this is deployed on k8 cluster \
> this application has zuul as well as api-gateway use any one at a time   


* ## [springboot-web-rest](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-web-rest)
> Description: \
> springboot application which has web pages \
> and rest endpoints for the consumer application. 

* ## [springboot-kubernetes-logs](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-logs)
> descripition: \
> spring boot actuator service based logback \
> based log file generation in k8 pod  \
> and accessing it for ELK

		
----

* # QUEUE IMPLEMENTATION   

----		
		
* ## [springboot-kubernates-kafka](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-kafka)
> descripition: \
>  not working yet to test
> .
> .	

* ## [springboot-kubernates-rabbitmq](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-rabbitmq)
> Description: \
> spring boot rabbitmq application where \
> producer application put data on rabbitmq \
> consumer will read the data from the rabbitmq 	


----

* # DATABASES 

----

* ## [springboot-kubernates-secret-postgres](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-secret-postgres)
> Description: \
> spring boot application uses postgres db \
> jpa is used for curd operation \
> k8 config map and secret is use for storing \
> credentials and configurations.

* ## [springboot-kubernates-secret-mysql](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-secret-mysql)
> Description: \
> spring boot application uses mysql db \
> jpa is used for curd operation \
> k8 config map and secret is use for storing \
> credentials and configurations.

* ## [springboot-kubernates-mongo](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-mongo)
> Description: \
> spring boot jpa mongo db application \
> where curd operation implemented \
> data is persisted into the mongo db

* ## [springboot-kubernetes-neo4j](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-neo4j)
> descripition:  \
> spring boot based neo4j graph db \
> spring boot based rest services application  \
> data will be seeded into the db at the applicaion startup 

----

* # CACHE

----

* ## [springboot-kubernetes-redis-cache](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-redis-cache)
> descripition:  \
> spring boot based redis cache application  \
> having redis cache for data store where curd operations are  \
> performed on the user information using rest endpoints 


* ## [springboot-kubernates-hazelcast](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-hazelcast)			
> descripition: \
> spring boot hazelcast where k8 will help for embedded \
> hazelcast cache for the spring boot application \
> which is futher used by the spring boot hazelcast clint 

* ## [springboot-kubernates-hazelcast-external](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-hazelcast-external)	
> descripition: \
> spring boot hazel cast cache which is runing as the sperate server\
> and spring boot hazel cast cache will perform the curd operation on \
> the data which is cached on the hazel cast external server. 

----

* # SEARCH ENGINES 

----

* ## [springboot-kubernates-elasticsearch](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-elasticsearch)
> Description: \
> spring boot application which uses elastic search \
> internally data will be indexed on the elastic search \
> and then based on index fast searching done. 


* ## [springboot-kubernetes-elasticsearch-kibana](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-elasticsearch-kibana)
> descripition:  \
> spring boot based elastic search application  \
> having elastic search as the serach engine  \
> data is indexed on elastic and kibina is used to do query on the top of elastic searcch

* ## [springboot-kubernates-solr](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-solr)
> descripition: \
> spring boot application implemented with curd operation \
> data is stores on solr search engine \
> where data is indexed for fast searching 

* ## [springboot-kubernates-solr_nw](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-solr_nw)
> descripition: \
> . not working yet to be fixed 
> .
> .	

----

* # PROXY & LOAD BALANCER 

----

* ## [springboot-kubernates-ngnix](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-ngnix)
> descripition: \
> spring boot ngnix k8 docker compose application \
> spring boot rest services and web pages are exposed \
> ngnix load balancing and proxy is enable for multiinstances of the spring boot server appliation

* ## [springboot-kubernetes-nginx-lb](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-nginx-lb)
> descripition:  \
> spring boot based nginx loadbalancer & proxy server application  \
> springbboot services are rest services exposed data having multi instances  \
> nginx having reverse proxy and load balancing mechanisms 

* ## [springboot-kubernetes-ingress-lb](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-ingress-lb) 
> descripition:  \
> spring boot based address and employee rest services \
> having multiple pods and loadbalanced by ingress \
> and custom host is configure for set up 

* ## [springboot-kubernates-haproxy](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernates-haproxy)
> descripition:  \
> spring boot based haproxy based proxy \
> spring boot based rest services application  \
> ha proxy based load balancing and proxy service 

