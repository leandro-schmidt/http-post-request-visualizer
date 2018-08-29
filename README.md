# http-post-request-visualizer

Simple application to see the content of request sent via post to it.

Port of the application can be configured into the src/main/resources/application.properties file.

The URI to be called is /printPostReqHeadAndBody.

# Running

Just compile the application with maven, and run the generated jar file with:

java -jar http-post-request-visualizer-1.0.0.jar

Content of the requests received will be printed in the console window and also will be sent back to the caller.

Requires Java 8.
