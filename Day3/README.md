# Day3

## Installing Ansible Core
```
sudo apt install python3-pip
pip3 --version
pip3 install ansible
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022$ sudo apt install python3-pip
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
     |????????????????????????????????????????????????????????????????????????????????????????????????| 40.5 MB 9.7 MB/s 
Collecting ansible-core~=2.13.1
  Downloading ansible_core-2.13.2-py3-none-any.whl (2.1 MB)
     |????????????????????????????????????????????????????????????????????????????????????????????????| 2.1 MB 7.6 MB/s 
Requirement already satisfied: cryptography in /usr/lib/python3/dist-packages (from ansible-core~=2.13.1->ansible) (2.8)
Collecting resolvelib<0.9.0,>=0.5.3
  Downloading resolvelib-0.8.1-py2.py3-none-any.whl (16 kB)
Collecting packaging
  Downloading packaging-21.3-py3-none-any.whl (40 kB)
     |????????????????????????????????????????????????????????????????????????????????????????????????| 40 kB 4.9 MB/s 
Collecting jinja2>=3.0.0
  Downloading Jinja2-3.1.2-py3-none-any.whl (133 kB)
     |????????????????????????????????????????????????????????????????????????????????????????????????| 133 kB 9.2 MB/s 
Requirement already satisfied: PyYAML>=5.1 in /usr/lib/python3/dist-packages (from ansible-core~=2.13.1->ansible) (5.3.1)
Collecting pyparsing!=3.0.5,>=2.0.2
  Downloading pyparsing-3.0.9-py3-none-any.whl (98 kB)
     |????????????????????????????????????????????????????????????????????????????????????????????????| 98 kB 7.4 MB/s 
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
jegan@dell-precision-7670:~/devops-aug-2022$ ansible --version
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

## Let's copy the public key as authorized_keys
```
cd ~/devops-aug-2022
git pull

