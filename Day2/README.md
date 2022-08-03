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
- depends on Container Runtimes to manage Containers
  - create containers
  - listing containers
  - deleting containers
  - getting inside a container
  - start/stop/restarting containers
- used by end-users
- end-users don't tend to use Container Runtime directly as they are low-level
- Containers engines depends on other tools to manage Container Images
   - Skopio
   - Buildah

## What is a Container Runtime?
- are used by Container Engines
- Container Runtimes aren't used by end-users
- For example
    - runc is the Container Runtime used by Docker Container Engine

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
- softwares can be installed and configured on the image level, when containers are created out of an image, the container will have all the tools pre-installed on the image
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
[jegan@tektutor ~]$ <b>docker rm optimistic_galois</b>
optimistic_galois
[jegan@tektutor ~]$ <b>docker ps -a</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS                      PORTS                                                           NAMES
768963fc1186   ubuntu:18.04                                     "/bin/bash"              7 minutes ago    Up 7 minutes                                                                                ubuntu4
b1936251f773   ubuntu:18.04                                     "/bin/bash"              7 minutes ago    Up 7 minutes                                                                                ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              7 minutes ago    Up 7 minutes                                                                                ubuntu2
70b16768a7d7   ubuntu:18.04                                     "/bin/bash"              13 minutes ago   Up 7 minutes   
</pre>

## ⛹️‍♀️ Lab - Deleting a running container graciously

Before removing a running container, it must be stopped to gracefully terminate it.
```
docker rm ubuntu1
docker stop ubuntu1
docker rm ubuntu1
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker rm ubuntu1</b>
Error response from daemon: You cannot remove a running container 70b16768a7d7d0e96c1e9a30efe9751de62148a2a10ab3b4e2ab101e463e80d7. Stop the container before attempting removal or force remove
[jegan@tektutor ~]$ <b>docker stop ubuntu1</b>
ubuntu1
[jegan@tektutor ~]$ <b>docker rm ubuntu1</b>
ubuntu1
</pre>

## ⛹️‍♂️ Lab - Deleting a running container forcibly
```
docker ps
docker rm -f ubuntu4
docker ps
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS          PORTS                                                           NAMES
768963fc1186   ubuntu:18.04                                     "/bin/bash"              23 minutes ago   Up 23 minutes                                                                   ubuntu4
b1936251f773   ubuntu:18.04                                     "/bin/bash"              23 minutes ago   Up 23 minutes                                                                   ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              23 minutes ago   Up 23 minutes                                                                   ubuntu2
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago     Up 4 hours      0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
[jegan@tektutor ~]$ <b>docker rm -f ubuntu4</b>
ubuntu4
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS          PORTS                                                           NAMES
b1936251f773   ubuntu:18.04                                     "/bin/bash"              23 minutes ago   Up 23 minutes                                                                   ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              23 minutes ago   Up 23 minutes                                                                   ubuntu2
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago     Up 4 hours      0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
</pre>

##  ⛹️‍♂️ Lab - Starting, Stopping, Restart and deleting multiple containers at one shot
<pre>
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS          PORTS                                                           NAMES
b1936251f773   ubuntu:18.04                                     "/bin/bash"              29 minutes ago   Up 29 minutes                                                                   ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              29 minutes ago   Up 29 minutes                                                                   ubuntu2
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago     Up 4 hours      0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
[jegan@tektutor ~]$ <b>docker stop ubuntu2</b>
ubuntu2
[jegan@tektutor ~]$ <b>docker start ubuntu2</b>
ubuntu2
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS          PORTS                                                           NAMES
b1936251f773   ubuntu:18.04                                     "/bin/bash"              29 minutes ago   Up 29 minutes                                                                   ubuntu3
22554db319c7   ubuntu:18.04                                     "/bin/bash"              29 minutes ago   Up 7 seconds                                                                    ubuntu2
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago     Up 4 hours      0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
[jegan@tektutor ~]$ <b>docker stop ubuntu2 ubuntu3 artifactory</b>
ubuntu2
ubuntu3
artifactory
[jegan@tektutor ~]$ <b>docker start ubuntu2 ubuntu3 artifactory</b>
ubuntu2
ubuntu3
artifactory
[jegan@tektutor ~]$ <b>docker rm -f ubuntu2 ubuntu3</b> 
ubuntu2
ubuntu3
[jegan@tektutor ~]$ <b>docker ps -a</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED          STATUS                      PORTS                                                           NAMES
5bc5fdebc968   hello-world:latest                               "/hello"                 43 minutes ago   Exited (0) 43 minutes ago                                                                   happy_cannon
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago     Up 15 seconds               0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
[jegan@tektutor ~]$ <b>docker restart artifactory</b>
artifactory
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED        STATUS         PORTS                                                           NAMES
303ea4ccc524   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   21 hours ago   Up 4 seconds   0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp   artifactory
</pre>

