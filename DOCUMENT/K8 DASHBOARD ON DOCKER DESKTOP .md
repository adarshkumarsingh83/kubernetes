
# INSTALLING DOCKER DASH BOARD ON DOCKER DESKTOP K8
---- 

#### Installing the Kubernetes Dashboard
* $ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-rc3/aio/deploy/recommended.yaml
* or
* $ kubectl apply -f $(pwd)/recommended.yaml

* $ kubectl get pods --all-namespaces

### Kubectl Proxy
* $ kubectl proxy

### Open in Browser
- http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/login

### select the token option
### To Generate Token
* $ kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | awk '/^deployment-controller-token-/{print $1}') | awk '$1=="token:"{print $2}'



