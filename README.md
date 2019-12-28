
# Github Profiler

## Version ##

`0.0.1`


## Summary ##

API Application built to search user profiles from Github based on their git handle

App is built with Java, Spring as a standalone Springboot application.

Getting started:

* [Prerequisites](#markdown-header-prerequisites)
* [Configuration](#markdown-header-configuration)
* [Build](#markdown-header-build)
* [Manual Test](#markdown-header-manualtest)
* [Run](#markdown-header-run)
* [Release Log](#markdown-header-releaselog)
* [Contact](#markdown-header-authors)




## Prerequisites

Ensure local installation of following softwares/tools:

* JDK - 1.8
* Git (2.9.0 or higher) - only for cloning project from repository

## Configuration

Below is the sample configuration for setting up app on machine.

* For **local** execution, one can change **application.properties**

| Env Property                            | Default Value                                                             | Description                                                                    |
|-----------------------------------------|---------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| server.port                             | 51002                                                                     | Http port  |
| server.contextPath                   | /                                                                      | The server context path                                           |
| spring.security.oauth2.client.registration.github.client_id    | e793638c2903853857ef | The github client id of registered app                               |
| spring.security.oauth2.client.registration.github.client-secret   | 531558889ec59e***************                                                                     | The github client secret                          |
| spring.datasource.url | jdbc:h2:mem:GITHUB_PROFILES                                                            | The Jdbc connection url              |
| spring.datasource.username               | test                                                                   | The database username           |
| spring.datasource.password                            | test                                                            | The database password                                                       |
 

## Build

Open your command/shell terminal

~~~bash
# CD into project folder
cd github-profiler

# Build package(downloading dependencies)
mvn clean install
~~~
Verify that it generates below artifacts:

* ./github-profiler/target/github-profiler-*.jar


---

## Manual Test

### Prerequisites

* Make sure port `51002` is not already used.
* Start the application locally

~~~bash
1.Go to localhost:51002
2.App will prompt you to submit your Github user credentials
3.Once credentials are validated, app will ask you for authorization
4.Once authorized you will see a search box which can be used to find github users based on githandle
5.Search history will be visible below search results
~~~

---


## Run

### Local

* Springboot jar doesn't need specific deployment, as it can run as standalone application.

~~~
Example:-

java -jar github-profiler-0.0.1.jar
~~~

---

## ReleaseLog

`0.0.1`

* First Version


## Authors

**Pranshu Shrivastava**