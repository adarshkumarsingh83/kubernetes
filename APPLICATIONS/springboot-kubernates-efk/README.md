# springboot elsatic fluitentbit kibina 

----


![help](https://github.com/fluent/fluent-bit-kubernetes-logging)


### To create namespace 
*  kubectl apply -f namespace.yml 

### To get the namespaces 
* kubectl get namespaces

### To create configmap 
* $ kubectl apply -f configmap.yml 

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

### To create kibina 
* $ kubectl apply -f kibana.yml 

### To get all the items in namespace 
 * $ kubectl --namespace=logging get all 

### To port forward 
* kubectl --namespace=logging port-forward svc/kibana  5601:5601 