## Renaming a container
```
docker rename <old-container-name> <new-container-name>
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE        COMMAND                  CREATED          STATUS          PORTS                               NAMES
2662c9ae5974   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 10 minutes   0.0.0.0:80->80/tcp, :::80->80/tcp   lb
37c22e33232f   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 12 minutes   80/tcp                              web3
cea4da8e9928   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 12 minutes   80/tcp                              web2
3e4dea5ae0e5   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 12 minutes   80/tcp                              web1
[jegan@tektutor ~]$ <b>docker rename web1 c1</b>
[jegan@tektutor ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE        COMMAND                  CREATED          STATUS          PORTS                               NAMES
2662c9ae5974   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 10 minutes   0.0.0.0:80->80/tcp, :::80->80/tcp   lb
37c22e33232f   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 12 minutes   80/tcp                              web3
cea4da8e9928   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 12 minutes   80/tcp                              web2
<b>3e4dea5ae0e5   nginx:1.18   "/docker-entrypoint.…"   12 minutes ago   Up 12 minutes   80/tcp                              c1</b>
</pre>

## ⛹️‍♂️ Lab - Finding IP Address of a container
```
docker inspect <container-name> | grep IPA
docker inspect -f {{.NetworkSettings.IPAddress}} <container-name>
```

Expected output
<pre>
[jegan@tektutor HelloMicroservice]$ <b>docker inspect c1 | grep IPA</b>
            "SecondaryIPAddresses": null,
            "IPAddress": "172.17.0.3",
                    "IPAMConfig": null,
                    "IPAddress": "172.17.0.3",
[jegan@tektutor HelloMicroservice]$ <b>docker inspect -f {{.NetworkSettings.IPAddress}} c1</b>
172.17.0.3
</pre>

## ⛹️‍♂️ Lab - Finding more details about an image
```
docker image inspect ubuntu:18.04
```

Expected output
<pre>
[jegan@tektutor HelloMicroservice]$ <b>docker image inspect ubuntu:18.04</b>
[
    {
        "Id": "sha256:8d5df41c547bd107c14368ad302efc46760940ae188df451cabc23e10f7f161b",
        "RepoTags": [
            "ubuntu:18.04"
        ],
        "RepoDigests": [
            "ubuntu@sha256:eb1392bbdde63147bc2b4ff1a4053dcfe6d15e4dfd3cce29e9b9f52a4f88bc74"
        ],
        "Parent": "",
        "Comment": "",
        "Created": "2022-08-02T01:30:42.983551684Z",
        "Container": "7ad563d9fd85ec26deaa0bc1af201857490eba43e7f9278b92197abd240b1023",
        "ContainerConfig": {
            "Hostname": "7ad563d9fd85",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
            ],
            "Cmd": [
                "/bin/sh",
                "-c",
                "#(nop) ",
                "CMD [\"bash\"]"
            ],
            "Image": "sha256:28f9af4b363b26946d747488a48a9c19743bd99d6737a248fbcf09f7aa6cfd06",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": null,
            "OnBuild": null,
            "Labels": {}
        },
        "DockerVersion": "20.10.12",
        "Author": "",
        "Config": {
            "Hostname": "",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
            ],
            "Cmd": [
                "bash"
            ],
            "Image": "sha256:28f9af4b363b26946d747488a48a9c19743bd99d6737a248fbcf09f7aa6cfd06",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": null,
            "OnBuild": null,
            "Labels": null
        },
        "Architecture": "amd64",
        "Os": "linux",
        "Size": 63148618,
        "VirtualSize": 63148618,
        "GraphDriver": {
            "Data": {
                "MergedDir": "/var/lib/docker/overlay2/1c4e8a3847c338866f58dfca516f59575c4c12c8bc4b5d86f80e4df4dd0e8fd3/merged",
                "UpperDir": "/var/lib/docker/overlay2/1c4e8a3847c338866f58dfca516f59575c4c12c8bc4b5d86f80e4df4dd0e8fd3/diff",
                "WorkDir": "/var/lib/docker/overlay2/1c4e8a3847c338866f58dfca516f59575c4c12c8bc4b5d86f80e4df4dd0e8fd3/work"
            },
            "Name": "overlay2"
        },
        "RootFS": {
            "Type": "layers",
            "Layers": [
                "sha256:e722d396f503c712107acad2a081b07e33e73d6286c43f58234f69345a216918"
            ]
        },
        "Metadata": {
            "LastTagTime": "0001-01-01T00:00:00Z"
        }
    }
]
</pre>


## Inspecting Docker image
```
docker image inspect mysql:latest
```

Expected output
<pre>
[jegan@tektutor HelloMicroservice]$ <b>docker image inspect mysql:latest</b>
[
    {
        "Id": "sha256:38643ad93215bedea00fedd3d6f2a1c8e1bff3b9a172aa2547fd8b4bac9cfee3",
        "RepoTags": [
            "mysql:latest"
        ],
        "RepoDigests": [
            "mysql@sha256:657d78ee56e09101902673adcdd7d2bf03012e759c1aa525eeca28cb0fe1aa7d"
        ],
        "Parent": "",
        "Comment": "",
        "Created": "2022-07-26T23:28:24.349951763Z",
        "Container": "bdf1c9abc813761d7d11e0d4e74f091f58b0f077312e4ade4699b4ad73cdca66",
        "ContainerConfig": {
            "Hostname": "bdf1c9abc813",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "ExposedPorts": {
                "3306/tcp": {},
                "33060/tcp": {}
            },
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin",
                "GOSU_VERSION=1.14",
                "MYSQL_MAJOR=8.0",
                "MYSQL_VERSION=8.0.30-1.el8",
                "MYSQL_SHELL_VERSION=8.0.30-1.el8"
            ],
            "Cmd": [
                "/bin/sh",
                "-c",
                "#(nop) ",
                "CMD [\"mysqld\"]"
            ],
            "Image": "sha256:aa0cb47c435de599c044982ae29bd34156d3337de910983ceb0ea99c319a0258",
            "Volumes": {
                "/var/lib/mysql": {}
            },
            "WorkingDir": "",
            "Entrypoint": [
                "docker-entrypoint.sh"
            ],
            "OnBuild": null,
            "Labels": {}
        },
        "DockerVersion": "20.10.12",
        "Author": "",
        "Config": {
            "Hostname": "",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "ExposedPorts": {
                "3306/tcp": {},
                "33060/tcp": {}
            },
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin",
                "GOSU_VERSION=1.14",
                "MYSQL_MAJOR=8.0",
                "MYSQL_VERSION=8.0.30-1.el8",
                "MYSQL_SHELL_VERSION=8.0.30-1.el8"
            ],
            "Cmd": [
                "mysqld"
            ],
            "Image": "sha256:aa0cb47c435de599c044982ae29bd34156d3337de910983ceb0ea99c319a0258",
            "Volumes": {
                "/var/lib/mysql": {}
            },
            "WorkingDir": "",
            "Entrypoint": [
                "docker-entrypoint.sh"
            ],
            "OnBuild": null,
            "Labels": null
        },
        "Architecture": "amd64",
        "Os": "linux",
        "Size": 445868578,
        "VirtualSize": 445868578,
        "GraphDriver": {
            "Data": {
                "LowerDir": "/var/lib/docker/overlay2/78f3d03f65722281f758659652e0b86809e688876d453e1d6647265deb6cb645/diff:/var/lib/docker/overlay2/51741cb55e20c29ddb9ff2b5e084c203513172f033898ea63ba186ee0d6c4c9f/diff:/var/lib/docker/overlay2/90da5a4ed9d2b9a63aa76e002423a01c3e9b76fd81811af7758ca2b9e5cfe5d6/diff:/var/lib/docker/overlay2/793902f6ec5c71606ebf1ce8c667b4cc9a56422b80931dc1a6888e9d6a707f00/diff:/var/lib/docker/overlay2/999c81fedfd11e7651de817b7a17a98420cfb5fb023c73cab83524ae5aa54726/diff:/var/lib/docker/overlay2/5ca9cdbb705a8e84641ef1831a6a4fe2e223a8da53d6fc81465ed35ba5823bda/diff:/var/lib/docker/overlay2/85fa8368062fbe50589bfee7d4e3a11a0b3d31eca89c3dc0cc24315d01418ef1/diff:/var/lib/docker/overlay2/04d1930a71017acbcb8fd0348ad04a618f0088354f2ecc4c393b62bbade8490f/diff:/var/lib/docker/overlay2/62457be2b5f49a19792fd24042999487c548741fc14245aa73368e4bffcb8e48/diff:/var/lib/docker/overlay2/a0b1e0f0a27e827546de090a565d0c4b32122ace1a574ef4302ca8d48d96ffec/diff",
                "MergedDir": "/var/lib/docker/overlay2/cd28a97bc57bd291cd6caf29aa1497996e88a59763f771086d50b74971bcae9a/merged",
                "UpperDir": "/var/lib/docker/overlay2/cd28a97bc57bd291cd6caf29aa1497996e88a59763f771086d50b74971bcae9a/diff",
                "WorkDir": "/var/lib/docker/overlay2/cd28a97bc57bd291cd6caf29aa1497996e88a59763f771086d50b74971bcae9a/work"
            },
            "Name": "overlay2"
        },
        "RootFS": {
            "Type": "layers",
            "Layers": [
                "sha256:c6c89a36c214d7ecf7a684bf0fc21692dd60e9f204f48545bcb4085185166031",
                "sha256:27df4ae8cdd9b83162d2a091252cc501f5912e1216a0c17cb6003f96904e7346",
                "sha256:f1ea503194624aa88fe65e3477e718c0168886e03f068860b05a0d909664e0f2",
                "sha256:c1b9bd4130df3ccc44775da7aaff3cc0cc589cb5b1c908d0c0387e4d693d2900",
                "sha256:ea8b5bae0f85ad480602e1945751771fe172201343ef48538f291a3fc31e53dc",
                "sha256:67b3775b94c39f22490ee81a7a3996ba1ea1759bf9a87179ff33d81836eaa3b7",
                "sha256:c8afeb9d103a9d4b17814c462873ea98f62fb414ce729fb2b9e2fa46d2160d86",
                "sha256:1b66587ddfd35f9e449a5a40dfc35251c3edb782bc12188930716c0771f7b71c",
                "sha256:f9ca9ccb47475dc86b6522ca80fa791c93e4eeffa07cec634d6e6227ebff523c",
                "sha256:718fb5cbcfce12cb4bcb806f737a38f4f4c74321f39dee93fa13f4d56e8418af",
                "sha256:7c43f0f6582c03741ddd930049a68a18bae7275867241a8092ebac7dda04888e"
            ]
        },
        "Metadata": {
            "LastTagTime": "0001-01-01T00:00:00Z"
        }
    }
]
</pre>

## Creating a mysql db container
```
docker run -d --name db --hostname db -e MYSQL_ROOT_PASSWORD=root mysql:latest
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker run -d --name db --hostname db -e MYSQL_ROOT_PASSWORD=root mysql:latest</b>
c88dcd3b73d1a4904b97a23fe82dca4c5f6cbb632101493de7e2f2c8dd68abc8
</pre>


