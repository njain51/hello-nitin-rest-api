package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class GetinstanceService {

     //  get first 5 letter from hostname where application is running
     /*
     The only interesting thing in here is the GetinstanceService which actually looks for a environment variable with the name as HOSTNMAE.
You would see that whenever you run an application inside a Docker container or whenever you'd run it in Kubernetes,what those runtime environments do is, they inject a environment variable with the name as HOSTNAME.
What we'd want to do is, we would want to make use of this hostname to find out where our service is running.
So, our service might be running in five instances, 10 instances, 15 instances.
How do you know which instance is actually returning the response back?
What we'll do is, we'll take the five characters, the last five characters, of the hostname and we are returning it back.
If the hostname environment variable is not present, then we are, by default, returning a value of local
      */

     private final  static String HOST_NAME = "HOSTNAME";  // its the environment value

     private final static String DEFAULT_ENV_INSTANCE = "LOCAL";

     @Value("${" + HOST_NAME + ":" + DEFAULT_ENV_INSTANCE + "}") // it will return HOSTNAME or it will return  DEFAULT_ENV_INSTANCE if HOSTNAME is null.
     private String hostName;

     public String retriveInstanceOfInfo(){

          return hostName.substring(hostName.length()-5); // check here for substring https://beginnersbook.com/2013/12/java-string-substring-method-example/
     }



}
