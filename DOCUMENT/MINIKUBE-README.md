

# MINIKUBE 

---

## [HLEP DOC](https://minikube.sigs.k8s.io/docs/start/)


### install hyperhit and minikube
`brew update`

`brew install hyperkit`

`brew install minikube`

`kubectl`

`minikube`



### To Start minikube cluster 
* To Start in normal mode 
	* $ `minikube start --vm-driver=hyperkit`
* To Start in debug mode 
	* $ `minikube start --vm-driver=hyperkit --v=7 --alsologtostderr`

### To delete minikube virtualbox 
* $ minikube delete

### To View minikube version 
* $ minikube version

### To know he minikube status 
* $ minikube status



### To start minikube cluster
* $ minikube start

### To stop minikube cluster 
* $ minikube stop


### minikube memory set 
* $ minikube config set memory 10240

### to list config 
*  minikube config view

### To list addons in minikube 
* $ minikube addons list

### To enable addons in minikube
* $ minikube addons enable [dashboard]

### To open minikube dashbard 
* $ minikube dashboard

### To connect from outside of minikube 
* $ minikube ip

### forced minikube to use docker env 
* $ eval $(minikube docker-env)

### cache image from remote 
* $ minikube image load [IMAGE-NAME] --pull/--remote 






