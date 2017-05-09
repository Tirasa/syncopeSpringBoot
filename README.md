# Apache Syncope via Spring Boot

Three sample Spring Boot applications are provided, based on Apache Syncope 2.0.3 Jazz.

## core

After `cd core/`:

* `mvn -Pembedded` starts the Apache Syncope Core, available at http://localhost:9080/syncope/
* `mvn -Pembedded,all` features all available [extensions](https://syncope.apache.org/docs/reference-guide.html#extensions)

## console

This requires to configure an existing Syncope Core coordinates under `console/src/test/resources/console.properties`.

After `cd console/`:

* `mvn -Pembedded` starts the Apache Syncope Console, available at http://localhost:9080/syncope-console/
* `mvn -Pembedded,all` features all available [extensions](https://syncope.apache.org/docs/reference-guide.html#extensions)

## enduser

This requires to configure an existing Syncope Core coordinates under `enduser/src/test/resources/enduser.properties`.

After `cd enduser/`:

* `mvn -Pembedded` starts the Apache Syncope Enduser, available at http://localhost:9080/syncope-enduser/
* `mvn -Pembedded,all` features all available [extensions](https://syncope.apache.org/docs/reference-guide.html#extensions)
