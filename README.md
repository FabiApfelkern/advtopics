advtopics
=========

Configure Tomcat:
Open conf/context.xml and replace "<context>" with "<Context antiResourceLocking="true">"

Configure Maven:
Copy the settings.sample.xml as settings.xml to your user maven directory. (in most cases: userfolder/.m2/)