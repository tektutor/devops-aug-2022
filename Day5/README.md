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
### Accessing Prometheus web page from Google Chrome web browser
```
http://prometheus-container-ip:9090
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
url - http://grafana-container-ip:3000
default username - admin
default password - admin
updated password - Admin@123
</pre>

### Configuration Grafana to Integrate Prometheus Datasource and Create a Jenkins Dashboard

Select Datasource and pick Prometheus.

Under the URL, you can type 172.17.0.5:9090

You need to replace 172.17.0.5 IP Address with your prometheus container IP.

Click on Save & Test.  You are expected to see a Green status for a successful configuration/integration.


Select Dashboard, and then click on Import, and type 9964 Grafana Dashboard.


## Integrating SonarQube Reports as part of Maven Build

Start SonarQube Server as a docker container
```
docker run -d --name sonar --hostname sonar sonarqube:lts-community
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day5/CRM$ docker run -d --name sonar --hostname sonar sonarqube:lts-community
Unable to find image 'sonarqube:lts-community' locally
lts-community: Pulling from library/sonarqube
6097bfa160c1: Pull complete 
2a917640abdb: Pull complete 
05e4df694b2a: Pull complete 
ab4db49dccdd: Pull complete 
dc96645c4a2a: Pull complete 
Digest: sha256:2a241b2c26c496a0bf204e0a320da75eafdab000e8043487f0d3d9354fd8479a
Status: Downloaded newer image for sonarqube:lts-community
9180dd0290004df6019ed6b8fda8a409cebb57fb94cb68b3eb58dfd8f0bc7ab5
</pre>

### SonarQube URL and Login Credentials
<pre>
url - http://sonarqube-container-ip:9000
default username - admin
default password - admin
updated password - Admin@123
</pre>


### Create a project in Sonarqube
- Login to SonarQube server via its webpage
- Create a manual project ( I gave project and display name as tektutor but this can be any string )
- Generate a token ( I gave tektutor but you can give any name )

### Integrating Sonarqube with Maven
We need to add the sonar maven plugin to the pom.xml in order to perform static code analysis using SonarQube.

```
        <build>
                <plugins>
                        <plugin>
                                <groupId>org.sonarsource.scanner.maven</groupId>
                                <artifactId>sonar-maven-plugin</artifactId>
                                <version>3.4.0.905</version>
                        </plugin>
                </plugins>
        </build>
```

### Performing Static code analysis
```
mvn sonar:sonar -Dsonar.host.url=http://172.17.0.7:9000 -Dsonar.login=aad6a8d7900020a4657919a750a74a6ea0cfc6c2
```
In the above sonar.host.url, the IP 172.17.0.7 is the IP Address of SonarQube Container. You may have to replace that IP with your SonarQube Container IP.

In the above sonar.login, you need to replace the the token with your sonarqube project token.

If all goes well, then the Maven Sonar Plugin will scan through your project .class files and analyze them for code complexity, code smells and code coverage.  The Sonar Maven Plugin will publish the Sonar report to your SonarQube Server with the login credentials i.e token.

Then you should be able to check the SonarQube report from the SonarQube Server.

