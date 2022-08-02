# Day2

## Hypervisor Overview
- is nothing but Virtualization Technology
- virtualization is a Hardware + Software Technology
- Processor
  - AMD ( x86-64 bit General Purpose Processor )
    - AMD-V is the Virtualization Feature
  - Intel ( x86-64 bit General Purpose Processor )
    - VT-X is the Virtualization Feature
- Two types of Hypervisors are there
  1. Type 1
     - Bare Metal Hypervisor
     - meant for Servers/Workstations
     - they don't require OS to install this type of Hypervisor
  2. Type 2
     - For laptops, desktops and Workstations
     - can only be installed on top of Host OS ( Windows, Unix, Linux & Mac OS-X )
- Hypervisor Products
  VMWARE
    - VMWARE Fusion ( Mac OS ) - Type 2
    - VMWare Workstation ( Windows & Linux ) - Type 2
    - VMWare vSphere - Type 1 Hypervisor
  Oracle
    - VirtualBox ( Windows, Linux & Mac OSX ) - Type 2
  Parallels (Mac OSX ) - Type 2
  Microsoft
    - Hyper-V ( Windows - Type 2 )

## Processor

### SCM ( Single Chip Module)
- Single IC ( Integrated Circuit )
  will have one Processor with one or multiple cores

### MCM ( Multiple Chip Module )
- Single IC ( Integrated Circuit )
  will have many Processors with one or multiple cores

### Hyperthreading
- One Physical CPU Core acts like 2 Virtual Cores

## Containers
- application virtualization
- Containers are not Operating System, they are application process
- containers don't get dedicated hardwares unlike Virtual Machines
- containers don't have their own OS Kernel unlike Virtual Machines
- containers appear like a Virtual Machine, but technically they are mere application process
- containers have their own Network Stack and Virtual Network Cards
- containers has their own IP address
- containers have their own file system
- containers are very lightweight compared to Operating System running in Physical or Virtual Machines
- Examples
    - LXC
    - Rkt ( pronounced as Rocket )
    - Docker
    - Podman
    
## What is a Container Engine?
- For example - Podman/Docker they are Container Engines
- Container Engines provide high-level user-friendly commands to create and manage containers
- end-users need not have to know know low-level kernel knowledge to manage containers
- depends Container Runtimes to manage Containers
  - create containers
  - listing containers
  - deleting containers
  - getting inside a container
  - start/stop/restarting containers
- used by end-users
- end-users don't tend to use Container Runtimes directly as they are low-level
- Containers engines depends on other tools to manage Container Images
   - Skopio
   - Buildah

## What is a Container Runtime?
- are used by Container Engines
- Container Runtimes aren't used by end-users
## Docker Overview
- is a Container Engine developed by Docker Inc organization 
- is developed using Google Go programming language
- Docker Engine depends on runc Container Runtime

## Container
- has one application along with all its dependent libraries
- recommended practice - one appliation per container
- is an instance of Container Image
- Developer point of view - like an object created from a Class

## Container Image
- a blueprint of running container
- software can be installed and configured on the image level, when containers are created out of an image, the container will have all the tools pre-installed on the image
- image is like an ISO OS Image
- Developer point of view, it is like a Class

## Installing Docker Community Edition in CentOS 7.x
Docker is already installed on our lab machine, hence this is purely meant for your future reference purpose only.

```
sudo yum install -y yum-utils
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install docker-ce docker-ce-cli containerd.io docker-compose-plugin
sudo systemctl enable docker
sudo systemctl start docker
```

## ⛹️‍♀️ Lab - Testing if docker is installed properly, please try this in your lab machine
```
docker version
docker images
```

## ⛹️‍♀️ Lab - Troubleshooting docker permission denied error, please try this in your lab machine
When it prompts for password, please type rps@12345
```
sudo usermod -aG docker $USER
newgrp docker
docker images
```

## ⛹️‍♂️ Lab - Listing docker images from Local docker registry
```
docker images
```

## ⛹️ Lab - Downloading image from Docker Hub website to Local Docker Registry
```
docker pull hello-world:latest
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker pull hello-world:latest</b>
latest: Pulling from library/hello-world
2db29710123e: Pull complete 
Digest: sha256:53f1bbee2f52c39e41682ee1d388285290c5c8a76cc92b42687eecf38e0af3f0
Status: Downloaded newer image for hello-world:latest
docker.io/library/hello-world:latest
[jegan@tektutor ~]$ <b>docker images</b>
REPOSITORY                                TAG       IMAGE ID       CREATED         SIZE
docker.bintray.io/jfrog/artifactory-oss   latest    031acd2d33c7   3 weeks ago     1.19GB
<b>hello-world                               latest    feb5d9fea6a5   10 months ago   13.3kB</b>
</pre>

## ⛹️‍♂️ Lab - Creating your first container
```
docker run hello-world:latest
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker run hello-world:latest</b>

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
</pre>


