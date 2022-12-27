# ETA API

This projects provides CLI and API to communicate with the eta heating systems (ETA Heiztechnik GmbH).

It is based on java 11 and micronaut.

ETA API Version 1.2 was used for implementation API documentation can be found https://www.meineta.at/javax.faces.resource/downloads/ETA-RESTful-v1.2.pdf.xhtml?ln=default&v=0

## Run CLI

To get all available options use

`./gradlew run --args="--help"`


To print the resource /user/menu use
`gradle run --args="-m -h example.com"`

This menu is also the starting point for printing all vars and there info

`gradle run --args="-mvi -h example.com"` will print the menu and all variables and their related info.
This comes in handy when you need to find the URI for a certain variable.

## API integration

For integration use `chpro.eta.api.client.ClientService` the methods will call the desired endpoint.
The `path` parameter is the uri without prefix `/usr/var` or `/usr/varinfo` e.g. `/40/10021/0/0/10990`.



## Micronaut 3.7.4 Documentation

- [User Guide](https://docs.micronaut.io/3.7.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.7.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.7.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
