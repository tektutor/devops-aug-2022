# Day2

## Installing Docker Community Edition in CentOS 7.x
```
sudo yum install -y yum-utils
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install docker-ce docker-ce-cli containerd.io docker-compose-plugin
sudo systemctl enable docker
sudo systemctl start docker
```

## Testing if docker is installed properly
```
docker version
docker images
```

## Troubleshooting docker permission denied error
When it prompts for password, please type rps@12345
```
sudo usermod -aG docker $USER
newgrp docker
docker images
```
