# Day3

## Installing Ansible Core
```
sudo apt install python3-pip
pip3 --version
pip3 install ansible
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022$ <b>sudo apt install python3-pip</b>
[sudo] password for jegan: 
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following additional packages will be installed:
  build-essential g++ g++-9 libc-dev-bin libc6-dev libcrypt-dev libexpat1-dev libpython3-dev libpython3.8-dev libstdc++-9-dev
  linux-libc-dev manpages-dev python-pip-whl python3-dev python3-setuptools python3-wheel python3.8-dev zlib1g-dev
Suggested packages:
  g++-multilib g++-9-multilib gcc-9-doc glibc-doc libstdc++-9-doc python-setuptools-doc
The following NEW packages will be installed:
  build-essential g++ g++-9 libc-dev-bin libc6-dev libcrypt-dev libexpat1-dev libpython3-dev libpython3.8-dev libstdc++-9-dev
  linux-libc-dev manpages-dev python-pip-whl python3-dev python3-pip python3-setuptools python3-wheel python3.8-dev
  zlib1g-dev
0 upgraded, 19 newly installed, 0 to remove and 14 not upgraded.
Need to get 23.3 MB of archives.
After this operation, 104 MB of additional disk space will be used.
Do you want to continue? [Y/n] Y
Get:1 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 libc-dev-bin amd64 2.31-0ubuntu9.9 [71.8 kB]
Get:2 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 linux-libc-dev amd64 5.4.0-122.138 [1,105 kB]
Get:3 http://archive.ubuntu.com/ubuntu focal/main amd64 libcrypt-dev amd64 1:4.4.10-10ubuntu4 [104 kB]
Get:4 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 libc6-dev amd64 2.31-0ubuntu9.9 [2,519 kB]
Get:5 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 libstdc++-9-dev amd64 9.4.0-1ubuntu1~20.04.1 [1,722 kB]
Get:6 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 g++-9 amd64 9.4.0-1ubuntu1~20.04.1 [8,420 kB]
Get:7 http://archive.ubuntu.com/ubuntu focal/main amd64 g++ amd64 4:9.3.0-1ubuntu2 [1,604 B]
Get:8 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 build-essential amd64 12.8ubuntu1.1 [4,664 B]
Get:9 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 libexpat1-dev amd64 2.2.9-1ubuntu0.4 [117 kB]
Get:10 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 libpython3.8-dev amd64 3.8.10-0ubuntu1~20.04.5 [3,951 kB]
Get:11 http://archive.ubuntu.com/ubuntu focal/main amd64 libpython3-dev amd64 3.8.2-0ubuntu2 [7,236 B]
Get:12 http://archive.ubuntu.com/ubuntu focal/main amd64 manpages-dev all 5.05-1 [2,266 kB]
Get:13 http://archive.ubuntu.com/ubuntu focal-updates/universe amd64 python-pip-whl all 20.0.2-5ubuntu1.6 [1,805 kB]
Get:14 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 zlib1g-dev amd64 1:1.2.11.dfsg-2ubuntu1.3 [155 kB]
Get:15 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 python3.8-dev amd64 3.8.10-0ubuntu1~20.04.5 [514 kB]
Get:16 http://archive.ubuntu.com/ubuntu focal/main amd64 python3-dev amd64 3.8.2-0ubuntu2 [1,212 B]
Get:17 http://archive.ubuntu.com/ubuntu focal/main amd64 python3-setuptools all 45.2.0-1 [330 kB]
Get:18 http://archive.ubuntu.com/ubuntu focal/universe amd64 python3-wheel all 0.34.2-1 [23.8 kB]
Get:19 http://archive.ubuntu.com/ubuntu focal-updates/universe amd64 python3-pip all 20.0.2-5ubuntu1.6 [231 kB]
Fetched 23.3 MB in 4s (6,395 kB/s)    
Selecting previously unselected package libc-dev-bin.
(Reading database ... 192125 files and directories currently installed.)
Preparing to unpack .../00-libc-dev-bin_2.31-0ubuntu9.9_amd64.deb ...
Unpacking libc-dev-bin (2.31-0ubuntu9.9) ...
Selecting previously unselected package linux-libc-dev:amd64.
Preparing to unpack .../01-linux-libc-dev_5.4.0-122.138_amd64.deb ...
Unpacking linux-libc-dev:amd64 (5.4.0-122.138) ...
Selecting previously unselected package libcrypt-dev:amd64.
Preparing to unpack .../02-libcrypt-dev_1%3a4.4.10-10ubuntu4_amd64.deb ...
Unpacking libcrypt-dev:amd64 (1:4.4.10-10ubuntu4) ...
Selecting previously unselected package libc6-dev:amd64.
Preparing to unpack .../03-libc6-dev_2.31-0ubuntu9.9_amd64.deb ...
Unpacking libc6-dev:amd64 (2.31-0ubuntu9.9) ...
Selecting previously unselected package libstdc++-9-dev:amd64.
Preparing to unpack .../04-libstdc++-9-dev_9.4.0-1ubuntu1~20.04.1_amd64.deb ...
Unpacking libstdc++-9-dev:amd64 (9.4.0-1ubuntu1~20.04.1) ...
Selecting previously unselected package g++-9.
Preparing to unpack .../05-g++-9_9.4.0-1ubuntu1~20.04.1_amd64.deb ...
Unpacking g++-9 (9.4.0-1ubuntu1~20.04.1) ...
Selecting previously unselected package g++.
Preparing to unpack .../06-g++_4%3a9.3.0-1ubuntu2_amd64.deb ...
Unpacking g++ (4:9.3.0-1ubuntu2) ...
Selecting previously unselected package build-essential.
Preparing to unpack .../07-build-essential_12.8ubuntu1.1_amd64.deb ...
Unpacking build-essential (12.8ubuntu1.1) ...
Selecting previously unselected package libexpat1-dev:amd64.
Preparing to unpack .../08-libexpat1-dev_2.2.9-1ubuntu0.4_amd64.deb ...
Unpacking libexpat1-dev:amd64 (2.2.9-1ubuntu0.4) ...
Selecting previously unselected package libpython3.8-dev:amd64.
Preparing to unpack .../09-libpython3.8-dev_3.8.10-0ubuntu1~20.04.5_amd64.deb ...
Unpacking libpython3.8-dev:amd64 (3.8.10-0ubuntu1~20.04.5) ...
Selecting previously unselected package libpython3-dev:amd64.
Preparing to unpack .../10-libpython3-dev_3.8.2-0ubuntu2_amd64.deb ...
Unpacking libpython3-dev:amd64 (3.8.2-0ubuntu2) ...
Selecting previously unselected package manpages-dev.
Preparing to unpack .../11-manpages-dev_5.05-1_all.deb ...
Unpacking manpages-dev (5.05-1) ...
Selecting previously unselected package python-pip-whl.
Preparing to unpack .../12-python-pip-whl_20.0.2-5ubuntu1.6_all.deb ...
Unpacking python-pip-whl (20.0.2-5ubuntu1.6) ...
Selecting previously unselected package zlib1g-dev:amd64.
Preparing to unpack .../13-zlib1g-dev_1%3a1.2.11.dfsg-2ubuntu1.3_amd64.deb ...
Unpacking zlib1g-dev:amd64 (1:1.2.11.dfsg-2ubuntu1.3) ...
Selecting previously unselected package python3.8-dev.
Preparing to unpack .../14-python3.8-dev_3.8.10-0ubuntu1~20.04.5_amd64.deb ...
Unpacking python3.8-dev (3.8.10-0ubuntu1~20.04.5) ...
Selecting previously unselected package python3-dev.
Preparing to unpack .../15-python3-dev_3.8.2-0ubuntu2_amd64.deb ...
Unpacking python3-dev (3.8.2-0ubuntu2) ...
Selecting previously unselected package python3-setuptools.
Preparing to unpack .../16-python3-setuptools_45.2.0-1_all.deb ...
Unpacking python3-setuptools (45.2.0-1) ...
Selecting previously unselected package python3-wheel.
Preparing to unpack .../17-python3-wheel_0.34.2-1_all.deb ...
Unpacking python3-wheel (0.34.2-1) ...
Selecting previously unselected package python3-pip.
Preparing to unpack .../18-python3-pip_20.0.2-5ubuntu1.6_all.deb ...
Unpacking python3-pip (20.0.2-5ubuntu1.6) ...
Setting up manpages-dev (5.05-1) ...
Setting up python3-setuptools (45.2.0-1) ...
Setting up linux-libc-dev:amd64 (5.4.0-122.138) ...
Setting up python3-wheel (0.34.2-1) ...
Setting up libcrypt-dev:amd64 (1:4.4.10-10ubuntu4) ...
Setting up python-pip-whl (20.0.2-5ubuntu1.6) ...
Setting up libc-dev-bin (2.31-0ubuntu9.9) ...
Setting up python3-pip (20.0.2-5ubuntu1.6) ...
Setting up libc6-dev:amd64 (2.31-0ubuntu9.9) ...
Setting up libstdc++-9-dev:amd64 (9.4.0-1ubuntu1~20.04.1) ...
Setting up libexpat1-dev:amd64 (2.2.9-1ubuntu0.4) ...
Setting up libpython3.8-dev:amd64 (3.8.10-0ubuntu1~20.04.5) ...
Setting up g++-9 (9.4.0-1ubuntu1~20.04.1) ...
Setting up zlib1g-dev:amd64 (1:1.2.11.dfsg-2ubuntu1.3) ...
Setting up g++ (4:9.3.0-1ubuntu2) ...
update-alternatives: using /usr/bin/g++ to provide /usr/bin/c++ (c++) in auto mode
Setting up build-essential (12.8ubuntu1.1) ...
Setting up libpython3-dev:amd64 (3.8.2-0ubuntu2) ...
Setting up python3.8-dev (3.8.10-0ubuntu1~20.04.5) ...
Setting up python3-dev (3.8.2-0ubuntu2) ...
Processing triggers for man-db (2.9.1-1) ...
jegan@dell-precision-7670:~/devops-aug-2022$ <b>pip3 --version</b>
pip 20.0.2 from /usr/lib/python3/dist-packages/pip (python 3.8)
jegan@dell-precision-7670:~/devops-aug-2022$ <b>pip3 install ansible</b>
Collecting ansible
  Downloading ansible-6.1.0-py3-none-any.whl (40.5 MB)
     |████████████████████████████████| 40.5 MB 9.7 MB/s 
Collecting ansible-core~=2.13.1
  Downloading ansible_core-2.13.2-py3-none-any.whl (2.1 MB)
     |████████████████████████████████| 2.1 MB 7.6 MB/s 
Requirement already satisfied: cryptography in /usr/lib/python3/dist-packages (from ansible-core~=2.13.1->ansible) (2.8)
Collecting resolvelib<0.9.0,>=0.5.3
  Downloading resolvelib-0.8.1-py2.py3-none-any.whl (16 kB)
Collecting packaging
  Downloading packaging-21.3-py3-none-any.whl (40 kB)
     |████████████████████████████████| 40 kB 4.9 MB/s 
Collecting jinja2>=3.0.0
  Downloading Jinja2-3.1.2-py3-none-any.whl (133 kB)
     |████████████████████████████████| 133 kB 9.2 MB/s 
Requirement already satisfied: PyYAML>=5.1 in /usr/lib/python3/dist-packages (from ansible-core~=2.13.1->ansible) (5.3.1)
Collecting pyparsing!=3.0.5,>=2.0.2
  Downloading pyparsing-3.0.9-py3-none-any.whl (98 kB)
     |████████████████████████████████| 98 kB 7.4 MB/s 
Collecting MarkupSafe>=2.0
  Downloading MarkupSafe-2.1.1-cp38-cp38-manylinux_2_17_x86_64.manylinux2014_x86_64.whl (25 kB)
Installing collected packages: resolvelib, pyparsing, packaging, MarkupSafe, jinja2, ansible-core, ansible
  WARNING: The scripts ansible, ansible-config, ansible-connection, ansible-console, ansible-doc, ansible-galaxy, ansible-inventory, ansible-playbook, ansible-pull and ansible-vault are installed in '/home/jegan/.local/bin' which is not on PATH.
  Consider adding this directory to PATH or, if you prefer to suppress this warning, use --no-warn-script-location.
  WARNING: The script ansible-community is installed in '/home/jegan/.local/bin' which is not on PATH.
  Consider adding this directory to PATH or, if you prefer to suppress this warning, use --no-warn-script-location.
Successfully installed MarkupSafe-2.1.1 ansible-6.1.0 ansible-core-2.13.2 jinja2-3.1.2 packaging-21.3 pyparsing-3.0.9 resolvelib-0.8.1
</pre>

### Exporting Ansible path into environment settings
Make sure you edit ~/.bashrc file and export Ansible path as shown below
```
export JDK_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export M2_HOME=/home/jegan/Downloads/apache-maven-3.8.6
export PATH=/home/jegan/.local/bin:$JDK_HOME/bin:$M2_HOME/bin:$PATH
```

You need to run the ~/.bashrc to apply the newly exported PATH
```
source ~/.bashrc
```

### Check the version of Ansible Core installed
```
ansible --version
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022$ <b>ansible --version</b>
ansible [core 2.13.2]
  config file = None
  configured module search path = ['/home/jegan/.ansible/plugins/modules', '/usr/share/ansible/plugins/modules']
  ansible python module location = /home/jegan/.local/lib/python3.8/site-packages/ansible
  ansible collection location = /home/jegan/.ansible/collections:/usr/share/ansible/collections
  executable location = /home/jegan/.local/bin/ansible
  python version = 3.8.10 (default, Jun 22 2022, 20:18:18) [GCC 9.4.0]
  jinja version = 3.1.2
  libyaml = True
