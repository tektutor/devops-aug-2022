# Day 1

## Cloning this repo
```
cd ~
git clone https://github.com/tektutor/devops-aug-2022.git
cd devops-aug-2022
```

## Installing JDK 11 in CentOS 7.x
```
sudo yum install -y epel-release
sudo yum install -y java-11-openjdk-devel
```

## Package Managers
- Ubuntu/Debian Linux distros, they use a package manager called apt(apt-get)
- CentOS/RHEL Linux distros, they use a package managed called yum, rpm
- are used to install/uninstall/update/upgrades softwares
- package managers use config files to pick the server url(repository server urls) to download the softwares

## What is Ant ?
- an opensource build tool
- used by Java projects
- developed by Apache Foundation
- however it is language agnostic ( works with every programming language )
- there is standard/convention 
  - project directory structure
- build.xml
  - all the build instructions are captured
- doesn't dependency management 

## What is Maven ?
- an opensource build tool
- language agnostic build tool ( works with any programming language )
- developed by Apache Foundation
- Convention over Configuration
    - 80-20 Principle
- a better ant build tool which resolve the pitfalls of Ant

### Maven Co-ordinates
- just like GPS co-ordinates ( Longitude, Latitude and Altitude )   
   - the combination the above 3 co-ordinates will uniquely locate a position on Earth
- Maven projects are named based on Maven co-ordinates
- 3 co-ordinates
  1. GroupId 
     - normally represents your organization reverse domain name
     - tektutor.org is the domain, reverse domain will be org.tektutor
     - it is a string
  2. ArtifactId
     - name of the jar/war/ear/zip/exe
  3. version
     a.b.c
     1.2.3
     1 - represents the major version
     2 - represents the minor version
     3 - represents the incremental version 

### Local Repository
- it is hidden directory on the system where Maven is installed
- the local repo will have all the locally cached Maven plugins and dependent jar & poms

### Private Repository
- it can be setup using either JFrog Artifactory or Sonatype Nexus
- it has your organization proprietary jar/pom(any artifacts - zip/exe/war/jar/ear, etc. )
- this is optional but most organization will use one

### Central Repository
- has all the opensource libary/plugin binaries


## ??????????????? Lab - Writing your first hello world application following maven conventions

Open terminal on your RPS lab machine and navigate to below folder to pull delta changes
```
cd /home/devops/devops-aug-2022
git pull
```

Try validating the pom file as shown below
```
cd /home/devops/devops-aug-2022/Day1/hello
mvn validate
```

Expected output
<pre>
[jegan@tektutor hello]$ <b>mvn validate</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.tektutor:tektutor-hello-app >-------------------
[INFO] Building tektutor-hello-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.094 s
[INFO] Finished at: 2022-08-01T00:15:11-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## ??????????????? Lab - Listing the plugin goals
```
mvn help:describe -DgroupId=org.apache.maven.plugins -DartifactId=maven-compiler-plugin -Dversion=3.1 
```

## Listing the plugin goals with parameter details
```
cd ~/devops-aug-2022
git pull

cd Day1/hello
mvn help:describe -DgroupId=org.apache.maven.plugins -DartifactId=maven-compiler-plugin -Dversion=3.1 -Ddetail=true > goals.txt

more goals.txt
```

## Super POM
- Super POM has most common set of configurations required by most Java applications
- every Project specific POM file inherits the common set of properties from Super POM by default

## Effective POM
- is a comibination of your project POM file + Super POM
- maven generates the effective POM on the fly(runtime) and it uses the properties to decide how your maven project should be compiled

## Command to generate effective pom
```
cd ~/devops-aug-2022
git pull

cd Day1/hello
mvn help:effective-pom > effective-pom.txt

more effective-pom.txt
```

## Maven Life cycle
- Maven supports 3 types of Life cycle
  1. default
  2. clean 
  3. site
- is a combination of many phases that are executed from top to bottom in a sequential fashion

### default maven lifecycle
- it supports 23 Phases

### ??????????????? Lab - Listing the default life-cycle phases
```
cd ~/devops-aug-2022
git pull

cd Day1/hello
mvn help:describe -Dcmd=compile
```

Expected output
<pre>
[jegan@tektutor hello]$ <b>mvn help:describe -Dcmd=compile</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.tektutor:tektutor-hello-app >-------------------
[INFO] Building tektutor-hello-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.2.0:describe (default-cli) @ tektutor-hello-app ---
[INFO] 'compile' is a phase corresponding to this plugin:
org.apache.maven.plugins:maven-compiler-plugin:3.1:compile

