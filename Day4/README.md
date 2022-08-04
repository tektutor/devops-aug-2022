# Day4

## Waterfall
- is a Framework

- Disadvantages
 - Feedback comes pretty late
 - By the time the customer shared feedback, the product is already complete, the damage is done
 

## Agile
- is Software Development Methodology
- Agile Frameworks
   - SCRUM - one of the popular framework
   - Kanban
   - Extreme Programming (TDD, Pair Programming, CI/CD )
- Fail Fast

## What is Continuous Integration (CI)?
- the code written in committed to source repository several times a time
- engineering practice of Agile ( Fail fast mechanism )
- helps in getting frequent feedbacks
- Tools
    - Continuous Integration Build Server (CI)
      - Jenkins
      - Bamboo
      - Team City
      - Microsoft Team Foundation Server
    - XLR/XLD (XebiaLabs Release/XebiaLabs Deploy)
    - Git/GitHub/GitLab
    - Build Tools ( Maven, Gradle,ms build, etc )
    - TDD ( Java - Junit/TestNg,Mockito, C# - NUnit/MSTest, Moq, Javascript/NodeJS/Angular/ReactJS - Jasmine,Karma)
    - BDD - ( Cucumber,Selenium, Specflow, etc )

## What is Continuous Deployment (CD)?
- The binary that is Unit & Integration Test, can be automatically deployed for further QA Test
- The QA team will have further automated end-to-end functionality test, performance test, stress/load test,etc
- The QA team certified release can further be deployed to Pre-Stage and from there Staging environment for further production like testing

## What is Continuous Delivery (CD)?
- The highest maturity model, wherein the Development Team and the Organization is so confident about their
  CI/CD process and test cases the team (Dev & QA) has added. The confident is so much that you will have automated process to delivery the binaries to your customer or your customer's environment, or it can even go live in Production
  
## What is DevOps?
- Teams
    - Dev Team
    - QA Team
    - System Administration Team
    - All these teams work so closely as a single team
    - Code Repository
       - Dev Team will commit the application code along with Unit & Integaration Test Cases
       - QA Team will commit the E2E, Stree,Load, Performance, etc automated test cases in the same repo
       - System Administration Team will check in Dockerfile, Ansible Playbooks, etc as part of the same repo
- DevOps Engineers
- DevOps Tool
   - Containers - Docker, Podman, etc.,
   - Orchestration Platforms - Docker SWARM, Kubernetes, RedHat OpenShift, AWS ROSA, Azure OpenShift,etc.,
   - Build Tools - Jenkins, Cloudbees, etc.,
   - Pipeline - XLR/XLD, Jenkins, Tekton, etc.,
 
 ## Jenkins
 - CI/CD Build Server
 - developed by Kohsuke Kawaguchi
 - Kohsuke Kawaguchi was a former Sun MicroSystems employee
 - developed a CI/CD tool called Hudson
 - later Oracle acquired Sun MicroSystems
 - Oracle CEO
    - Lary Elison
 - The team that originally developed Hudson they came of Oracle, they forked Hudson source code as Jenkins
 - The part of the Hudson that came out of Oracle maintains the Jenkins, while the team at Oracle maintains the Hudson

## You may check my medium blog on this topic here
<pre>
https://medium.com/tektutor/ci-cd-with-maven-github-docker-jenkins-aca28c252fec
</pre>

## Launching Jenkins
```
cd ~/Downloads
java -jar ./jenkins.war
```
The above command will launch Jenkins in the interactive mode, so you won't be able to use this terminal for other purpose.  Hence I would recommend opening another tab for running any other commands.

Expected output
<pre>
jegan@dell-precision-7670:~/Downloads$ java -jar ./jenkins.war 
Running from: /home/jegan/Downloads/jenkins.war
webroot: $user.home/.jenkins
2022-08-04 06:44:02.830+0000 [id=1]	INFO	org.eclipse.jetty.util.log.Log#initialized: Logging initialized @225ms to org.eclipse.jetty.util.log.JavaUtilLog
2022-08-04 06:44:02.862+0000 [id=1]	INFO	winstone.Logger#logInternal: Beginning extraction from war file
2022-08-04 06:44:02.873+0000 [id=1]	WARNING	o.e.j.s.handler.ContextHandler#setContextPath: Empty contextPath
2022-08-04 06:44:02.900+0000 [id=1]	INFO	org.eclipse.jetty.server.Server#doStart: jetty-9.4.45.v20220203; built: 2022-02-03T09:14:34.105Z; git: 4a0c91c0be53805e3fcffdcdcc9587d5301863db; jvm 11.0.15+10-Ubuntu-0ubuntu0.20.04.1
2022-08-04 06:44:03.001+0000 [id=1]	INFO	o.e.j.w.StandardDescriptorProcessor#visitServlet: NO JSP Support for /, did not find org.eclipse.jetty.jsp.JettyJspServlet
2022-08-04 06:44:03.015+0000 [id=1]	INFO	o.e.j.s.s.DefaultSessionIdManager#doStart: DefaultSessionIdManager workerName=node0
2022-08-04 06:44:03.015+0000 [id=1]	INFO	o.e.j.s.s.DefaultSessionIdManager#doStart: No SessionScavenger set, using defaults
2022-08-04 06:44:03.016+0000 [id=1]	INFO	o.e.j.server.session.HouseKeeper#startScavenging: node0 Scavenging every 660000ms
2022-08-04 06:44:03.200+0000 [id=1]	INFO	hudson.WebAppMain#contextInitialized: Jenkins home directory: /home/jegan/.jenkins found at: $user.home/.jenkins
2022-08-04 06:44:03.280+0000 [id=1]	INFO	o.e.j.s.handler.ContextHandler#doStart: Started w.@495083a0{Jenkins v2.346.2,/,file:///home/jegan/.jenkins/war/,AVAILABLE}{/home/jegan/.jenkins/war}
2022-08-04 06:44:03.297+0000 [id=1]	INFO	o.e.j.server.AbstractConnector#doStart: Started ServerConnector@eb21112{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
2022-08-04 06:44:03.298+0000 [id=1]	INFO	org.eclipse.jetty.server.Server#doStart: Started @693ms
2022-08-04 06:44:03.298+0000 [id=40]	INFO	winstone.Logger#logInternal: Winstone Servlet Engine running: controlPort=disabled
2022-08-04 06:44:03.466+0000 [id=47]	INFO	jenkins.InitReactorRunner$1#onAttained: Started initialization
2022-08-04 06:44:03.470+0000 [id=67]	INFO	jenkins.InitReactorRunner$1#onAttained: Listed all plugins
2022-08-04 06:44:03.836+0000 [id=75]	INFO	jenkins.InitReactorRunner$1#onAttained: Prepared all plugins
2022-08-04 06:44:03.840+0000 [id=85]	INFO	jenkins.InitReactorRunner$1#onAttained: Started all plugins
2022-08-04 06:44:03.843+0000 [id=93]	INFO	jenkins.InitReactorRunner$1#onAttained: Augmented all extensions
2022-08-04 06:44:04.020+0000 [id=45]	INFO	jenkins.InitReactorRunner$1#onAttained: System config loaded
2022-08-04 06:44:04.021+0000 [id=64]	INFO	jenkins.InitReactorRunner$1#onAttained: System config adapted
2022-08-04 06:44:04.021+0000 [id=64]	INFO	jenkins.InitReactorRunner$1#onAttained: Loaded all jobs
2022-08-04 06:44:04.021+0000 [id=64]	INFO	jenkins.InitReactorRunner$1#onAttained: Configuration for all jobs updated
2022-08-04 06:44:04.030+0000 [id=106]	INFO	hudson.model.AsyncPeriodicWork#lambda$doRun$1: Started Download metadata
2022-08-04 06:44:04.033+0000 [id=106]	INFO	hudson.model.AsyncPeriodicWork#lambda$doRun$1: Finished Download metadata. 2 ms
2022-08-04 06:44:04.079+0000 [id=64]	INFO	jenkins.install.SetupWizard#init: 

*************************************************************
*************************************************************
*************************************************************

Jenkins initial setup is required. An admin user has been created and a password generated.
Please use the following password to proceed to installation:

6a743a8448ff4473b932bb22e9e2fab7

This may also be found at: /home/jegan/.jenkins/secrets/initialAdminPassword

*************************************************************
*************************************************************
*************************************************************

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.vmplugin.v7.Java7$1 (file:/home/jegan/.jenkins/war/WEB-INF/lib/groovy-all-2.4.21.jar) to constructor java.lang.invoke.MethodHandles$Lookup(java.lang.Class,int)
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.vmplugin.v7.Java7$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
2022-08-04 06:44:12.856+0000 [id=64]	INFO	jenkins.InitReactorRunner$1#onAttained: Completed initialization
2022-08-04 06:44:12.867+0000 [id=32]	INFO	hudson.lifecycle.Lifecycle#onReady: <b>Jenkins is fully up and running</b>
</pre>

## Accessing Jenkins Dashboard from the Web browser
```
http://localhost:8080
```

## Enable REST API 

<pre>
egan@dell-precision-7670:~$ sudo systemctl status docker
[sudo] password for jegan: 
● docker.service - Docker Application Container Engine
     Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
     Active: active (running) since Wed 2022-08-03 14:16:49 IST; 23h ago
TriggeredBy: ● docker.socket
       Docs: https://docs.docker.com
   Main PID: 2694 (dockerd)
      Tasks: 122
     Memory: 150.8M
     CGroup: /system.slice/docker.service
             ├─ 2694 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
             ├─ 5152 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 8001 -container-ip 172>
             ├─ 5160 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 8001 -container-ip 172.17.0>
             ├─ 5174 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 2001 -container-ip 172>
             ├─ 5182 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 2001 -container-ip 172.17.0>
             ├─11134 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 8002 -container-ip 172>
             ├─11140 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 8002 -container-ip 172.17.0>
             ├─11152 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 2002 -container-ip 172>
             ├─11159 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 2002 -container-ip 172.17.0>
             ├─21027 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 8082 -container-ip 172>
             ├─21034 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 8082 -container-ip 172.17.0>
             ├─21049 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 8081 -container-ip 172>
             └─21056 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 8081 -container-ip 172.17.0>

Aug 03 14:16:49 dell-precision-7670 dockerd[2694]: time="2022-08-03T14:16:49.447719232+05:30" level=info>
Aug 03 14:16:49 dell-precision-7670 dockerd[2694]: time="2022-08-03T14:16:49.464505680+05:30" level=info>
Aug 03 14:16:49 dell-precision-7670 dockerd[2694]: time="2022-08-03T14:16:49.488189167+05:30" level=info>
Aug 03 14:16:49 dell-precision-7670 dockerd[2694]: time="2022-08-03T14:16:49.488373990+05:30" level=info>
Aug 03 14:16:49 dell-precision-7670 systemd[1]: Started Docker Application Container Engine.
jegan@dell-precision-7670:~$ sudo vim /lib/systemd/system/docker.service
jegan@dell-precision-7670:~$ sudo systemctl daemon-reload
jegan@dell-precision-7670:~$ sudo systemctl restart docker
jegan@dell-precision-7670:~$ sudo systemctl status docker
● docker.service - Docker Application Container Engine
     Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
     Active: active (running) since Thu 2022-08-04 14:07:15 IST; 14s ago
TriggeredBy: ● docker.socket
       Docs: https://docs.docker.com
   Main PID: 77609 (dockerd)
      Tasks: 29
     Memory: 34.2M
     CGroup: /system.slice/docker.service
             └─77609 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock -H tcp://0.0.0.0:4243

Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.438382334+05:30" level=warning msg="Your kernel >
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.438416511+05:30" level=warning msg="Your kernel >
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.438608756+05:30" level=info msg="Loading contain>
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.552205957+05:30" level=info msg="Default bridge >
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.592581542+05:30" level=info msg="Loading contain>
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.605436265+05:30" level=info msg="Docker daemon" >
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.605504250+05:30" level=info msg="Daemon has comp>
Aug 04 14:07:15 dell-precision-7670 systemd[1]: Started Docker Application Container Engine.
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.626278899+05:30" level=info msg="API listen on />
Aug 04 14:07:15 dell-precision-7670 dockerd[77609]: time="2022-08-04T14:07:15.633905144+05:30" level=info msg="API listen on [>
</pre>
