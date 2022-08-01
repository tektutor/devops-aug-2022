# Day2

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