### ⛹️‍♀️ Lab - Getting inside the mysql db container and connecting to mysql prompt
When it prompts for password, type 'root' without quotes.
```
docker exec -it db /bin/sh
mysql -u root -p

SHOW DATABASES;
CREATE DATABASE tektutor;
USE tektutor;
CREATE TABLE training ( id int, name VARCHAR(50), duration VARCHAR(50) );

INSERT INTO TABLE training VALUES ( 1, "DevOps", "5 Days" );
INSERT INTO training VALUES ( 2, "Microservices with Python", "5 Days" );
INSERT INTO training VALUES ( 3, "Advanced Scala Programming", "5 Days" );

SELECT * FROM training;
```

Expected output
<pre>
[jegan@tektutor ~]$ <b>docker run -d --name db --hostname db -e MYSQL_ROOT_PASSWORD=root mysql:latest</b>
c88dcd3b73d1a4904b97a23fe82dca4c5f6cbb632101493de7e2f2c8dd68abc8
[jegan@tektutor ~]$ <b>docker exec -it db /bin/sh</b>
sh-4.4# <b>mysql -u root -p</b>
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.30 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> <b>SHOW DATABASES;</b>
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.01 sec)

mysql> <b>CREATE DATABASE tektutor;</b>
Query OK, 1 row affected (0.01 sec)