cd Day3/CustomDockerImagesForAnsibleNodes/ubuntu
cp ~/.ssh/id_rsa.pub authorized_keys
```

## Let's build our custom ubuntu ansible node Docker image
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/CustomDockerImagesForAnsibleNodes/ubuntu$ docker build -t tektutor/ubuntu-ansible-node:1.0 .
Sending build context to Docker daemon  4.096kB
Step 1/12 : FROM ubuntu:16.04
16.04: Pulling from library/ubuntu
58690f9b18fc: Pull complete 
b51569e7c507: Pull complete 
da8ef40b9eca: Pull complete 
fb15d46c38dc: Pull complete 
Digest: sha256:91bd29a464fdabfcf44e29e1f2a5f213c6dfa750b6290e40dd6998ac79da3c41
Status: Downloaded newer image for ubuntu:16.04
 ---> b6f507652425
Step 2/12 : MAINTAINER Jeganathan Swaminathan <jegan@tektutor.org>
 ---> Running in 5e7b858e5617
Removing intermediate container 5e7b858e5617
 ---> be98d5b3a60e
Step 3/12 : RUN apt-get update && apt-get install -y openssh-server python3
 ---> Running in d9b404af24be
Get:1 http://archive.ubuntu.com/ubuntu xenial InRelease [247 kB]
Get:2 http://security.ubuntu.com/ubuntu xenial-security InRelease [99.8 kB]
Get:3 http://archive.ubuntu.com/ubuntu xenial-updates InRelease [99.8 kB]
Get:4 http://archive.ubuntu.com/ubuntu xenial-backports InRelease [97.4 kB]
Get:5 http://archive.ubuntu.com/ubuntu xenial/main amd64 Packages [1558 kB]
Get:6 http://security.ubuntu.com/ubuntu xenial-security/main amd64 Packages [2051 kB]
Get:7 http://archive.ubuntu.com/ubuntu xenial/restricted amd64 Packages [14.1 kB]
Get:8 http://archive.ubuntu.com/ubuntu xenial/universe amd64 Packages [9827 kB]
Get:9 http://archive.ubuntu.com/ubuntu xenial/multiverse amd64 Packages [176 kB]
Get:10 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 Packages [2560 kB]
Get:11 http://archive.ubuntu.com/ubuntu xenial-updates/restricted amd64 Packages [16.4 kB]
Get:12 http://archive.ubuntu.com/ubuntu xenial-updates/universe amd64 Packages [1544 kB]
Get:13 http://archive.ubuntu.com/ubuntu xenial-updates/multiverse amd64 Packages [26.2 kB]
Get:14 http://archive.ubuntu.com/ubuntu xenial-backports/main amd64 Packages [10.9 kB]
Get:15 http://archive.ubuntu.com/ubuntu xenial-backports/universe amd64 Packages [12.7 kB]
Get:16 http://security.ubuntu.com/ubuntu xenial-security/restricted amd64 Packages [15.9 kB]
Get:17 http://security.ubuntu.com/ubuntu xenial-security/universe amd64 Packages [984 kB]
Get:18 http://security.ubuntu.com/ubuntu xenial-security/multiverse amd64 Packages [8820 B]
Fetched 19.3 MB in 4s (3926 kB/s)
Reading package lists...
Reading package lists...
Building dependency tree...
Reading state information...
The following additional packages will be installed:
  ca-certificates dh-python file krb5-locales libbsd0 libedit2 libexpat1
  libgssapi-krb5-2 libidn11 libk5crypto3 libkeyutils1 libkrb5-3
  libkrb5support0 libmagic1 libmpdec2 libpython3-stdlib libpython3.5-minimal
  libpython3.5-stdlib libsqlite3-0 libssl1.0.0 libwrap0 libx11-6 libx11-data
  libxau6 libxcb1 libxdmcp6 libxext6 libxmuu1 mime-support ncurses-term
  openssh-client openssh-sftp-server openssl python3-chardet python3-minimal
  python3-pkg-resources python3-requests python3-six python3-urllib3 python3.5
  python3.5-minimal ssh-import-id tcpd wget xauth
Suggested packages:
  libdpkg-perl krb5-doc krb5-user ssh-askpass libpam-ssh keychain monkeysphere
  rssh molly-guard ufw python3-doc python3-tk python3-venv python3-setuptools
  python3-ndg-httpsclient python3-openssl python3-pyasn1 python3.5-venv
  python3.5-doc binutils binfmt-support
The following NEW packages will be installed:
  ca-certificates dh-python file krb5-locales libbsd0 libedit2 libexpat1
  libgssapi-krb5-2 libidn11 libk5crypto3 libkeyutils1 libkrb5-3
  libkrb5support0 libmagic1 libmpdec2 libpython3-stdlib libpython3.5-minimal
  libpython3.5-stdlib libsqlite3-0 libssl1.0.0 libwrap0 libx11-6 libx11-data
  libxau6 libxcb1 libxdmcp6 libxext6 libxmuu1 mime-support ncurses-term
  openssh-client openssh-server openssh-sftp-server openssl python3
  python3-chardet python3-minimal python3-pkg-resources python3-requests
  python3-six python3-urllib3 python3.5 python3.5-minimal ssh-import-id tcpd
  wget xauth
0 upgraded, 47 newly installed, 0 to remove and 0 not upgraded.
Need to get 10.5 MB of archives.
After this operation, 55.0 MB of additional disk space will be used.
Get:1 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libssl1.0.0 amd64 1.0.2g-1ubuntu4.20 [1083 kB]
Get:2 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libpython3.5-minimal amd64 3.5.2-2ubuntu0~16.04.13 [524 kB]
Get:3 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libexpat1 amd64 2.1.0-7ubuntu0.16.04.5 [71.5 kB]
Get:4 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3.5-minimal amd64 3.5.2-2ubuntu0~16.04.13 [1597 kB]
Get:5 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-minimal amd64 3.5.1-3 [23.3 kB]
Get:6 http://archive.ubuntu.com/ubuntu xenial/main amd64 mime-support all 3.59ubuntu1 [31.0 kB]
Get:7 http://archive.ubuntu.com/ubuntu xenial/main amd64 libmpdec2 amd64 2.4.2-1 [82.6 kB]
Get:8 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libsqlite3-0 amd64 3.11.0-1ubuntu1.5 [398 kB]
Get:9 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libpython3.5-stdlib amd64 3.5.2-2ubuntu0~16.04.13 [2135 kB]
Get:10 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3.5 amd64 3.5.2-2ubuntu0~16.04.13 [165 kB]
Get:11 http://archive.ubuntu.com/ubuntu xenial/main amd64 libpython3-stdlib amd64 3.5.1-3 [6818 B]
Get:12 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 dh-python all 2.20151103ubuntu1.2 [73.9 kB]
Get:13 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3 amd64 3.5.1-3 [8710 B]
Get:14 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxau6 amd64 1:1.0.8-1 [8376 B]
Get:15 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxdmcp6 amd64 1:1.1.2-1.1 [11.0 kB]
Get:16 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxcb1 amd64 1.11.1-1ubuntu1 [40.0 kB]
Get:17 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libx11-data all 2:1.6.3-1ubuntu2.2 [114 kB]
Get:18 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libx11-6 amd64 2:1.6.3-1ubuntu2.2 [572 kB]
Get:19 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxext6 amd64 2:1.3.3-1 [29.4 kB]
Get:20 http://archive.ubuntu.com/ubuntu xenial/main amd64 libwrap0 amd64 7.6.q-25 [46.2 kB]
Get:21 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libmagic1 amd64 1:5.25-2ubuntu1.4 [216 kB]
Get:22 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 file amd64 1:5.25-2ubuntu1.4 [21.2 kB]
Get:23 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libbsd0 amd64 0.8.2-1ubuntu0.1 [42.0 kB]
Get:24 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libidn11 amd64 1.32-3ubuntu1.2 [46.5 kB]
Get:25 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssl amd64 1.0.2g-1ubuntu4.20 [492 kB]
Get:26 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 ca-certificates all 20210119~16.04.1 [148 kB]
Get:27 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 krb5-locales all 1.13.2+dfsg-5ubuntu2.2 [13.7 kB]
Get:28 http://archive.ubuntu.com/ubuntu xenial/main amd64 libedit2 amd64 3.1-20150325-1ubuntu2 [76.5 kB]
Get:29 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libkrb5support0 amd64 1.13.2+dfsg-5ubuntu2.2 [31.2 kB]
Get:30 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libk5crypto3 amd64 1.13.2+dfsg-5ubuntu2.2 [81.2 kB]
Get:31 http://archive.ubuntu.com/ubuntu xenial/main amd64 libkeyutils1 amd64 1.5.9-8ubuntu1 [9904 B]
Get:32 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libkrb5-3 amd64 1.13.2+dfsg-5ubuntu2.2 [273 kB]
Get:33 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libgssapi-krb5-2 amd64 1.13.2+dfsg-5ubuntu2.2 [120 kB]
Get:34 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxmuu1 amd64 2:1.1.2-2 [9674 B]
Get:35 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssh-client amd64 1:7.2p2-4ubuntu2.10 [590 kB]
Get:36 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 wget amd64 1.17.1-1ubuntu1.5 [299 kB]
Get:37 http://archive.ubuntu.com/ubuntu xenial/main amd64 xauth amd64 1:1.0.9-1ubuntu2 [22.7 kB]
Get:38 http://archive.ubuntu.com/ubuntu xenial/main amd64 ncurses-term all 6.0+20160213-1ubuntu1 [249 kB]
Get:39 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssh-sftp-server amd64 1:7.2p2-4ubuntu2.10 [38.8 kB]
Get:40 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssh-server amd64 1:7.2p2-4ubuntu2.10 [335 kB]
Get:41 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-pkg-resources all 20.7.0-1 [79.0 kB]
Get:42 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-chardet all 2.3.0-2 [96.2 kB]
Get:43 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-six all 1.10.0-3 [11.0 kB]
Get:44 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3-urllib3 all 1.13.1-2ubuntu0.16.04.4 [58.6 kB]
Get:45 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3-requests all 2.9.1-3ubuntu0.1 [55.8 kB]
Get:46 http://archive.ubuntu.com/ubuntu xenial/main amd64 tcpd amd64 7.6.q-25 [23.0 kB]
Get:47 http://archive.ubuntu.com/ubuntu xenial/main amd64 ssh-import-id all 5.5-0ubuntu1 [10.2 kB]
debconf: delaying package configuration, since apt-utils is not installed
Fetched 10.5 MB in 5s (2066 kB/s)
Selecting previously unselected package libssl1.0.0:amd64.
(Reading database ... 4785 files and directories currently installed.)
Preparing to unpack .../libssl1.0.0_1.0.2g-1ubuntu4.20_amd64.deb ...
Unpacking libssl1.0.0:amd64 (1.0.2g-1ubuntu4.20) ...
Selecting previously unselected package libpython3.5-minimal:amd64.
Preparing to unpack .../libpython3.5-minimal_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking libpython3.5-minimal:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package libexpat1:amd64.
Preparing to unpack .../libexpat1_2.1.0-7ubuntu0.16.04.5_amd64.deb ...
Unpacking libexpat1:amd64 (2.1.0-7ubuntu0.16.04.5) ...
Selecting previously unselected package python3.5-minimal.
Preparing to unpack .../python3.5-minimal_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking python3.5-minimal (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package python3-minimal.
Preparing to unpack .../python3-minimal_3.5.1-3_amd64.deb ...
Unpacking python3-minimal (3.5.1-3) ...
Selecting previously unselected package mime-support.
Preparing to unpack .../mime-support_3.59ubuntu1_all.deb ...
Unpacking mime-support (3.59ubuntu1) ...
Selecting previously unselected package libmpdec2:amd64.
Preparing to unpack .../libmpdec2_2.4.2-1_amd64.deb ...
Unpacking libmpdec2:amd64 (2.4.2-1) ...
Selecting previously unselected package libsqlite3-0:amd64.
Preparing to unpack .../libsqlite3-0_3.11.0-1ubuntu1.5_amd64.deb ...
Unpacking libsqlite3-0:amd64 (3.11.0-1ubuntu1.5) ...
Selecting previously unselected package libpython3.5-stdlib:amd64.
Preparing to unpack .../libpython3.5-stdlib_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking libpython3.5-stdlib:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package python3.5.
Preparing to unpack .../python3.5_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking python3.5 (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package libpython3-stdlib:amd64.
Preparing to unpack .../libpython3-stdlib_3.5.1-3_amd64.deb ...
Unpacking libpython3-stdlib:amd64 (3.5.1-3) ...
Selecting previously unselected package dh-python.
Preparing to unpack .../dh-python_2.20151103ubuntu1.2_all.deb ...
Unpacking dh-python (2.20151103ubuntu1.2) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Setting up libssl1.0.0:amd64 (1.0.2g-1ubuntu4.20) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.22.1 /usr/local/share/perl/5.22.1 /usr/lib/x86_64-linux-gnu/perl5/5.22 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl/5.22 /usr/share/perl/5.22 /usr/local/lib/site_perl /usr/lib/x86_64-linux-gnu/perl-base .) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Setting up libpython3.5-minimal:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Setting up libexpat1:amd64 (2.1.0-7ubuntu0.16.04.5) ...
Setting up python3.5-minimal (3.5.2-2ubuntu0~16.04.13) ...
Setting up python3-minimal (3.5.1-3) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Selecting previously unselected package python3.
(Reading database ... 5761 files and directories currently installed.)
Preparing to unpack .../python3_3.5.1-3_amd64.deb ...
Unpacking python3 (3.5.1-3) ...
Selecting previously unselected package libxau6:amd64.
Preparing to unpack .../libxau6_1%3a1.0.8-1_amd64.deb ...
Unpacking libxau6:amd64 (1:1.0.8-1) ...
Selecting previously unselected package libxdmcp6:amd64.
Preparing to unpack .../libxdmcp6_1%3a1.1.2-1.1_amd64.deb ...
Unpacking libxdmcp6:amd64 (1:1.1.2-1.1) ...
Selecting previously unselected package libxcb1:amd64.
Preparing to unpack .../libxcb1_1.11.1-1ubuntu1_amd64.deb ...
Unpacking libxcb1:amd64 (1.11.1-1ubuntu1) ...
Selecting previously unselected package libx11-data.
Preparing to unpack .../libx11-data_2%3a1.6.3-1ubuntu2.2_all.deb ...
Unpacking libx11-data (2:1.6.3-1ubuntu2.2) ...
Selecting previously unselected package libx11-6:amd64.
Preparing to unpack .../libx11-6_2%3a1.6.3-1ubuntu2.2_amd64.deb ...
Unpacking libx11-6:amd64 (2:1.6.3-1ubuntu2.2) ...
Selecting previously unselected package libxext6:amd64.
Preparing to unpack .../libxext6_2%3a1.3.3-1_amd64.deb ...
Unpacking libxext6:amd64 (2:1.3.3-1) ...
Selecting previously unselected package libwrap0:amd64.
Preparing to unpack .../libwrap0_7.6.q-25_amd64.deb ...
Unpacking libwrap0:amd64 (7.6.q-25) ...
Selecting previously unselected package libmagic1:amd64.
Preparing to unpack .../libmagic1_1%3a5.25-2ubuntu1.4_amd64.deb ...
Unpacking libmagic1:amd64 (1:5.25-2ubuntu1.4) ...
Selecting previously unselected package file.
Preparing to unpack .../file_1%3a5.25-2ubuntu1.4_amd64.deb ...
Unpacking file (1:5.25-2ubuntu1.4) ...
Selecting previously unselected package libbsd0:amd64.
Preparing to unpack .../libbsd0_0.8.2-1ubuntu0.1_amd64.deb ...
Unpacking libbsd0:amd64 (0.8.2-1ubuntu0.1) ...
Selecting previously unselected package libidn11:amd64.
Preparing to unpack .../libidn11_1.32-3ubuntu1.2_amd64.deb ...
Unpacking libidn11:amd64 (1.32-3ubuntu1.2) ...
Selecting previously unselected package openssl.
Preparing to unpack .../openssl_1.0.2g-1ubuntu4.20_amd64.deb ...
Unpacking openssl (1.0.2g-1ubuntu4.20) ...
Selecting previously unselected package ca-certificates.
Preparing to unpack .../ca-certificates_20210119~16.04.1_all.deb ...
Unpacking ca-certificates (20210119~16.04.1) ...
Selecting previously unselected package krb5-locales.
Preparing to unpack .../krb5-locales_1.13.2+dfsg-5ubuntu2.2_all.deb ...
Unpacking krb5-locales (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libedit2:amd64.
Preparing to unpack .../libedit2_3.1-20150325-1ubuntu2_amd64.deb ...
Unpacking libedit2:amd64 (3.1-20150325-1ubuntu2) ...
Selecting previously unselected package libkrb5support0:amd64.
Preparing to unpack .../libkrb5support0_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libkrb5support0:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libk5crypto3:amd64.
Preparing to unpack .../libk5crypto3_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libk5crypto3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libkeyutils1:amd64.
Preparing to unpack .../libkeyutils1_1.5.9-8ubuntu1_amd64.deb ...
Unpacking libkeyutils1:amd64 (1.5.9-8ubuntu1) ...
Selecting previously unselected package libkrb5-3:amd64.
Preparing to unpack .../libkrb5-3_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libkrb5-3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libgssapi-krb5-2:amd64.
Preparing to unpack .../libgssapi-krb5-2_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libgssapi-krb5-2:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libxmuu1:amd64.
Preparing to unpack .../libxmuu1_2%3a1.1.2-2_amd64.deb ...
Unpacking libxmuu1:amd64 (2:1.1.2-2) ...
Selecting previously unselected package openssh-client.
Preparing to unpack .../openssh-client_1%3a7.2p2-4ubuntu2.10_amd64.deb ...
Unpacking openssh-client (1:7.2p2-4ubuntu2.10) ...
Selecting previously unselected package wget.
Preparing to unpack .../wget_1.17.1-1ubuntu1.5_amd64.deb ...
Unpacking wget (1.17.1-1ubuntu1.5) ...
Selecting previously unselected package xauth.
Preparing to unpack .../xauth_1%3a1.0.9-1ubuntu2_amd64.deb ...
Unpacking xauth (1:1.0.9-1ubuntu2) ...
Selecting previously unselected package ncurses-term.
Preparing to unpack .../ncurses-term_6.0+20160213-1ubuntu1_all.deb ...
Unpacking ncurses-term (6.0+20160213-1ubuntu1) ...
Selecting previously unselected package openssh-sftp-server.
Preparing to unpack .../openssh-sftp-server_1%3a7.2p2-4ubuntu2.10_amd64.deb ...
Unpacking openssh-sftp-server (1:7.2p2-4ubuntu2.10) ...
Selecting previously unselected package openssh-server.
Preparing to unpack .../openssh-server_1%3a7.2p2-4ubuntu2.10_amd64.deb ...
Unpacking openssh-server (1:7.2p2-4ubuntu2.10) ...
Selecting previously unselected package python3-pkg-resources.
Preparing to unpack .../python3-pkg-resources_20.7.0-1_all.deb ...
Unpacking python3-pkg-resources (20.7.0-1) ...
Selecting previously unselected package python3-chardet.
Preparing to unpack .../python3-chardet_2.3.0-2_all.deb ...
Unpacking python3-chardet (2.3.0-2) ...
Selecting previously unselected package python3-six.
Preparing to unpack .../python3-six_1.10.0-3_all.deb ...
Unpacking python3-six (1.10.0-3) ...
Selecting previously unselected package python3-urllib3.
Preparing to unpack .../python3-urllib3_1.13.1-2ubuntu0.16.04.4_all.deb ...
Unpacking python3-urllib3 (1.13.1-2ubuntu0.16.04.4) ...
Selecting previously unselected package python3-requests.
Preparing to unpack .../python3-requests_2.9.1-3ubuntu0.1_all.deb ...
Unpacking python3-requests (2.9.1-3ubuntu0.1) ...
Selecting previously unselected package tcpd.
Preparing to unpack .../tcpd_7.6.q-25_amd64.deb ...
Unpacking tcpd (7.6.q-25) ...
Selecting previously unselected package ssh-import-id.
Preparing to unpack .../ssh-import-id_5.5-0ubuntu1_all.deb ...
Unpacking ssh-import-id (5.5-0ubuntu1) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Processing triggers for systemd (229-4ubuntu21.31) ...
Setting up mime-support (3.59ubuntu1) ...
Setting up libmpdec2:amd64 (2.4.2-1) ...
Setting up libsqlite3-0:amd64 (3.11.0-1ubuntu1.5) ...
Setting up libpython3.5-stdlib:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Setting up python3.5 (3.5.2-2ubuntu0~16.04.13) ...
Setting up libpython3-stdlib:amd64 (3.5.1-3) ...
Setting up libxau6:amd64 (1:1.0.8-1) ...
Setting up libxdmcp6:amd64 (1:1.1.2-1.1) ...
Setting up libxcb1:amd64 (1.11.1-1ubuntu1) ...
Setting up libx11-data (2:1.6.3-1ubuntu2.2) ...
Setting up libx11-6:amd64 (2:1.6.3-1ubuntu2.2) ...
Setting up libxext6:amd64 (2:1.3.3-1) ...
Setting up libwrap0:amd64 (7.6.q-25) ...
Setting up libmagic1:amd64 (1:5.25-2ubuntu1.4) ...
Setting up file (1:5.25-2ubuntu1.4) ...
Setting up libbsd0:amd64 (0.8.2-1ubuntu0.1) ...
Setting up libidn11:amd64 (1.32-3ubuntu1.2) ...
Setting up openssl (1.0.2g-1ubuntu4.20) ...
Setting up ca-certificates (20210119~16.04.1) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.22.1 /usr/local/share/perl/5.22.1 /usr/lib/x86_64-linux-gnu/perl5/5.22 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl/5.22 /usr/share/perl/5.22 /usr/local/lib/site_perl /usr/lib/x86_64-linux-gnu/perl-base .) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Setting up krb5-locales (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libedit2:amd64 (3.1-20150325-1ubuntu2) ...
Setting up libkrb5support0:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libk5crypto3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libkeyutils1:amd64 (1.5.9-8ubuntu1) ...
Setting up libkrb5-3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libgssapi-krb5-2:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libxmuu1:amd64 (2:1.1.2-2) ...
Setting up openssh-client (1:7.2p2-4ubuntu2.10) ...
Setting up wget (1.17.1-1ubuntu1.5) ...
Setting up xauth (1:1.0.9-1ubuntu2) ...
Setting up ncurses-term (6.0+20160213-1ubuntu1) ...
Setting up openssh-sftp-server (1:7.2p2-4ubuntu2.10) ...
Setting up openssh-server (1:7.2p2-4ubuntu2.10) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.22.1 /usr/local/share/perl/5.22.1 /usr/lib/x86_64-linux-gnu/perl5/5.22 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl/5.22 /usr/share/perl/5.22 /usr/local/lib/site_perl /usr/lib/x86_64-linux-gnu/perl-base .) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Creating SSH2 RSA key; this may take some time ...
2048 SHA256:F+lexV2ZyNjyMlNXDf49OTr83PrXa+xYGDYncjzIyI4 root@d9b404af24be (RSA)
Creating SSH2 DSA key; this may take some time ...
1024 SHA256:6CLFw3TOdvNfTYhgSyP+uxH3e0JKvEvQV/2wCvMw6Rw root@d9b404af24be (DSA)
Creating SSH2 ECDSA key; this may take some time ...
256 SHA256:MyepWPsd6fCbIhKEpb+LERsMvUef3EG8cFTlOr5Vt0s root@d9b404af24be (ECDSA)
Creating SSH2 ED25519 key; this may take some time ...
256 SHA256:6bWpLbsHw1tDtMgplu+XXuH7RiWsOLS/3dmMpmdP54o root@d9b404af24be (ED25519)
invoke-rc.d: could not determine current runlevel
invoke-rc.d: policy-rc.d denied execution of start.
Setting up tcpd (7.6.q-25) ...
Setting up dh-python (2.20151103ubuntu1.2) ...
Setting up python3 (3.5.1-3) ...
running python rtupdate hooks for python3.5...
running python post-rtupdate hooks for python3.5...
Setting up python3-pkg-resources (20.7.0-1) ...
Setting up python3-chardet (2.3.0-2) ...
Setting up python3-six (1.10.0-3) ...
Setting up python3-urllib3 (1.13.1-2ubuntu0.16.04.4) ...
Setting up python3-requests (2.9.1-3ubuntu0.1) ...
Setting up ssh-import-id (5.5-0ubuntu1) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Processing triggers for ca-certificates (20210119~16.04.1) ...
Updating certificates in /etc/ssl/certs...
129 added, 0 removed; done.
Running hooks in /etc/ca-certificates/update.d...
done.
Processing triggers for systemd (229-4ubuntu21.31) ...
Removing intermediate container d9b404af24be
 ---> 9c526416c41e
Step 4/12 : RUN mkdir /var/run/sshd
 ---> Running in 13ab40278d6c
Removing intermediate container 13ab40278d6c
 ---> 0ccd4963df99
Step 5/12 : RUN echo 'root:root' | chpasswd
 ---> Running in c34dcef079ac
Removing intermediate container c34dcef079ac
 ---> c2c40dde9bf3
Step 6/12 : RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
 ---> Running in 0a10c5bc6a62
Removing intermediate container 0a10c5bc6a62
 ---> c9252c26e334
Step 7/12 : RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd
 ---> Running in f40136d913f4
Removing intermediate container f40136d913f4
 ---> 4a0f5d52f352
Step 8/12 : RUN mkdir -p /root/.ssh
 ---> Running in d6c4b639aff1
Removing intermediate container d6c4b639aff1
 ---> 7b1570569210
Step 9/12 : COPY authorized_keys /root/.ssh/authorized_keys
 ---> 5b18c429a276
Step 10/12 : EXPOSE 22
 ---> Running in 4c0f36040662
Removing intermediate container 4c0f36040662
 ---> 2f244ba28758
Step 11/12 : EXPOSE 80
 ---> Running in 07fca3a43576
Removing intermediate container 07fca3a43576
 ---> 5c48b9c4645e
Step 12/12 : CMD ["/usr/sbin/sshd", "-D"]
 ---> Running in b01adb5eb1ef
Removing intermediate container b01adb5eb1ef
 ---> b00c3100ccb2
Successfully built b00c3100ccb2
Successfully tagged tektutor/ubuntu-ansible-node:1.0
</pre>

## See if the ubuntu custom image is present on your system
```
docker images
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/CustomDockerImagesForAnsibleNodes/ubuntu$ <b>docker images</b>
REPOSITORY                                TAG       IMAGE ID       CREATED              SIZE
<b>tektutor/ubuntu-ansible-node              1.0       b00c3100ccb2   About a minute ago   220MB</b>
docker.bintray.io/jfrog/artifactory-oss   latest    031acd2d33c7   3 weeks ago          1.19GB
ubuntu                                    16.04     b6f507652425   11 months ago        135MB
</pre>

