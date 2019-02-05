# DadJokeGenerator

A command line application for creating dad jokes based on the all jokes downloaded from [icanhazdadjoke API](https://icanhazdadjoke.com/api) using Markov Chain text generator

## Prerequisites
1. [java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. [maven](https://maven.apache.org/install.html) 

For mac, both java 1.8 and maven can also be installed using homebrew

```
brew cask install java8
brew install maven
```

## Installation
Switch to project root directory,

To build the project:
```
mvn clean install
```

To generate new dad jokes with cached Markov Chain:
```
mvn exec:java -Pjoke
```
To recreate Markov chain based on jokes downloaded from [icanhazdadjoke API](https://icanhazdadjoke.com/api)
```
mvn exec:java -Pmodel
```