## ⛹️‍♀️ Lab - Creating an ubuntu container in interactive(foreground) mode
```
docker run -it --name ubuntu1 --hostname ubuntu1 ubuntu:18.04 /bin/bash
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker run -it --name ubuntu1 --hostname ubuntu1 ubuntu:18.04 /bin/bash</b>
Unable to find image 'ubuntu:18.04' locally
18.04: Pulling from library/ubuntu
22c5ef60a68e: Pull complete 
Digest: sha256:eb1392bbdde63147bc2b4ff1a4053dcfe6d15e4dfd3cce29e9b9f52a4f88bc74
Status: Downloaded newer image for ubuntu:18.04
root@ubuntu1:/# <b>ls</b>
bin  boot  dev  etc  home  lib  lib64  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
root@ubuntu1:/# <b>hostname</b>
ubuntu1
root@ubuntu1:/# <b>hostname -i</b>
172.17.0.3
root@ubuntu1:/# <b>exit</b>
exit
</pre>

## ⛹️‍♂️ Lab - Creating containers in background(deattached/daemon) mode
```
docker run -dit --name ubuntu2 --hostname ubuntu2 ubuntu:18.04 /bin/bash
docker run -dit --name ubuntu3 --hostname ubuntu2 ubuntu:18.04 /bin/bash
docker run -dit --name ubuntu4 --hostname ubuntu2 ubuntu:18.04 /bin/bash
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker run -dit --name ubuntu2 --hostname ubuntu2 ubuntu:18.04 /bin/bash</b>
22554db319c72880227227162f6772c5d0c9fdd3ef4750fcc5922c0d9dc36b9d
[jegan@tektutor ~]$ <b>docker run -dit --name ubuntu3 --hostname ubuntu3 ubuntu:18.04 /bin/bash</b>
b1936251f773e0bb9f543507deb300567abd3877483061d106504eba9248af44
[[A[jegan@tektutor ~]$ <b>docker run -dit --name ubuntu4 --hostname ubuntu4 ubuntu:18.04 /bin/bash</b>
768963fc1186d0f9191b60832168a160f177de5c102abe3d9cd38b093d3c026d
</pre>

#### ⛹️‍♀️ Lab - Listing the currently running containers
```
docker start ubuntu1
docker ps
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker start ubuntu1</b>
ubuntu1
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS                      PORTS                                                           NAMES
768963fc1186   ubuntu:18.04                                     "/bin/bash"              26 seconds ago   Up 25 seconds                                                                               ubuntu4
b1936251f773   ubuntu:18.04                                     "/bin/bash"              32 seconds ago   Up 31 seconds                                                                               ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              39 seconds ago   Up 38 seconds                                                                               ubuntu2
70b16768a7d7   ubuntu:18.04                                     "/bin/bash"              6 minutes ago    Up 1 second                                                                                   ubuntu1
</pre>


## ⛹️‍♂️ Lab - Deleting an exited container 
```
docker rm <container-id>
docker rm <container-name>
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker ps -a</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS                      PORTS                                                           NAMES
a1d065f81a3b   ubuntu:18.04                                     "bash"                   8 seconds ago    Exited (0) 7 seconds ago                                                                    optimistic_galois
768963fc1186   ubuntu:18.04                                     "/bin/bash"              6 minutes ago    Up 6 minutes                                                                                ubuntu4
b1936251f773   ubuntu:18.04                                     "/bin/bash"              6 minutes ago    Up 6 minutes                                                                                ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              6 minutes ago    Up 6 minutes                                                                                ubuntu2
70b16768a7d7   ubuntu:18.04                                     "/bin/bash"              12 minutes ago   Up 6 minutes                                                                                ubuntu1
5bc5fdebc968   hello-world:latest                               "/hello"                 20 minutes ago   Exited (0) 20 minutes ago                                                                   happy_cannon
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago     Up 3 hours                  0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
[jegan@tektutor ~]$ docker rm optimistic_galois
optimistic_galois
[jegan@tektutor ~]$ <b>docker ps -a</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS                      PORTS                                                           NAMES
768963fc1186   ubuntu:18.04                                     "/bin/bash"              7 minutes ago    Up 7 minutes                                                                                ubuntu4
b1936251f773   ubuntu:18.04                                     "/bin/bash"              7 minutes ago    Up 7 minutes                                                                                ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              7 minutes ago    Up 7 minutes                                                                                ubuntu2
70b16768a7d7   ubuntu:18.04                                     "/bin/bash"              13 minutes ago   Up 7 minutes   
</pre>
