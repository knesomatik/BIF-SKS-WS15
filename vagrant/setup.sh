#!/usr/bin/env bash

# systemd script for wildfly
wildfly_startup='
[Unit]
Description=Wildfly Server
After=syslog.target
After=network.target

[Service]
Type=simple
User=root
Group=root
ExecStartPre=/usr/bin/chmod -R 777 /vagrant-data
ExecStartPre=/usr/bin/chmod -R 777 /vagrant-logs
ExecStart=/opt/jboss/wildfly/bin/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0 -Djboss.server.log.dir=/vagrant-logs -Djava.awt.headless=true
TimeoutSec=300
Restart=always
RestartSec=30

[Install]
WantedBy=multi-user.target
'

(
	# update system
	#yum -y update

	# install java
	yum -y install java-1.8.0-openjdk-headless

	# set wildfly variables
	export WILDFLY_VERSION="9.0.2.Final"
	export JBOSS_HOME="/opt/jboss/wildfly"

	# create dir
	mkdir -p ${JBOSS_HOME}

	chmod -R 777 /vagrant-data
	chmod -R 777 /vagrant-logs
	chmod -R 777 $JBOSS_HOME


	# download, verify and install wildfly
	cd $HOME \
	&& curl -O https://download.jboss.org/wildfly/${WILDFLY_VERSION}/wildfly-${WILDFLY_VERSION}.tar.gz \
	&& tar xf wildfly-${WILDFLY_VERSION}.tar.gz \
	&& mv $HOME/wildfly-${WILDFLY_VERSION}/* ${JBOSS_HOME}/ \
	&& rm wildfly-${WILDFLY_VERSION}.tar.gz

	# install and enable wildfly systemd service
	echo "$wildfly_startup" > /usr/lib/systemd/system/wildfly.service
	systemctl enable wildfly.service
	systemctl start wildfly.service

	# give wildfly some time to start up
	sleep 30

	# add user to wildfly
	/opt/jboss/wildfly/bin/add-user.sh -u x -p x

	# add datasource
	/opt/jboss/wildfly/bin/jboss-cli.sh -c --command='data-source add --name=SKS_db --driver-name=h2 --jndi-name=java:jboss/datasources/SKS_db --connection-url="jdbc:h2:/vagrant-data/SKS_db;DB_CLOSE_DELAY=-1" --use-ccm=true --enabled=true  --password="sa" --user-name="sa"'

	# remove exampleDS
	#/opt/jboss/wildfly/bin/jboss-cli.sh -c --command='data-source remove --name=ExampleDS'

	# restart wildfly
	systemctl restart wildfly.service

) | tee ~/setup.log

exit 0
