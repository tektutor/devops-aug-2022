# Day 5

## Installing Prometheus Metrics Plugin in Jenkins
- Navigate to Jenkins --> Manage Jenkins --> Manage Plugins --> Available --> Prometheus Metrics Plugin
- Install and Restart Jenkins

### Verifying successful installation of Jenkins Prometheus Metrics Plugin
Try to access the Jenkins metrics collected by Prometheus Plugin
```
http://localhost:8080/prometheus
```

## Starting the prometheus server as a Docker container
```
docker run -d --name prometheus --hostname prometheus bitnami/prometheus:latest
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022$ <b>docker run -d --name prometheus --hostname prometheus bitnami/prometheus:latest</b>
Unable to find image 'bitnami/prometheus:latest' locally
latest: Pulling from bitnami/prometheus
3b5e91f25ce6: Pull complete 
1d52ee8a19d6: Pull complete 
63c9289a770b: Pull complete 
145096040547: Pull complete 
9db70440c9a7: Pull complete 
74fc1e53b2f9: Pull complete 
03deb00dde12: Pull complete 
65293e7f2a7e: Pull complete 
ac9922209421: Pull complete 
a560fa3a2145: Pull complete 
Digest: sha256:7e0dd4a53bd394f867d85234c56c56fe9b72d78cb38db670cadc8e19d914a542
Status: Downloaded newer image for bitnami/prometheus:latest
b6053865d7458ba93cc9e1f8e14f9d57c8aedd8ee57e169d6db21e596c883ef2
</pre>

### Configuring prometheus to collect metrics from the jenkins REST endpoint
We need to create a prometheus configuration file name prometheus.yml with the below content
<pre>
global:
  scrape_interval: 15s
  evaluation_interval: 15s

alerting:
  alertmanagers:
    - static_configs:
        - targets:

rule_files:

scrape_configs:
  - job_name: "prometheus"
    static_configs:
      - targets: ["localhost:9090"]

  - job_name: "jenkins"
    metrics_path: "/prometheus"
    static_configs:
      - targets: ["192.168.1.104:8080"]
</pre>
In the above configuration file, you need to replace 192.168.1.104 IP address with your RPS Lab machine IP Address.

Copy the prometheus config file into the container
```
docker cp prometheus.yml prometheus:/opt/bitnami/prometheus/conf/prometheus.yml
```

Restart the prometheus container to apply the config changes
```
docker restart prometheus
docker ps
docker logs prometheus
```

## Starting the grafana server as a Docker container
```
docker run -d --name grafana --hostname grafana grafana/grafana:latest
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022$ <b>docker run -d --name grafana --hostname grafana grafana/grafana:latest</b>
Unable to find image 'grafana/grafana:latest' locally
latest: Pulling from grafana/grafana
ab6db1bc80d0: Pull complete 
d6b66c58f746: Pull complete 
5c7a386536c8: Pull complete 
e2ed25aa5dc3: Pull complete 
953cebffd74c: Pull complete 
b14b14c7e0a0: Pull complete 
1a95f5b7d7ad: Pull complete 
a6154b5b5642: Pull complete 
9b61b8bbe699: Pull complete 
Digest: sha256:c6aa20c31944df1ceebc8ac04809cdb9d02a0969a4176f516c117eed9e488556
Status: Downloaded newer image for grafana/grafana:latest
09b5d3c1be7450268db2e3e54ae0e101a0e99e92732e95368d28957147e48636
</pre>

### Login to grafana with the below credentials
<pre>
username - admin
password - Admin@123
</pre>

### Configuration Grafana to Integrate Prometheus Datasource and Create a Jenkins Dashboard

Select Datasource and pick Prometheus.

Under the URL, you can type 172.17.0.5:9090

You need to replace 172.17.0.5 IP Address with your prometheus container IP.

Click on Save & Test.  You are expected to see a Green status for a successful configuration/integration.


Select Dashboard, and then click on Import, and type 9964 Grafana Dashboard.



