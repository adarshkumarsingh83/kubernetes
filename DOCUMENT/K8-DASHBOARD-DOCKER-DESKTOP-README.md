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
```
$ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.5.0/aio/deploy/recommended.yaml
namespace/kubernetes-dashboard created
serviceaccount/kubernetes-dashboard created
service/kubernetes-dashboard created
secret/kubernetes-dashboard-certs created
secret/kubernetes-dashboard-csrf created
secret/kubernetes-dashboard-key-holder created
configmap/kubernetes-dashboard-settings created
role.rbac.authorization.k8s.io/kubernetes-dashboard created
clusterrole.rbac.authorization.k8s.io/kubernetes-dashboard created
rolebinding.rbac.authorization.k8s.io/kubernetes-dashboard created
clusterrolebinding.rbac.authorization.k8s.io/kubernetes-dashboard created
deployment.apps/kubernetes-dashboard created
service/dashboard-metrics-scraper created
deployment.apps/dashboard-metrics-scraper created
```

## to get Acess 
* kubectl proxy
```
$ kubectl proxy
Starting to serve on 127.0.0.1:8001
```

## to access dashboard 
* http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
* it will prompt for the tocken after dashboard is install and boot up 

## Create a authentication 
* [use this githb url for help](https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md)
----

### Creating a Service Account
* create file "dashboard-adminuser.yaml"

```
apiVersion: v1
kind: ServiceAccount
metadata:
  name: admin-user
  namespace: kubernetes-dashboard
```
* kubectl apply -f dashboard-adminuser.yaml
```
$ kubectl apply -f dashboard-adminuser.yaml
serviceaccount/admin-user created
```


### Creating a ClusterRoleBinding
* create a file "cluster-admin.yaml"

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
* kubectl apply -f cluster-admin.yaml
```
$ kubectl apply -f cluster-admin.yaml
clusterrolebinding.rbac.authorization.k8s.io/admin-user created
```

### Getting a Bearer Token
* kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"
*  copy the token and paste it into the Enter token field on the login screen.
```
$ kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"

eyJhbGciOiJSUzI1NiIsImtpZCI6ImlEVEVqdTVUdWY5SjV5cWgwSW10YUthYkt1ZjB5VkdHQkcwWUl6RWtuNUkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlcm5ldGVzLWRhc2hib2FyZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLWJjZmNtIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiIxZWMzYzY5Mi1iM2RlLTQ5MTAtOGUzZi0wOTc4MmQxM2E0MWUiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZXJuZXRlcy1kYXNoYm9hcmQ6YWRtaW4tdXNlciJ9.XPaOOTXbTEMHiXI9F48orhZnQcg6nJzizQO7354ChEJ5-hZLxUjboHOCHnme2S070EdHdKnMDir4G2VriBD8EvR-F_ohjdYFQ6-vD6l31MmJlfE5zy53CYXkUgKv8c26kp8w7hlKsGVgGbs0WXk-ZDxya0YZLZVhiiZjLaz10VwD1YLPEBHvKDD3cd9rejwwiV0WwJ0J2GA_G-wkm5GI1Jdx6m1vDNCZCsHY8J2FSElLxvkugX5PX5B-_gHROPeOB_K_0ro95gsO_OMqT4U0yg5CQmwv41U7fQxreYk74mS7LU7hM4uvB1I1x6k-JyZL419mUQ8DgTTi0vcK5kXOUg
```

### Clean up and next steps
* kubectl -n kubernetes-dashboard delete serviceaccount admin-user
* kubectl -n kubernetes-dashboard delete clusterrolebinding admin-user


----

## docker logout 
* $ docker logout 
```
Removing login credentials for https://index.docker.io/v1/
```