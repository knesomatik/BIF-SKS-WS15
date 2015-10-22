#!/usr/bin/env bash

wildfly_startup='
[Unit]
Description=Wildfly server
After=syslog.target
After=network.target

[Service]
Type=simple
ExecStart=/opt/jboss/wildfly/wildfly-9.0.1.Final/bin/standalone.sh -b 0.0.0.0
TimeoutSec=300

[Install]
WantedBy=multi-user.target
'

yum -y update
yum -y upgrade

yum -y install java-1.8.0-openjdk

# Set the WILDFLY_VERSION env variable
export WILDFLY_VERSION="9.0.1.Final"
export WILDFLY_SHA1="abe037d5d1cb97b4d07fbfe59b6a1345a39a9ae5"
export JBOSS_HOME="/opt/jboss/wildfly"

mkdir -p $JBOSS_HOME

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
cd $HOME \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz

echo "$wildfly_startup" > /usr/lib/systemd/system/wildfly.service
systemctl enable wildfly.service
systemctl start wildfly.service

exit
