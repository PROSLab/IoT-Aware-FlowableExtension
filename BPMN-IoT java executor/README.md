# BPMN-IoT

This is the repository for the project BPMN-IoT. This project uses an IoT extension package .jar for extend BPMN 2.0 using Flowable Engine and Flowable designer
For testing these notations, the Virutal Lab version of IoTify.io is used to simulate a RaspberryPI linked with sensors and actuators.

# Setup

## Define the virtual environment on IoTify

__1)__ In the Virtual Lab section of IoTify create a new project selecting "Raspian Jessy" as Target OS and deploy the project for the virtual environment.\
__2)__ To manage communications between the application and IoT devices, dweet.io must be used for "publish-subscribe" the data. 
Then install the "dweepy" package inside the virtual environment with the command:

```
sudo pip install dweepy
```

__3)__ Create a new python file and initialize the simulated devices. (An example can be found in the */IoTify* folder of the project)

## Process Enactment

__1)__ In the Eclipse environment install the Flowable Designer package\
__2)__ Create a new Flowable project and a new Flowable Diagram\
__3)__ Model the diagram with the custom extensions\

## System Architecture

Format: ![Alt Text](https://github.com/IvanComp/BPMN-IoT/tree/master/src/main/resources/schemaIoTBPMN.png?raw=true)