It is a part of the lifecycle for the POM packaging 'jar'. This lifecycle includes the following phases:
* validate: Not defined
* initialize: Not defined
* generate-sources: Not defined
* process-sources: Not defined
* generate-resources: Not defined
* process-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:resources
* compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:compile
* process-classes: Not defined
* generate-test-sources: Not defined
* process-test-sources: Not defined
* generate-test-resources: Not defined
* process-test-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:testResources
* test-compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile
* process-test-classes: Not defined
* test: org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test
* prepare-package: Not defined
* package: org.apache.maven.plugins:maven-jar-plugin:2.4:jar
* pre-integration-test: Not defined
* integration-test: Not defined
* post-integration-test: Not defined
* verify: Not defined
* install: org.apache.maven.plugins:maven-install-plugin:2.4:install
* deploy: org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.982 s
[INFO] Finished at: 2022-08-01T02:24:48-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## ??????????????? Lab - Listing the clean life-cycle phases
```
mvn help:describe -Dcmd=clean
```

Expected output
<pre>
[jegan@tektutor hello]$ <b>mvn help:describe -Dcmd=clean</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.tektutor:tektutor-hello-app >-------------------
[INFO] Building tektutor-hello-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.2.0:describe (default-cli) @ tektutor-hello-app ---
[INFO] 'clean' is a phase within the 'clean' lifecycle, which has the following phases: 
* pre-clean: Not defined
* clean: org.apache.maven.plugins:maven-clean-plugin:2.5:clean
* post-clean: Not defined

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.037 s
[INFO] Finished at: 2022-08-01T02:33:01-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## ??????????????? Lab - Listing site life-cycle phases
```
mvn help:describe -Dcmd=site
```

Expected output
<pre>
[jegan@tektutor hello]$ <b>mvn help:describe -Dcmd=site</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.tektutor:tektutor-hello-app >-------------------
[INFO] Building tektutor-hello-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.2.0:describe (default-cli) @ tektutor-hello-app ---
[INFO] 'site' is a phase within the 'site' lifecycle, which has the following phases: 
* pre-site: Not defined
* site: org.apache.maven.plugins:maven-site-plugin:3.3:site
* post-site: Not defined
* site-deploy: org.apache.maven.plugins:maven-site-plugin:3.3:deploy

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.182 s
[INFO] Finished at: 2022-08-01T02:36:39-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## ??????????????? Lab - Creating a custom maven plugin

Command used to generate plugin project.  You can skip this step as the tektutor-hello-plugin project has all the necessary code.  This is just for your knowledge.
```
mvn archetype:generate -DgroupId=org.tektutor -DartifactId=tektutor-hello-plugin -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-plugin -DinteractiveMode=false
```


Please try this one
```
cd ~/devops-aug-2022
git pull

cd Day1/tektutor-hello-plugin
mvn clean install
```

## ??????????????? Lab - Testing the custom maven plugin without configuring pom file
```
cd ~/devops-aug-2022
git pull

cd Day1/tektutor-hello-plugin
mvn install
mvn org.tektutor:tektutor-hello-plugin:1.0:hello
```
Expected output
<pre>
[jegan@tektutor tektutor-hello-plugin]$ <b>mvn install</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.tektutor:tektutor-hello-plugin >-----------------
[INFO] Building tektutor-hello-plugin Maven Mojo 1.0
[INFO] ----------------------------[ maven-plugin ]----------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tektutor-hello-plugin ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/jegan/devops-aug-2022/Day1/tektutor-hello-plugin/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ tektutor-hello-plugin ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jegan/devops-aug-2022/Day1/tektutor-hello-plugin/target/classes
[INFO] 
[INFO] --- maven-plugin-plugin:3.2:descriptor (default-descriptor) @ tektutor-hello-plugin ---
[WARNING] Using platform encoding (UTF-8 actually) to read mojo metadata, i.e. build is platform dependent!
[INFO] Applying mojo extractor for language: java
[INFO] Mojo extractor for language: java found 1 mojo descriptors.
[INFO] Applying mojo extractor for language: bsh
[INFO] Mojo extractor for language: bsh found 0 mojo descriptors.
[INFO] Applying mojo extractor for language: java-annotations
[INFO] Mojo extractor for language: java-annotations found 0 mojo descriptors.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ tektutor-hello-plugin ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/jegan/devops-aug-2022/Day1/tektutor-hello-plugin/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ tektutor-hello-plugin ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ tektutor-hello-plugin ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ tektutor-hello-plugin ---
[INFO] Building jar: /home/jegan/devops-aug-2022/Day1/tektutor-hello-plugin/target/tektutor-hello-plugin-1.0.jar
[INFO] 
[INFO] --- maven-plugin-plugin:3.2:addPluginArtifactMetadata (default-addPluginArtifactMetadata) @ tektutor-hello-plugin ---
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ tektutor-hello-plugin ---
[INFO] Installing /home/jegan/devops-aug-2022/Day1/tektutor-hello-plugin/target/tektutor-hello-plugin-1.0.jar to /home/jegan/.m2/repository/org/tektutor/tektutor-hello-plugin/1.0/tektutor-hello-plugin-1.0.jar
[INFO] Installing /home/jegan/devops-aug-2022/Day1/tektutor-hello-plugin/pom.xml to /home/jegan/.m2/repository/org/tektutor/tektutor-hello-plugin/1.0/tektutor-hello-plugin-1.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.581 s
[INFO] Finished at: 2022-08-01T03:21:17-07:00
[INFO] ------------------------------------------------------------------------
[jegan@tektutor tektutor-hello-plugin]$ <b>mvn org.tektutor:tektutor-hello-plugin:1.0:hello</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.tektutor:tektutor-hello-plugin >-----------------
[INFO] Building tektutor-hello-plugin Maven Mojo 1.0
[INFO] ----------------------------[ maven-plugin ]----------------------------
[INFO] 
[INFO] --- tektutor-hello-plugin:1.0:hello (default-cli) @ tektutor-hello-plugin ---
TekTutor Hello plugin - hello goal invoked !
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.225 s
[INFO] Finished at: 2022-08-01T03:21:33-07:00
[INFO] ------------------------------------------------------------------------
</pre>