## Let's create two ansible node containers
Delete all existing containers
```
docker rm -f $(docker ps -aq)
```

Now let's create our ansible node containers
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ubuntu-ansible-node:1.0
docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ubuntu-ansible-node:1.0
```

Expected output
<pre>
jegan@dell-precision-7670:~$ <b>docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ubuntu-ansible-node:1.0 </b>
59cfd27397a3d4ef73140120cd5d26ad6265df1041dd41b503c8791650bb2703
jegan@dell-precision-7670:~$ <b>docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ubuntu-ansible-node:1.0</b> 
f8f02bb807cd971113b369d150a1761d2d504d8e9a274b97d4ad1293e40e7b9e
jegan@dell-precision-7670:~$ <b>docker ps</b>
CONTAINER ID   IMAGE                              COMMAND               CREATED          STATUS          PORTS                                                                          NAMES
f8f02bb807cd   tektutor/ubuntu-ansible-node:1.0   "/usr/sbin/sshd -D"   2 seconds ago    Up 1 second     0.0.0.0:2002->22/tcp, :::2002->22/tcp, 0.0.0.0:8002->80/tcp, :::8002->80/tcp   ubuntu2
59cfd27397a3   tektutor/ubuntu-ansible-node:1.0   "/usr/sbin/sshd -D"   17 seconds ago   Up 16 seconds   0.0.0.0:2001->22/tcp, :::2001->22/tcp, 0.0.0.0:8001->80/tcp, :::8001->80/tcp   ubuntu1
</pre>

## Testing the ansible node containers for SSH connection with public key
```
ssh -p 2001 root@localhost
exit

