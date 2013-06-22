advtopics
=========

Configure Tomcat:
Open conf/context.xml and replace <context> with <Context antiResourceLocking="true">

Configure pom.xml:
Change "todir" to your Tomcat Webapps directory