<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day5/CRM$ <b>mvn sonar:sonar -Dsonar.host.url=http://172.17.0.7:9000 -Dsonar.login=aad6a8d7900020a4657919a750a74a6ea0cfc6c2</b>
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] tektutor-crm-app                                                   [pom]
[INFO] frontend                                                           [jar]
[INFO] businesslayer                                                      [jar]
[INFO] backend                                                            [jar]
[INFO] main                                                               [jar]
Downloading from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/maven/sonar-maven-plugin/3.4.0.905/sonar-maven-plugin-3.4.0.905.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/maven/sonar-maven-plugin/3.4.0.905/sonar-maven-plugin-3.4.0.905.pom (9.1 kB at 6.6 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/sonarsource/parent/parent/41/parent-41.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonarsource/parent/parent/41/parent-41.pom (31 kB at 60 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/maven/sonar-maven-plugin/3.4.0.905/sonar-maven-plugin-3.4.0.905.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/maven/sonar-maven-plugin/3.4.0.905/sonar-maven-plugin-3.4.0.905.jar (43 kB at 83 kB/s)
[INFO] 
[INFO] -------------------< org.tektutor:tektutor-crm-app >--------------------
[INFO] Building tektutor-crm-app 1.0                                      [1/5]
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] 
[INFO] --- sonar-maven-plugin:3.4.0.905:sonar (default-cli) @ tektutor-crm-app ---
Downloading from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-sec-dispatcher/1.4/plexus-sec-dispatcher-1.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-sec-dispatcher/1.4/plexus-sec-dispatcher-1.4.pom (3.0 kB at 6.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.22/plexus-utils-3.0.22.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.22/plexus-utils-3.0.22.pom (3.8 kB at 8.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/api/sonar-scanner-api/2.10.0.1189/sonar-scanner-api-2.10.0.1189.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/api/sonar-scanner-api/2.10.0.1189/sonar-scanner-api-2.10.0.1189.pom (5.4 kB at 12 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/api/sonar-scanner-api-parent/2.10.0.1189/sonar-scanner-api-parent-2.10.0.1189.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/api/sonar-scanner-api-parent/2.10.0.1189/sonar-scanner-api-parent-2.10.0.1189.pom (4.9 kB at 11 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.pom
Downloaded from central: https://repo.maven.apache.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.pom (17 kB at 39 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/17/commons-parent-17.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/17/commons-parent-17.pom (31 kB at 66 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/apache/7/apache-7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/apache/7/apache-7.pom (14 kB at 33 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-sec-dispatcher/1.4/plexus-sec-dispatcher-1.4.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-cipher/1.4/plexus-cipher-1.4.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.22/plexus-utils-3.0.22.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/api/sonar-scanner-api/2.10.0.1189/sonar-scanner-api-2.10.0.1189.jar
Downloading from central: https://repo.maven.apache.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-sec-dispatcher/1.4/plexus-sec-dispatcher-1.4.jar (28 kB at 60 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonatype/plexus/plexus-cipher/1.4/plexus-cipher-1.4.jar (13 kB at 12 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.22/plexus-utils-3.0.22.jar (245 kB at 159 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar (284 kB at 160 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/sonarsource/scanner/api/sonar-scanner-api/2.10.0.1189/sonar-scanner-api-2.10.0.1189.jar (582 kB at 305 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/maven-metadata.xml (1.1 kB at 2.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.10.1/maven-compiler-plugin-3.10.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.10.1/maven-compiler-plugin-3.10.1.pom (13 kB at 31 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/34/maven-plugins-34.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/34/maven-plugins-34.pom (11 kB at 26 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/34/maven-parent-34.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/34/maven-parent-34.pom (43 kB at 102 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/apache/23/apache-23.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/apache/23/apache-23.pom (18 kB at 44 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.10.1/maven-compiler-plugin-3.10.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.10.1/maven-compiler-plugin-3.10.1.jar (62 kB at 146 kB/s)
[INFO] User cache: /home/jegan/.sonar/cache
[INFO] SonarQube version: 8.9.9
[INFO] Default locale: "en_IN", source code encoding: "UTF-8" (analysis is platform dependent)
[INFO] Load global settings
[INFO] Load global settings (done) | time=45ms
[INFO] Server id: BF41A1F2-AYJsrXTl3qPStdOzVDQQ
[INFO] User cache: /home/jegan/.sonar/cache
[INFO] Load/download plugins
[INFO] Load plugins index
[INFO] Load plugins index (done) | time=40ms
[INFO] Load/download plugins (done) | time=467ms
[INFO] Process project properties
[INFO] Process project properties (done) | time=5ms
[INFO] Execute project builders
[INFO] Execute project builders (done) | time=1ms
[INFO] Project key: org.tektutor:tektutor-crm-app
[INFO] Base dir: /home/jegan/devops-aug-2022/Day5/CRM
[INFO] Working dir: /home/jegan/devops-aug-2022/Day5/CRM/target/sonar
[INFO] Load project settings for component key: 'org.tektutor:tektutor-crm-app'
[INFO] Load quality profiles
[INFO] Load quality profiles (done) | time=35ms
[INFO] Load active rules
[INFO] Load active rules (done) | time=839ms
[INFO] Indexing files...
[INFO] Project configuration:
[INFO] Indexing files of module 'backend'
[INFO]   Base dir: /home/jegan/devops-aug-2022/Day5/CRM/backend
[INFO]   Source paths: pom.xml, src/main/java
[INFO]   Test paths: src/test/java
[INFO] Indexing files of module 'businesslayer'
[INFO]   Base dir: /home/jegan/devops-aug-2022/Day5/CRM/businesslayer
[INFO]   Source paths: pom.xml, src/main/java
[INFO]   Test paths: src/test/java
[INFO] Indexing files of module 'frontend'
[INFO]   Base dir: /home/jegan/devops-aug-2022/Day5/CRM/frontend
[INFO]   Source paths: pom.xml, src/main/java
[INFO]   Test paths: src/test/java
[INFO] Indexing files of module 'main'
[INFO]   Base dir: /home/jegan/devops-aug-2022/Day5/CRM/main
[INFO]   Source paths: pom.xml, src/main/java
[INFO]   Test paths: src/test/java
[INFO] Indexing files of module 'tektutor-crm-app'
[INFO]   Base dir: /home/jegan/devops-aug-2022/Day5/CRM
[INFO]   Source paths: pom.xml
[INFO] 13 files indexed
[INFO] 0 files ignored because of scm ignore settings
[INFO] Quality profile for java: Sonar way
[INFO] Quality profile for xml: Sonar way
[INFO] ------------- Run sensors on module backend
[INFO] Load metrics repository
[INFO] Load metrics repository (done) | time=10ms
[INFO] Sensor JavaSquidSensor [java]
[INFO] Configured Java source version (sonar.java.source): 11
[INFO] JavaClasspath initialization
[INFO] JavaClasspath initialization (done) | time=3ms
[INFO] JavaTestClasspath initialization
[INFO] JavaTestClasspath initialization (done) | time=1ms
[INFO] Java Main Files AST scan
[INFO] 1 source file to be analyzed
[INFO] Load project repositories
[INFO] Load project repositories (done) | time=3ms
[INFO] 1/1 source file has been analyzed
[INFO] Java Main Files AST scan (done) | time=313ms
[INFO] Java Test Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[WARNING] Dependencies/libraries were not provided for analysis of SOURCE files. The 'sonar.java.libraries' property is empty. Verify your configuration, as you might end up with less precise results.
[WARNING] Unresolved imports/types have been detected during analysis. Enable DEBUG mode to see them.
[INFO] Java Test Files AST scan (done) | time=30ms
[INFO] Java Generated Files AST scan
[INFO] 0 source files to be analyzed
[INFO] 0/0 source files have been analyzed
[INFO] Java Generated Files AST scan (done) | time=0ms
[INFO] Sensor JavaSquidSensor [java] (done) | time=478ms
[INFO] Sensor CSS Rules [cssfamily]
[INFO] No CSS, PHP, HTML or VueJS files are found in the project. CSS analysis is skipped.
[INFO] Sensor CSS Rules [cssfamily] (done) | time=1ms
[INFO] Sensor JaCoCo XML Report Importer [jacoco]
[INFO] 'sonar.coverage.jacoco.xmlReportPaths' is not defined. Using default locations: target/site/jacoco/jacoco.xml,target/site/jacoco-it/jacoco.xml,build/reports/jacoco/test/jacocoTestReport.xml
[INFO] No report imported, no coverage information will be imported by JaCoCo XML Report Importer
[INFO] Sensor JaCoCo XML Report Importer [jacoco] (done) | time=1ms
[INFO] Sensor C# Project Type Information [csharp]
[INFO] Sensor C# Project Type Information [csharp] (done) | time=0ms
[INFO] Sensor C# Properties [csharp]
[INFO] Sensor C# Properties [csharp] (done) | time=0ms
[INFO] Sensor SurefireSensor [java]
[INFO] parsing [/home/jegan/devops-aug-2022/Day5/CRM/backend/target/surefire-reports]
[INFO] Sensor SurefireSensor [java] (done) | time=1ms
[INFO] Sensor JavaXmlSensor [java]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor JavaXmlSensor [java] (done) | time=62ms
[INFO] Sensor HTML [web]
[INFO] Sensor HTML [web] (done) | time=1ms
[INFO] Sensor XML Sensor [xml]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor XML Sensor [xml] (done) | time=38ms
[INFO] Sensor VB.NET Project Type Information [vbnet]
[INFO] Sensor VB.NET Project Type Information [vbnet] (done) | time=0ms
[INFO] Sensor VB.NET Properties [vbnet]
[INFO] Sensor VB.NET Properties [vbnet] (done) | time=0ms
[INFO] ------------- Run sensors on module frontend
[INFO] Sensor JavaSquidSensor [java]
[INFO] Configured Java source version (sonar.java.source): 11
[INFO] JavaClasspath initialization
[INFO] JavaClasspath initialization (done) | time=0ms
[INFO] JavaTestClasspath initialization
[INFO] JavaTestClasspath initialization (done) | time=0ms
[INFO] Java Main Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Java Main Files AST scan (done) | time=9ms
[INFO] Java Test Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[WARNING] Dependencies/libraries were not provided for analysis of SOURCE files. The 'sonar.java.libraries' property is empty. Verify your configuration, as you might end up with less precise results.
[WARNING] Unresolved imports/types have been detected during analysis. Enable DEBUG mode to see them.
[INFO] Java Test Files AST scan (done) | time=8ms
[INFO] Java Generated Files AST scan
[INFO] 0 source files to be analyzed
[INFO] 0/0 source files have been analyzed
[INFO] Java Generated Files AST scan (done) | time=0ms
[INFO] Sensor JavaSquidSensor [java] (done) | time=19ms
[INFO] Sensor CSS Rules [cssfamily]
[INFO] No CSS, PHP, HTML or VueJS files are found in the project. CSS analysis is skipped.
[INFO] Sensor CSS Rules [cssfamily] (done) | time=1ms
[INFO] Sensor JaCoCo XML Report Importer [jacoco]
[INFO] 'sonar.coverage.jacoco.xmlReportPaths' is not defined. Using default locations: target/site/jacoco/jacoco.xml,target/site/jacoco-it/jacoco.xml,build/reports/jacoco/test/jacocoTestReport.xml
[INFO] No report imported, no coverage information will be imported by JaCoCo XML Report Importer
[INFO] Sensor JaCoCo XML Report Importer [jacoco] (done) | time=0ms
[INFO] Sensor C# Project Type Information [csharp]
[INFO] Sensor C# Project Type Information [csharp] (done) | time=0ms
[INFO] Sensor C# Properties [csharp]
[INFO] Sensor C# Properties [csharp] (done) | time=0ms
[INFO] Sensor SurefireSensor [java]
[INFO] parsing [/home/jegan/devops-aug-2022/Day5/CRM/frontend/target/surefire-reports]
[INFO] Sensor SurefireSensor [java] (done) | time=0ms
[INFO] Sensor JavaXmlSensor [java]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor JavaXmlSensor [java] (done) | time=4ms
[INFO] Sensor HTML [web]
[INFO] Sensor HTML [web] (done) | time=0ms
[INFO] Sensor XML Sensor [xml]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor XML Sensor [xml] (done) | time=5ms
[INFO] Sensor VB.NET Project Type Information [vbnet]
[INFO] Sensor VB.NET Project Type Information [vbnet] (done) | time=0ms
[INFO] Sensor VB.NET Properties [vbnet]
[INFO] Sensor VB.NET Properties [vbnet] (done) | time=0ms
[INFO] ------------- Run sensors on module businesslayer
[INFO] Sensor JavaSquidSensor [java]
[INFO] Configured Java source version (sonar.java.source): 11
[INFO] JavaClasspath initialization
[INFO] JavaClasspath initialization (done) | time=0ms
[INFO] JavaTestClasspath initialization
[INFO] JavaTestClasspath initialization (done) | time=0ms
[INFO] Java Main Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Java Main Files AST scan (done) | time=10ms
[INFO] Java Test Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[WARNING] Dependencies/libraries were not provided for analysis of SOURCE files. The 'sonar.java.libraries' property is empty. Verify your configuration, as you might end up with less precise results.
[WARNING] Unresolved imports/types have been detected during analysis. Enable DEBUG mode to see them.
[INFO] Java Test Files AST scan (done) | time=9ms
[INFO] Java Generated Files AST scan
[INFO] 0 source files to be analyzed
[INFO] 0/0 source files have been analyzed
[INFO] Java Generated Files AST scan (done) | time=1ms
[INFO] Sensor JavaSquidSensor [java] (done) | time=23ms
[INFO] Sensor CSS Rules [cssfamily]
[INFO] No CSS, PHP, HTML or VueJS files are found in the project. CSS analysis is skipped.
[INFO] Sensor CSS Rules [cssfamily] (done) | time=0ms
[INFO] Sensor JaCoCo XML Report Importer [jacoco]
[INFO] 'sonar.coverage.jacoco.xmlReportPaths' is not defined. Using default locations: target/site/jacoco/jacoco.xml,target/site/jacoco-it/jacoco.xml,build/reports/jacoco/test/jacocoTestReport.xml
[INFO] No report imported, no coverage information will be imported by JaCoCo XML Report Importer
[INFO] Sensor JaCoCo XML Report Importer [jacoco] (done) | time=0ms
[INFO] Sensor C# Project Type Information [csharp]
[INFO] Sensor C# Project Type Information [csharp] (done) | time=0ms
[INFO] Sensor C# Properties [csharp]
[INFO] Sensor C# Properties [csharp] (done) | time=0ms
[INFO] Sensor SurefireSensor [java]
[INFO] parsing [/home/jegan/devops-aug-2022/Day5/CRM/businesslayer/target/surefire-reports]
[INFO] Sensor SurefireSensor [java] (done) | time=0ms
[INFO] Sensor JavaXmlSensor [java]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor JavaXmlSensor [java] (done) | time=6ms
[INFO] Sensor HTML [web]
[INFO] Sensor HTML [web] (done) | time=0ms
[INFO] Sensor XML Sensor [xml]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor XML Sensor [xml] (done) | time=11ms
[INFO] Sensor VB.NET Project Type Information [vbnet]
[INFO] Sensor VB.NET Project Type Information [vbnet] (done) | time=1ms
[INFO] Sensor VB.NET Properties [vbnet]
[INFO] Sensor VB.NET Properties [vbnet] (done) | time=0ms
[INFO] ------------- Run sensors on module main
[INFO] Sensor JavaSquidSensor [java]
[INFO] Configured Java source version (sonar.java.source): 11
[INFO] JavaClasspath initialization
[INFO] JavaClasspath initialization (done) | time=0ms
[INFO] JavaTestClasspath initialization
[INFO] JavaTestClasspath initialization (done) | time=0ms
[INFO] Java Main Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Java Main Files AST scan (done) | time=80ms
[INFO] Java Test Files AST scan
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[WARNING] Unresolved imports/types have been detected during analysis. Enable DEBUG mode to see them.
[INFO] Java Test Files AST scan (done) | time=7ms
[INFO] Java Generated Files AST scan
[INFO] 0 source files to be analyzed
[INFO] 0/0 source files have been analyzed
[INFO] Java Generated Files AST scan (done) | time=1ms
[INFO] Sensor JavaSquidSensor [java] (done) | time=92ms
[INFO] Sensor CSS Rules [cssfamily]
[INFO] No CSS, PHP, HTML or VueJS files are found in the project. CSS analysis is skipped.
[INFO] Sensor CSS Rules [cssfamily] (done) | time=0ms
[INFO] Sensor JaCoCo XML Report Importer [jacoco]
[INFO] 'sonar.coverage.jacoco.xmlReportPaths' is not defined. Using default locations: target/site/jacoco/jacoco.xml,target/site/jacoco-it/jacoco.xml,build/reports/jacoco/test/jacocoTestReport.xml
[INFO] No report imported, no coverage information will be imported by JaCoCo XML Report Importer
[INFO] Sensor JaCoCo XML Report Importer [jacoco] (done) | time=0ms
[INFO] Sensor C# Project Type Information [csharp]
[INFO] Sensor C# Project Type Information [csharp] (done) | time=0ms
[INFO] Sensor C# Properties [csharp]
[INFO] Sensor C# Properties [csharp] (done) | time=0ms
[INFO] Sensor SurefireSensor [java]
[INFO] parsing [/home/jegan/devops-aug-2022/Day5/CRM/main/target/surefire-reports]
[INFO] Sensor SurefireSensor [java] (done) | time=0ms
[INFO] Sensor JavaXmlSensor [java]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor JavaXmlSensor [java] (done) | time=5ms
[INFO] Sensor HTML [web]
[INFO] Sensor HTML [web] (done) | time=0ms
[INFO] Sensor XML Sensor [xml]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor XML Sensor [xml] (done) | time=4ms
[INFO] Sensor VB.NET Project Type Information [vbnet]
[INFO] Sensor VB.NET Project Type Information [vbnet] (done) | time=0ms
[INFO] Sensor VB.NET Properties [vbnet]
[INFO] Sensor VB.NET Properties [vbnet] (done) | time=0ms
[INFO] ------------- Run sensors on module tektutor-crm-app
[INFO] Sensor CSS Rules [cssfamily]
[INFO] No CSS, PHP, HTML or VueJS files are found in the project. CSS analysis is skipped.
[INFO] Sensor CSS Rules [cssfamily] (done) | time=0ms
[INFO] Sensor JaCoCo XML Report Importer [jacoco]
[INFO] 'sonar.coverage.jacoco.xmlReportPaths' is not defined. Using default locations: target/site/jacoco/jacoco.xml,target/site/jacoco-it/jacoco.xml,build/reports/jacoco/test/jacocoTestReport.xml
[INFO] No report imported, no coverage information will be imported by JaCoCo XML Report Importer
[INFO] Sensor JaCoCo XML Report Importer [jacoco] (done) | time=1ms
[INFO] Sensor C# Project Type Information [csharp]
[INFO] Sensor C# Project Type Information [csharp] (done) | time=0ms
[INFO] Sensor C# Properties [csharp]
[INFO] Sensor C# Properties [csharp] (done) | time=0ms
[INFO] Sensor JavaXmlSensor [java]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor JavaXmlSensor [java] (done) | time=5ms
[INFO] Sensor HTML [web]
[INFO] Sensor HTML [web] (done) | time=0ms
[INFO] Sensor XML Sensor [xml]
[INFO] 1 source file to be analyzed
[INFO] 1/1 source file has been analyzed
[INFO] Sensor XML Sensor [xml] (done) | time=5ms
[INFO] Sensor VB.NET Project Type Information [vbnet]
[INFO] Sensor VB.NET Project Type Information [vbnet] (done) | time=0ms
[INFO] Sensor VB.NET Properties [vbnet]
[INFO] Sensor VB.NET Properties [vbnet] (done) | time=0ms
[INFO] ------------- Run sensors on project
[INFO] Sensor Zero Coverage Sensor
[INFO] Sensor Zero Coverage Sensor (done) | time=4ms
[INFO] Sensor Java CPD Block Indexer
[INFO] Sensor Java CPD Block Indexer (done) | time=6ms
[INFO] SCM Publisher SCM provider for this project is: git
[INFO] SCM Publisher 13 source files to be analyzed
[INFO] SCM Publisher 0/13 source files have been analyzed (done) | time=26ms
[WARNING] Missing blame information for the following files:
[WARNING]   * frontend/src/main/java/org/tektutor/Frontend.java
[WARNING]   * main/pom.xml
[WARNING]   * backend/src/main/java/org/tektutor/Backend.java
[WARNING]   * businesslayer/pom.xml
[WARNING]   * pom.xml
[WARNING]   * businesslayer/src/main/java/org/tektutor/BusinessLayer.java
[WARNING]   * businesslayer/src/test/java/org/tektutor/BusinessLayerTest.java
[WARNING]   * backend/src/test/java/org/tektutor/BackendTest.java
[WARNING]   * backend/pom.xml
[WARNING]   * main/src/main/java/org/tektutor/Main.java
[WARNING]   * main/src/test/java/org/tektutor/MainTest.java
[WARNING]   * frontend/pom.xml
[WARNING]   * frontend/src/test/java/org/tektutor/FrontendTest.java
[WARNING] This may lead to missing/broken features in SonarQube
[INFO] CPD Executor 3 files had no CPD blocks
[INFO] CPD Executor Calculating CPD for 1 file
[INFO] CPD Executor CPD calculation finished (done) | time=3ms
[INFO] Analysis report generated in 26ms, dir size=111 KB
[INFO] Analysis report compressed in 10ms, zip size=27 KB
[INFO] Analysis report uploaded in 91ms
[INFO] ANALYSIS SUCCESSFUL, you can browse http://172.17.0.7:9000/dashboard?id=org.tektutor%3Atektutor-crm-app
[INFO] Note that you will be able to access the updated dashboard once the server has processed the submitted analysis report
[INFO] More about the report processing at http://172.17.0.7:9000/api/ce/task?id=AYJs03IU3qPStdOzVIBd
[INFO] Analysis total time: 2.484 s
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for tektutor-crm-app 1.0:
[INFO] 
[INFO] tektutor-crm-app ................................... SUCCESS [ 11.110 s]
[INFO] frontend ........................................... SKIPPED
[INFO] businesslayer ...................................... SKIPPED
[INFO] backend ............................................ SKIPPED
[INFO] main ............................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  13.726 s
[INFO] Finished at: 2022-08-05T12:36:12+05:30
[INFO] ------------------------------------------------------------------------
</pre>

## DevOps CI/CD Pipeline

Tools
- Docker
- Ansible
- Maven
- Jenkins

Git/GitHub
  - Version Control

Ansible
  - Build a custom Docker Image which will be used as a Jenkins Slave

Docker Container
  - as a Jenkins Slave

Maven
  - We can take CRM maven project and build it inside the Docker Container ( Jenkins Slave )
  
Jenkins
  - polls GitHub devops-aug-2022 repository
  - when it detects code change, it should trigger Maven package  