ssh -p 2002 root@localhost
exit
```

Expected output
<pre>
jegan@dell-precision-7670:~$ <b>ssh -p 2001 root@localhost</b>
The authenticity of host '[localhost]:2001 ([127.0.0.1]:2001)' can't be established.
ECDSA key fingerprint is SHA256:MyepWPsd6fCbIhKEpb+LERsMvUef3EG8cFTlOr5Vt0s.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[localhost]:2001' (ECDSA) to the list of known hosts.
Welcome to Ubuntu 16.04.7 LTS (GNU/Linux 5.14.0-1046-oem x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

root@ubuntu1:~# <b>exit</b>
logout
Connection to localhost closed.
jegan@dell-precision-7670:~$ <b>ssh -p 2002 root@localhost</b>
The authenticity of host '[localhost]:2002 ([127.0.0.1]:2002)' can't be established.
ECDSA key fingerprint is SHA256:MyepWPsd6fCbIhKEpb+LERsMvUef3EG8cFTlOr5Vt0s.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[localhost]:2002' (ECDSA) to the list of known hosts.
Welcome to Ubuntu 16.04.7 LTS (GNU/Linux 5.14.0-1046-oem x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

root@ubuntu2:~# <b>exit</b>
logout
Connection to localhost closed.
</pre>


## Writing your first static inventory

The static inventory file is a text file with connection details to the ansible nodes
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ cat hosts 
[all]
ubuntu1 ansible_user=root ansible_port=2001 ansible_host=localhost ansible_private_key_file=~/.ssh/id_rsa
ubuntu2 ansible_user=root ansible_port=2001 ansible_host=localhost ansible_private_key_file=~/.ssh/id_rsa
</pre>

Running the ansible ad-hoc ping
```
cd ~/devops-aug-2022
git pull