</pre>


## Configuration Management Tool
- helps us in automating software installation, uninstallation, upgrade and configuration
- Examples
   - Ansible
   - Chef ( Ruby )
   - Puppet ( Ruby )
   - Salt/SaltStack 

## Ansible 
- comes in 2 flavors
  1. Ansible Core - OpenSource, CLI, Free for personal and commercial use 
  2. RedHat Ansible Tower - Enterprise Product ( Licensed Software )
- devoloped in Python 
- developed by Ansible Inc organization
- Michael Deehan is the person who founded the Ansible Inc organization
    - Former RedHat Employee
    - he was on a configuration tool as an Architect
    - the product he was was de-commissioned
    - He quit Red-Hat and started Ansible Inc
    - He made this Ansible Core as OpenSource product
- Domain Specific Language Choice (DSL)
     - YAML ( Yet Another Markup Language )
- agentless
- Easy to learn
- RedHat acquired Ansible Inc
- IBM acquired RedHat
- is a RedHat product ( IBM company )

# How developers can use Ansible ?
- developers can use Ansible to automate Developer setup

# How QA can use Ansible ?
- QA Engineers can use Ansible to automate QA Setup using Playbook

# System Administrators
- will be able automate Pre-stating, Staging, Production environments
- will be able to automate Production environment in on-prem or cloud