## ??????????????? Lab - Invoking our custom plugin from another project
You need to configure the pom.xml file to invoke your custom plugin as shown below
```
<project>
        <modelVersion>4.0.0</modelVersion>

        <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
        </properties>

        <groupId>org.tektutor</groupId>
        <artifactId>tektutor-hello-app</artifactId>
        <version>1.0.0</version>

        <build>
                <plugins>
                        <plugin>
                                <groupId>org.tektutor</groupId>
                                <artifactId>tektutor-hello-plugin</artifactId>
                                <version>1.0</version>
                                <executions>
                                        <execution>
                                                <id>custom-hello</id>
                                                <phase>validate</phase>
                                                <goals>
                                                        <goal>hello</goal>
                                                </goals>
                                        </execution>
                                </executions>
                        </plugin>
                </plugins>
        </build>
</project>
```
The above configurations are already done in the pom.xml.

```
cd ~/devops-aug-2022
git pull

cd Day1/hello
mvn validate
```

Expected output
<pre>
[jegan@tektutor hello]$ <b>mvn validate</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.tektutor:tektutor-hello-app >-------------------
[INFO] Building tektutor-hello-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- tektutor-hello-plugin:1.0:hello (custom-hello) @ tektutor-hello-app ---
<b>TekTutor Hello plugin - hello goal invoked !</b>
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.198 s
[INFO] Finished at: 2022-08-01T03:19:57-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## Creating Opensource JFrog Artifactory container
```
docker run --name artifactory -d -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```
Expected output
<pre>
[jegan@tektutor devops-aug-2022]$ <b>docker run --name artifactory -d -p 8081:8081  -p 8082:8082  docker.bintray.io/jfrog/artifactory-oss:latest</b>
Unable to find image 'docker.bintray.io/jfrog/artifactory-oss:latest' locally
latest: Pulling from jfrog/artifactory-oss
4f4fb700ef54: Pull complete 
6d4016e28cd2: Pull complete 
3586b82cdb38: Pull complete 
efd173c71a6c: Pull complete 
9ab9a2e4e6ca: Pull complete 
632a363c34eb: Pull complete 
7cdbe2d200e6: Pull complete 
5b6aada0af2b: Pull complete 
215521586005: Pull complete 
dfa0d383f974: Pull complete 
Digest: sha256:7b0260c810bf42d10858919d273dcfcba02f24436160faae761e9c3f84618bf6
Status: Downloaded newer image for docker.bintray.io/jfrog/artifactory-oss:latest
dbd8dc39710c1739c46aeac607a60c01f91cf45b26e024018937835effc0dbd6
</pre>

## Troubleshooting permission denied error
```
newgrp docker
docker rm -f $(docker ps -aq)
docker run --name artifactory -d -p 8081:8081  -p 8082:8082  docker.bintray.io/jfrog/artifactory-oss:latest
```


Listing the container
```
docker ps
```

Finding the artifactory container IP address
```
docker inspect artifactory | grep IPA
```

## Troubleshooting JFrog Artifactory container creation
In case docker ps command doesn't show artifactory container in running state, then try deleting and recreate.
```
docker rm -f artifactory
docker run --name artifactory -d -p 8081:8081 -p 8082:8082 docker.bintray.io/jfrog/artifactory-oss:latest
```

List the container and see if it is running now
```
docker ps
```
Expected output
<pre>
[jegan@tektutor devops-aug-2022]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS          PORTS                                       NAMES
877d63dc8496   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac???"   11 seconds ago   Up 10 seconds   0.0.0.0:8081->8081/tcp, :::8081->8081/tcp   artifactory
</pre>

## Accessing the JFrog Artifactory webpage
```
locahost:8081
```

It would take some time to load the server.  Once it is ready, the JFrog Artifactory url will be redirectred to localhost:8082/ui url

When it prompts for credentials, type 'admin' as user and 'password' for password.  The first time you login, it will ask you to change the password, I changed it to 'Admin@123'


## Build and install the multi-module project artifacts into Local Repository
```
cd ~/devops-aug-2022
git pull

cd Day1/CRM
mvn clean install
```
