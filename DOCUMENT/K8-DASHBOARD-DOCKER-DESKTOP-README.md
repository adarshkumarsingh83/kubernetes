# Docker Dashboard 

----

## docker login 
* $ docker login 
```
Login with your Docker ID to push and pull images from Docker Hub. If you don't have a Docker ID, head over to https://hub.docker.com to create one.
Username: adarshkumarsingh83
Password: 
Login Succeeded

Logging in with your password grants your terminal complete access to your account. 
For better security, log in with a limited-privilege personal access token. Learn more at https://docs.docker.com/go/access-tokens/
```

### search for the "kubernates dashboard" in docker.hub after login 
```
kubernetesui/dashboard
By kubernetesui • Updated a month ago
General-purpose web UI for Kubernetes clusters 
```
* [docker dashboard github url](https://github.com/kubernetes/dashboard)


## To install 
* kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.5.0/aio/deploy/recommended.yaml

## to get Acess 
* kubectl proxy

## to access dashboard 
* http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
* it will prompt for the tocken after dashboard is install and boot up 

## Create a authentication 
* [use this githb url for help](https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md)
----

### Creating a Service Account
* create file "dashboard-adminuser.yaml"
* kubectl apply -f dashboard-adminuser.yaml
```
apiVersion: v1
kind: ServiceAccount
metadata:
  name: admin-user
  namespace: kubernetes-dashboard
```

### Creating a ClusterRoleBinding
* create a file "cluster-admin.yaml"
* kubectl apply -f cluster-admin.yaml
```
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRoleBinding
metadata:
  name: admin-user
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
- kind: ServiceAccount
  name: admin-user
  namespace: kubernetes-dashboard
```

### Getting a Bearer Token
* kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"
*  copy the token and paste it into the Enter token field on the login screen.

### Clean up and next steps
* kubectl -n kubernetes-dashboard delete serviceaccount admin-user
* kubectl -n kubernetes-dashboard delete clusterrolebinding admin-user


----

## docker logout 
* $ docker logout 
```
Removing login credentials for https://index.docker.io/v1/
```