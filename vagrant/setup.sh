#!/usr/bin/env bash

# systemd script for wildfly
wildfly_startup='
[Unit]
Description=Wildfly server
After=syslog.target
After=network.target

[Service]
Type=simple
ExecStart=/opt/jboss/wildfly/bin/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0
TimeoutSec=300
Restart=on-failure
RestartSec=30

[Install]
WantedBy=multi-user.target
'

# update system
yum -y update
yum -y upgrade

# installjava
yum -y install java-1.8.0-openjdk

# set wildfly variables
export WILDFLY_VERSION="9.0.1.Final"
export WILDFLY_SHA1="abe037d5d1cb97b4d07fbfe59b6a1345a39a9ae5"
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

exit 0
