# Day 1

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


## Writing your first hello world application following maven conventions

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

## Listing the plugin goals
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

### Listing the default life-cycle phases
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

## Listing the clean life-cycle phases
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

## Listing site life-cycle phases
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
