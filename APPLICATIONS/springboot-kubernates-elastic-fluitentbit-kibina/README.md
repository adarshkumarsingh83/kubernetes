# springboot elsatic fluitentbit kibina 

----


### To start the minikube 
* minikube start --vm-driver=hyperkit

### To Enable dashboard 
* minikube addons enable dashboard

### To open dashboard 
* minikube dashboard

### To create namespace 
*  kubectl apply -f namespace.yml 

### To get the namespaces 
* kubectl get namespaces

### To create configmap 
* $ kubectl apply -f configmap.yml 
* $ kubectl apply -f fluentbit-configmap.yml 


### To create role 
* $ kubectl apply -f role.yml 

### To create service account 
* $ kubectl apply -f service-account.yml 

### for binding service and role 
* $ kubectl apply -f service-role-binding.yml 

### To create Fuentbit 
* $ kubectl apply -f fluentbit-demon-set.yml 

### To create eslasic search 
* $ kubectl apply -f elasticsearch.yml 

### To Check elasic is getting index data or not 
* kubectl --namespace=logging port-forward svc/elasticsearch 9200:9200
* `http://localhost:9200/`
* `http://localhost:9200/_cat/indices`

### To create kibina 
* $ kubectl apply -f kibana.yml 

### To get all the items in namespace 
 * $ kubectl --namespace=logging get all 

### To port forward 
* kubectl --namespace=logging port-forward svc/kibana  5601:5601 
* `http://localhost:5601`

### for spring boot application 
* kubectl apply -f springboot-deployment.yml 

### To describe service 
*  kubectl describe svc springboot-web-rest

### To forward for accessing out of k8 
* kubectl  port-forward svc/springboot-web-rest  8080:8080 
* `http://localhost:8080/api/message`


### To check all the pods 
* kubectl get pods -A 

### To list all the items in the k8
* kubectl get pods -A 

### for load testing 
* minikube addons enable ingress
* kubectl get pods -n ingress-nginx
* kubectl apply -f ingress.yml 
*  kubectl get ingress
```
NAME                 CLASS   HOSTS                  ADDRESS         PORTS   AGE
springboot-ingress   nginx   espark.com,localhost   192.168.64.24   80      13m
```
* sudo vi /etc/hosts
```
192.168.64.24 espark.com
```

### Make 100 parallel with 10 jobs call to the service for load testing
* seq 1 500 | xargs -n1 -P10  curl -H "Connection: close" "http://espark.com/api/message"

### Clean up 
* kubectl delete -n default ingress springboot-ingress
* kubectl delete -n default deployment springboot-web-rest
* kubectl delete -n default service springboot-web-rest
* kubectl delete -n logging deployment kibana
* kubectl delete -n logging service kibana
* kubectl delete -n logging statefulset elasticsearch
* kubectl delete -n logging service elasticsearch
* kubectl delete -n logging daemonset fluent-bit
* kubectl delete -n logging configmap fluent-bit-config
* kubectl delete -n logging configmap app-config
* kubectl delete -n logging serviceaccount fluent-bit
* kubectl delete namespace logging

