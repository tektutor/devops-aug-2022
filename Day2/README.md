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

## Listing docker images from Local docker registry
```
docker images
```

## Downloading image from Docker Hub website to Local Docker Registry
```
docker pull hello-world:latest
```