mysql> <b>USE tektutor;</b>
Database changed
mysql> <b>CREATE TABlE training ( id int, name VARCHAR(50), duration VARCHAR(50) );</b>
Query OK, 0 rows affected (0.03 sec)

mysql> <b>INSERT INTO training VALUES ( 1, "DevOps", "5 Days" );</b>
Query OK, 1 row affected (0.01 sec)

mysql> <b>INSERT INTO training VALUES ( 2, "Microservices with Python", "5 Days" );</b>
Query OK, 1 row affected (0.00 sec)

mysql> <b>INSERT INTO training VALUES ( 3, "Advanced Scala Programming", "5 Days" );</b>
Query OK, 1 row affected (0.00 sec)

mysql> <b>SELECT * FROM training;</b>
+------+----------------------------+----------+
| id   | name                       | duration |
+------+----------------------------+----------+
|    1 | DevOps                     | 5 Days   |
|    2 | Microservices with Python  | 5 Days   |
|    3 | Advanced Scala Programming | 5 Days   |
+------+----------------------------+----------+
3 rows in set (0.00 sec)

mysql> <b>exit</b>
Bye
sh-4.4# <b>exit</b>
exit
</pre>

## Externally storing data using Volume Mounting
<pre>
[jegan@tektutor ~]$ <b>docker run -d --name db --hostname db -e MYSQL_ROOT_PASSWORD=root -v /tmp/mysql:/var/lib/mysql mysql:latest</b>
541fdd3499be05f521aa4e69e246ef4106377d66ebac66ca7ebbfa303c136d4c
[jegan@tektutor ~]$ <b>docker exec -it db sh</b>
sh-4.4# <b>mysql -u root -p</b>
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.30 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> <b>SHOW DATABASES;</b>
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| tektutor           |
+--------------------+
5 rows in set (0.01 sec)

