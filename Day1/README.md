# Day 1

## Installing JDK 11 in CentOS 7.x
```
sudo yum install -y epel-release
sudo yum install -y java-11-openjdk-devel
```

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
cd /home/devops/devops-aug-2022/hello
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
