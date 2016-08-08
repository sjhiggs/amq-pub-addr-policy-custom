Custom Published Address Strategy
=================================

Description
-----------
This project demonstrates the addition of a custom published address strategy for A-MQ.  This custom strategy allows you to configure the published hostname for an A-MQ broker in etc/activemq.xml.

Version
-------
This modification was originally developed and compiled for A-MQ 6.2.1-117.  Modify the pom.xml dependency as required for your installation.

Compile
-------
`mvn clean install`


Install
-------
~~~~
JBossA-MQ:karaf@root> osgi:install mvn:com.redhat.examples/my-published-address-strategy/1.0.0-SNAPSHOT
JBossA-MQ:karaf@root> la | grep activemq-osgi
[ 137] [Active     ] [Created     ] [       ] [   50] activemq-osgi (5.11.0.redhat-621117), Fragments: 153
JBossA-MQ:karaf@root> update 137
You are about to access system bundle 137.  Do you wish to continue (yes/no): yes
~~~~


Modify etc/activemq.xml
-----------------------
~~~~
<bean class="com.redhat.examples.broker.PublishedAddressPolicyHostnameConfig" id="addressPolicy">
        <property name="hostname" value="myamq-a-public.local" />
</bean>
...
<transportConnectors>
            <transportConnector name="openwire" publishedAddressPolicy="#addressPolicy"  uri="tcp://0.0.0.0:0?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600" updateClusterClients="true" rebalanceClusterClients="true" updateClusterClientsOnRemove="true"/>
</transportConnectors>
~~~~

Restart Container
-----------------
Restart the container to pick up the modified etc/activemq.xml