mysql> USE tektutor;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> <b>SELECT * FROM training;</b>
+------+--------+----------+
| id   | name   | duration |
+------+--------+----------+
|    1 | DevOps | 5 Days   |
+------+--------+----------+
1 row in set (0.00 sec)

mysql> <b>exit</b>
Bye
sh-4.4# <b>exit</b>
exit
</pre>

## ⛹️‍♂️ Lab - Port Forwading - Setting up a LoadBalancer using nginx
```
docker run -d --name web1 --hostname web1 nginx:1.18
docker run -d --name web2 --hostname web2 nginx:1.18
docker run -d --name web3 --hostname web3 nginx:1.18

docker run -d --name lb --hostname lb -p 80:80 nginx:1.18
```

Let's customize the web1, web2 and web3 html pages
```
echo "Server 1" > index.html
docker cp index.html web1:/usr/share/nginx/html/index.html

echo "Server 2" > index.html
docker cp index.html web2:/usr/share/nginx/html/index.html

echo "Server 3" > index.html
docker cp index.html web3:/usr/share/nginx/html/index.html
```

Let's configure the lb container to work like a Load balancer

Let's create a nginx.conf file with the below content
<pre>
error_log  /var/log/nginx/error.log notice;
pid        /var/run/nginx.pid;

events {
    worker_connections  1024;
}

http {
    upstream servers {
        server  172.17.0.2:80;
        server  172.17.0.3:80;
        server  172.17.0.4:80;
    }
    server {
        location / {
            proxy_pass http://servers;
        }
    }
}
</pre>

In the above file, 
<pre>
172.17.0.2 - is the IP Address of my web1 nginx container
172.17.0.3 - is the IP Address of my web2 nginx container
172.17.0.4 - is the IP Address of my web3 nginx container
</pre>

You may to replace those IP with your web1, web2 and web3 containers respectively.

Let's copy the load balancer configuration into the lb container
```
docker cp nginx.conf lb:/etc/nginx/nginx.conf
```

Let's restart lb container to apply the lb config changes
```
docker restart lb
```

See if the lb container is up and running post the config changes
```
docker ps
```

Now you may test the lb setup
```
curl localhost
curl localhost
curl localhost
```

Each time, you curl localhost, you will get output coming from web1,web2 and web3 in a round-robin fashion.  You may also try substituing the localhost with your RPS Lab machine IP Address from the web browser.
