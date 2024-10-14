# Steps to work with kafka producer and consumer
This repository contains the below two project to demonstrate kafka producer and consumer process steps by steps. 

- kafka-consumer/src/main - Code for the kafka consumer service.
- kafka-producer/src/main - Code for the kafka producer service.

## Step 1.
 - Clone the repository to your local machine.
 - import the project to any tools(Intellij or Eclipse)
 - do the maven build on you local machine.
## Step 2.
  - install the zookeeper on local
  - open zookeeper.properties file and change the snapshot directoy.
      - dataDir=E:/kafka/zookeeper-data   
  - open server.properties and change the Listener
      - listeners=PLAINTEXT://localhost:9092
      - auto.create.topic.enable=false
  - open cmd and run the below command to start the zookeeper on your local machine.
      - .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
  - Open cmd and ru the below command to start the kafka server.
      - .\bin\windows\kafka-server-start.bat .\config\server.properties

  ## Step 3.
   - start kafka-consumer service.
  ## Step 4.
   - Start kafka-producer service.
  ## Step5. 
   - User below CURl to produce the message.
      - curl -X GET http://localhost:8080/publish?message=I%20am%20fine%20how%20about%20you%20ritesh
  