cd Day3/Ansible
ansible -i hosts all -m ping
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ <b>ansible -i hosts all -m ping</b>
ubuntu1 | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "ping": "pong"
}
ubuntu2 | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "ping": "pong"
}
</pre>

## Ansible ping with verbosity enabled for debugging or to understand ansible internals
```
ansible -i hosts qa -m ping -vvvv
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ <b>ansible -i hosts qa -m ping -vvvv</b>
ansible [core 2.13.2]
  config file = None
  configured module search path = ['/home/jegan/.ansible/plugins/modules', '/usr/share/ansible/plugins/modules']
  ansible python module location = /home/jegan/.local/lib/python3.8/site-packages/ansible
  ansible collection location = /home/jegan/.ansible/collections:/usr/share/ansible/collections
  executable location = /home/jegan/.local/bin/ansible
  python version = 3.8.10 (default, Jun 22 2022, 20:18:18) [GCC 9.4.0]
  jinja version = 3.1.2
  libyaml = True
No config file found; using defaults
setting up inventory plugins
host_list declined parsing /home/jegan/devops-aug-2022/Day3/Ansible/hosts as it did not pass its verify_file() method
script declined parsing /home/jegan/devops-aug-2022/Day3/Ansible/hosts as it did not pass its verify_file() method
auto declined parsing /home/jegan/devops-aug-2022/Day3/Ansible/hosts as it did not pass its verify_file() method
Parsed /home/jegan/devops-aug-2022/Day3/Ansible/hosts inventory source with ini plugin
Loading callback plugin minimal of type stdout, v2.0 from /home/jegan/.local/lib/python3.8/site-packages/ansible/plugins/callback/minimal.py
Skipping callback 'default', as we already have a stdout callback.
Skipping callback 'minimal', as we already have a stdout callback.
Skipping callback 'oneline', as we already have a stdout callback.
META: ran handlers
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' localhost '/bin/sh -c '"'"'echo ~root && sleep 0'"'"''
<localhost> (0, b'/root\n', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' localhost '/bin/sh -c '"'"'( umask 77 && mkdir -p "` echo /root/.ansible/tmp `"&& mkdir "` echo /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767 `" && echo ansible-tmp-1659517511.0108116-6810-169163990987767="` echo /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767 `" ) && sleep 0'"'"''
<localhost> (0, b'ansible-tmp-1659517511.0108116-6810-169163990987767=/root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767\n', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
<ubuntu2> Attempting python interpreter discovery
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' localhost '/bin/sh -c '"'"'echo PLATFORM; uname; echo FOUND; command -v '"'"'"'"'"'"'"'"'python3.10'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python3.9'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python3.8'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python3.7'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python3.6'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python3.5'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'/usr/bin/python3'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'/usr/libexec/platform-python'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python2.7'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'/usr/bin/python'"'"'"'"'"'"'"'"'; command -v '"'"'"'"'"'"'"'"'python'"'"'"'"'"'"'"'"'; echo ENDFOUND && sleep 0'"'"''
<localhost> (0, b'PLATFORM\nLinux\nFOUND\n/usr/bin/python3.5\n/usr/bin/python3\nENDFOUND\n', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' localhost '/bin/sh -c '"'"'/usr/bin/python3.5 && sleep 0'"'"''
<localhost> (0, b'{"osrelease_content": "NAME=\\"Ubuntu\\"\\nVERSION=\\"16.04.7 LTS (Xenial Xerus)\\"\\nID=ubuntu\\nID_LIKE=debian\\nPRETTY_NAME=\\"Ubuntu 16.04.7 LTS\\"\\nVERSION_ID=\\"16.04\\"\\nHOME_URL=\\"http://www.ubuntu.com/\\"\\nSUPPORT_URL=\\"http://help.ubuntu.com/\\"\\nBUG_REPORT_URL=\\"http://bugs.launchpad.net/ubuntu/\\"\\nVERSION_CODENAME=xenial\\nUBUNTU_CODENAME=xenial\\n", "platform_dist_result": ["Ubuntu", "16.04", "xenial"]}\n', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
Using module file /home/jegan/.local/lib/python3.8/site-packages/ansible/modules/ping.py
<localhost> PUT /home/jegan/.ansible/tmp/ansible-local-6806tycsz8vm/tmp8fajgdu6 TO /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/AnsiballZ_ping.py
<localhost> SSH: EXEC sftp -b - -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' '[localhost]'
<localhost> (0, b'sftp> put /home/jegan/.ansible/tmp/ansible-local-6806tycsz8vm/tmp8fajgdu6 /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/AnsiballZ_ping.py\n', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug2: Remote version: 3\r\ndebug2: Server supports extension "posix-rename@openssh.com" revision 1\r\ndebug2: Server supports extension "statvfs@openssh.com" revision 2\r\ndebug2: Server supports extension "fstatvfs@openssh.com" revision 2\r\ndebug2: Server supports extension "hardlink@openssh.com" revision 1\r\ndebug2: Server supports extension "fsync@openssh.com" revision 1\r\ndebug3: Sent message fd 3 T:16 I:1\r\ndebug3: SSH_FXP_REALPATH . -> /root size 0\r\ndebug3: Looking up /home/jegan/.ansible/tmp/ansible-local-6806tycsz8vm/tmp8fajgdu6\r\ndebug3: Sent message fd 3 T:17 I:2\r\ndebug3: Received stat reply T:101 I:2\r\ndebug1: Couldn\'t stat remote file: No such file or directory\r\ndebug3: Sent message SSH2_FXP_OPEN I:3 P:/root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/AnsiballZ_ping.py\r\ndebug3: Sent message SSH2_FXP_WRITE I:4 O:0 S:32768\r\ndebug3: SSH2_FXP_STATUS 0\r\ndebug3: In write loop, ack for 4 32768 bytes at 0\r\ndebug3: Sent message SSH2_FXP_WRITE I:5 O:32768 S:32768\r\ndebug3: Sent message SSH2_FXP_WRITE I:6 O:65536 S:32768\r\ndebug3: Sent message SSH2_FXP_WRITE I:7 O:98304 S:28856\r\ndebug3: SSH2_FXP_STATUS 0\r\ndebug3: In write loop, ack for 5 32768 bytes at 32768\r\ndebug3: SSH2_FXP_STATUS 0\r\ndebug3: In write loop, ack for 6 32768 bytes at 65536\r\ndebug3: SSH2_FXP_STATUS 0\r\ndebug3: In write loop, ack for 7 28856 bytes at 98304\r\ndebug3: Sent message SSH2_FXP_CLOSE I:4\r\ndebug3: SSH2_FXP_STATUS 0\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' localhost '/bin/sh -c '"'"'chmod u+x /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/ /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/AnsiballZ_ping.py && sleep 0'"'"''
<localhost> (0, b'', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' -tt localhost '/bin/sh -c '"'"'/usr/bin/python3 /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/AnsiballZ_ping.py && sleep 0'"'"''
<localhost> (0, b'\r\n{"ping": "pong", "invocation": {"module_args": {"data": "pong"}}}\r\n', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\nShared connection to localhost closed.\r\n')
<localhost> ESTABLISH SSH CONNECTION FOR USER: root
<localhost> SSH: EXEC ssh -vvv -C -o ControlMaster=auto -o ControlPersist=60s -o Port=2001 -o 'IdentityFile="/home/jegan/.ssh/id_rsa"' -o KbdInteractiveAuthentication=no -o PreferredAuthentications=gssapi-with-mic,gssapi-keyex,hostbased,publickey -o PasswordAuthentication=no -o 'User="root"' -o ConnectTimeout=10 -o 'ControlPath="/home/jegan/.ansible/cp/69ebd5c64d"' localhost '/bin/sh -c '"'"'rm -f -r /root/.ansible/tmp/ansible-tmp-1659517511.0108116-6810-169163990987767/ > /dev/null 2>&1 && sleep 0'"'"''
<localhost> (0, b'', b'OpenSSH_8.2p1 Ubuntu-4ubuntu0.5, OpenSSL 1.1.1f  31 Mar 2020\r\ndebug1: Reading configuration data /etc/ssh/ssh_config\r\ndebug1: /etc/ssh/ssh_config line 19: include /etc/ssh/ssh_config.d/*.conf matched no files\r\ndebug1: /etc/ssh/ssh_config line 21: Applying options for *\r\ndebug1: auto-mux: Trying existing master\r\ndebug2: fd 3 setting O_NONBLOCK\r\ndebug2: mux_client_hello_exchange: master version 4\r\ndebug3: mux_client_forwards: request forwardings: 0 local, 0 remote\r\ndebug3: mux_client_request_session: entering\r\ndebug3: mux_client_request_alive: entering\r\ndebug3: mux_client_request_alive: done pid = 6531\r\ndebug3: mux_client_request_session: session request sent\r\ndebug3: mux_client_read_packet: read header failed: Broken pipe\r\ndebug2: Received exit status from master 0\r\n')
ubuntu2 | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "invocation": {
        "module_args": {
            "data": "pong"
        }
    },
    "ping": "pong"
}
META: ran handlers
META: ran handlers
</pre>

## Listing ansible modules supported by Ansible Core
```
ansible-doc -l
```

## Getting help manual for any known ansible module
```
ansible-doc copy
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ <b>ansible-doc copy</b>
> ANSIBLE.BUILTIN.COPY    (/home/jegan/.local/lib/python3.8/site-packages/ansible/modules/copy.py)

        The `copy' module copies a file from the local or remote machine to a
        location on the remote machine. Use the [ansible.builtin.fetch] module to
        copy files from remote locations to the local box. If you need variable
        interpolation in copied files, use the [ansible.builtin.template] module.
        Using a variable in the `content' field will result in unpredictable output.
        For Windows targets, use the [ansible.windows.win_copy] module instead.

