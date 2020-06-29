![](https://nonstoplearningbydoing.files.wordpress.com/2016/12/spring-boot-docker1.png?w=200)
# hiberus-checkout-be
You can find the restfull api fundamentals over this framework and working on any feature of the spring's power

### Build and run
On your root code execute:

*mvn clean install*

**docker build -t lcarlosrincon/hiberus-checkout .*

*docker run -p 8080:8080 lcarlosrincon/hiberus-checkout*

On your navigator put: http://localhost:8080/checkout

You must be run logistic and bill container.

### General service instructions

- Remember put the dot (.) on the end of command when you try to build image docker

- Format date is: dd-MM-yyyy HH:mm:ss

- You can use the swagger interface to test the service in the same url