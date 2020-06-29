![](https://nonstoplearningbydoing.files.wordpress.com/2016/12/spring-boot-docker1.png?w=200)
# hiberus-checkout-be
You can find the restfull api fundamentals over this framework and working on any feature of the spring's power

### Build and run
On your root code execute:

*mvn clean install*

**docker build -t lcarlosrincon/hiberus-checkout .*

*docker run --name checkout -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 lcarlosrincon/hiberus-checkout*

On your navigator put: http://localhost:8080/checkout

You must be run [logistic](https://github.com/lcarlosrincon/hiberus-logistic-be) and [bill](https://github.com/lcarlosrincon/hiberus-bill-be) container.

#### Network for containers

You'll need this configuracion in the docker environment for running the services in differents containers:

docker network create --gateway 172.168.1.1 --subnet 172.168.1.0/24 hiberus-net

docker network connect --ip 172.168.1.2 hiberus-net checkout

docker network connect --ip 172.168.1.3 hiberus-net bill

docker network connect --ip 172.168.1.4 hiberus-net logistic

### General service instructions

- Remember put the dot (.) on the end of command when you try to build image docker

- Format date is: dd-MM-yyyy HH:mm:ss

- You can use the swagger interface to test the service in the same url