ADDED IN: historical

  * note: This module has a corresponding action plugin.

OPTIONS (= is mandatory):

- attributes
        The attributes the resulting filesystem object should have.
        To get supported flags look at the man page for `chattr' on the target
        system.
        This string should contain the attributes in the same order as the one
        displayed by `lsattr'.
        The `=' operator is assumed as default, otherwise `+' or `-' operators need
        to be included in the string.
        (Aliases: attr)[Default: (null)]
        type: str
        added in: version 2.3 of ansible-core
</pre>

## Writing a simple playbook
The playbook looks as below
<pre>
- name: Demonstrate writing a simple Ansible playbook
  hosts: all
  tasks:
  - name: Ping ansible ubuntu node
    ping:
</pre>

### Executing the playbook
```
cd ~/devops-aug-2022
git pull

cd Day3/Ansible
ansible-playbook -i hosts ping.yml
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ <b>ansible-playbook -i hosts ping.yml</b> 

PLAY [Demonstrate writing a simple Ansible playbook] ****************************************************

TASK [Gathering Facts] **********************************************************************************
ok: [ubuntu1]
ok: [ubuntu2]

TASK [Ping ansible ubuntu node] *************************************************************************
ok: [ubuntu2]
ok: [ubuntu1]

PLAY RECAP **********************************************************************************************
ubuntu1                    : ok=2    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
ubuntu2                    : ok=2    changed=0    unreachable=0    failed=0    skipped=0    rescued=0 
</pre>


## Installing nginx web server into the Ubuntu Ansible Node Containers using Ansible playbook
```
cd ~/devops-aug-2022
git pull

