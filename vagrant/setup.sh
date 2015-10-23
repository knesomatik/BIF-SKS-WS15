#!/usr/bin/env bash

# systemd script for wildfly
wildfly_startup='
[Unit]
Description=Wildfly Server
After=syslog.target
After=network.target

[Service]
Type=simple
ExecStart=/opt/jboss/wildfly/bin/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0
TimeoutSec=300
Restart=always
RestartSec=30

[Install]
WantedBy=multi-user.target
'

(
	# update system
	yum -y update

	# install java
	yum -y install java-1.8.0-openjdk

	# set wildfly variables
	export WILDFLY_VERSION="10.0.0.CR3"
	export WILDFLY_SHA1="c14453890657e05fae0e2765c9dca8a35b2b2096"
	export JBOSS_HOME="/opt/jboss/wildfly"

	# create dir
	mkdir -p $JBOSS_HOME

	# download, verify and install wildfly
	cd $HOME \
	&& curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
	&& sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
	&& tar xf wildfly-$WILDFLY_VERSION.tar.gz \
	&& mv $HOME/wildfly-$WILDFLY_VERSION/* $JBOSS_HOME/ \
	&& rm wildfly-$WILDFLY_VERSION.tar.gz

	# add user to wildfly
	/opt/jboss/wildfly/bin/add-user.sh -u x -p x

	# install and enable wildfly systemd service
	echo "$wildfly_startup" > /usr/lib/systemd/system/wildfly.service
	systemctl enable wildfly.service
	systemctl start wildfly.service

) | tee ~/setup.log

exit 0