## What is Ansible Controller Machine (ACM)?
- is the machine where Ansible is installed
- this is the machine where you will write Playbook
- Playbook is the automation script(yaml) file that instructions on what to install on the Ansible Nodes
- has to be Linux machine 
- Windows machines can't be a ACM

## Ansible Node
- are servers
- it could be a Windows Server, Unix/Linux/Mac Servers
- could be on-prem servers, cloud machine or private/public cloud machines
- CISCO switches/routers also can be considered as Ansible Node
- Unix/Linux Nodes
   - Pre-requisites
       1. Python should be present/installed
       2. SSH Server should be there
- Windows Nodes
   - Pre-requisites
     1. .Net Framework
     2. PowerShell should be supported
     
## What is Ansible Module?
- Ansible has modules to 
   - copy files from ACM to Ansible Node
   - copy files from Ansible Node to ACM 
   - install/uninstall/upgrade softwares
   - restart/boot the servers
   - run shell scripts
   - run external third-party application
   - manage AWS resources
   - manage Azure resources
   - manage GCP resources
- Unix/Linux/Mac
  Ansible Modules are nothing but Python scripts
  When you install Ansible, it also installs all the necessary Ansible Modules
- Windows
  Ansible Modules are PowerShell scripts
  
- in rare cases, in cases the existing Ansible modules can't do what you are trying to automate
   - you may write/develop your own Custom Ansible Module using Python ( unix/linux/mac )
   - you may write/develop your won Custom Ansible Module using Powershell ( windows ansible nodes )

## Create public/private key pair
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/CustomDockerImagesForAnsibleNodes/ubuntu$ ssh-keygen
Generating public/private rsa key pair.
Enter file in which to save the key (/home/jegan/.ssh/id_rsa): 
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /home/jegan/.ssh/id_rsa
Your public key has been saved in /home/jegan/.ssh/id_rsa.pub
The key fingerprint is:
SHA256:nP5lXBj2y8jwubovzN6lMICFSCRDZALPQ32xpazphKg jegan@dell-precision-7670
The key's randomart image is:
+---[RSA 3072]----+
|+oBoo ...        |
| * +.o.=         |
|  + ..= .   o    |
| . o o + . . +   |
|. . + . S . . o  |
|.  o   . . = = . |
|E   .   .oo O +  |
|         .+* +   |
|         .===    |
+----[SHA256]-----+
</pre>