cd Day3/Ansible
ansible-playbook -i hosts install-nginx-playbook.yml
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ <b>ansible-playbook -i hosts install-nginx-playbook.yml</b>

PLAY [This playbook will install, configure and deploy custom web page into Ubuntu ansible nodes] *******

TASK [Gathering Facts] **********************************************************************************
ok: [ubuntu2]
ok: [ubuntu1]

TASK [Install nginx in Ubuntu node] *********************************************************************
ok: [ubuntu1]
ok: [ubuntu2]

TASK [Create the custom html folder] ********************************************************************
changed: [ubuntu1]
changed: [ubuntu2]

TASK [Deploy our custom html page] **********************************************************************
changed: [ubuntu1]
changed: [ubuntu2]

TASK [Configure nginx to use our custom html folder] ****************************************************
changed: [ubuntu2]
changed: [ubuntu1]

TASK [Restart the nginx service] ************************************************************************
changed: [ubuntu2]
changed: [ubuntu1]

PLAY RECAP **********************************************************************************************
ubuntu1                    : ok=6    changed=4    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
ubuntu2                    : ok=6    changed=4    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0 
</pre>

## Accessing the nginx web pages
```
curl http://localhost:8001
curl http://localhost:8002
```

## Execute this playbook to download artifacts from JFrog Artifactory
```
cd ~/devops-aug-2022
git pull

cd Day3/Ansible
ansible-playbook download-artifacts-from-artifactory-playbook.yml
```

Expected output
<pre>
jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ <b>ansible-playbook download-artifacts-from-artifactory-playbook.yml</b>
[WARNING]: No inventory was parsed, only implicit localhost is available
[WARNING]: provided hosts list is empty, only localhost is available. Note that the implicit localhost does not match 'all'

PLAY [This playbook downloads artifacts from JFrog Artifactory] ***************************************************************

TASK [Gathering Facts] ********************************************************************************************************
ok: [localhost]

TASK [Download artifact from JFrog artifactory] *******************************************************************************
changed: [localhost]

PLAY RECAP ********************************************************************************************************************
localhost                  : ok=2    changed=1    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   

jegan@dell-precision-7670:~/devops-aug-2022/Day3/Ansible$ ls
<b>businesslayer-1.0.jar</b>  download-artifacts-from-artifactory-playbook.yml  index.html                  ping.yml
default                hosts                                             install-nginx-playbook.yml
</pre>

## Ansible Vault
- helps you store and retrieve sensitive login credentials in a secured password protected encrypted file

```
ansible-vault create credentials.yml
```
When it prompts for password, type root@123 or your preferred password.
Type the below in the file and save it
<pre>
username: root
password: Admin@123
</pre>

Once the vault file is created, see the content of the vault protected file
```
cat credentials.yml
```
Expected output
<pre>
$ANSIBLE_VAULT;1.1;AES256
62353163643766643137396334326639363862646534616461623965613763616230393664643238
6330393937383336383965363664616234386639656431390a383838663762343461393936613134
66333564613362353564353763663764333165623338323239346232316137356265363966656437
3934353837636461640a303131363764653163336265333132396335333730623463376339396434
61643666363436313235396163356365663537666561373736656436336465316130623939333762
6464666336313266383465636262353333643535383733666632
</pre>

You may optionally edit, decrypt, encrypt the file using the below commands
```
ansible-vault decrypt credentials.yml
ansible-vault encrypt credentials.yml
ansible-vault view credentials.yml
```
The above commands will prompting for password that you supplied while creating the vault file.
If you forget the the vault password, forget your vault.

## Running the playbook that retrievs JFrog login credentials from an Ansible vault protected file
```
cd ~/devops-aug-2022
git pull

cd Day3/Ansible
ansible-playbook download-artifacts-from-artifactory-playbook.yml --ask-vault-pass
```
