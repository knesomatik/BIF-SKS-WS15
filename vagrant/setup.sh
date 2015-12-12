#!/usr/bin/env bash

# systemd script for wildfly
wildfly_startup='
[Unit]
Description=Wildfly Server
After=syslog.target
After=network.target

[Service]
Type=simple
ExecStart=/opt/jboss/wildfly/bin/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0 -Djboss.server.log.dir=/vagrant-logs
TimeoutSec=300
Restart=always
RestartSec=30

[Install]
WantedBy=multi-user.target
'

mariadb_repo='
# MariaDB 10.1 CentOS repository list - created 2015-12-12 14:48 UTC
# http://mariadb.org/mariadb/repositories/
[mariadb]
name = MariaDB
baseurl = http://yum.mariadb.org/10.1/centos7-amd64
gpgkey=https://yum.mariadb.org/RPM-GPG-KEY-MariaDB
gpgcheck=1
'

(
	# add mariadb repo
	echo "$mariadb_repo" > /etc/yum.repos.d/mariadb.repo

	# update system
	#yum -y distro-sync

	# install java
	# unfortunately we can't use java-headless, because then WildFly bugs araound -- TODO maybe investigate this further?
	yum -y install java-1.8.0-openjdk MariaDB-server MariaDB-client


#	sed -i 's/^\(bind-address\s.*\)/# \1/' /etc/my.cnf
# 	echo "mysqld_safe &" > /tmp/mariadb_config
#  	echo "mysqladmin --silent --wait=30 ping || exit 1" >> /tmp/mariadb_config
#  	echo "mysql -e 'GRANT ALL PRIVILEGES ON *.* TO root@localhost WITH GRANT OPTION;'" >> /tmp/mariadb_config
#  	bash /tmp/mariadb_config
#	rm -f /tmp/mariadb_config



	# set wildfly variables
	export WILDFLY_VERSION="9.0.2.Final"
	export JBOSS_HOME="/opt/jboss/wildfly"

	# create dir
	mkdir -p ${JBOSS_HOME}

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

	# get mariadb driver
	wget https://downloads.mariadb.com/enterprise/zph4-37nq/connectors/java/connector-java-1.3.3/mariadb-java-client-1.3.3.jar -O /opt/jboss/wildfly/standalone/deployments/mariadb-client.jar

	# add datasource
	/opt/jboss/wildfly/bin/jboss-cli.sh -c --command='data-source add --name=SKS_db --driver-name=mariadb-client.jar --driver-class=org.mariadb.jdbc.Driver  --jndi-name=java:jboss/datasources/SKS_db --connection-url="jdbc:mariadb://localhost:3306/sksdb?useUnicode=true&characterEncoding=UTF-8" --use-ccm=true --max-pool-size=25 --blocking-timeout-wait-millis=5000 --enabled=true  --user-name="root" '

	# restart mariadb
	systemctl restart mariadb.service

	# add db
	echo "create database sksdb" | mysql -uroot

	# remove exampleDS
	#/opt/jboss/wildfly/bin/jboss-cli.sh -c --command='data-source remove --name=ExampleDS'

	# restart wildfly
	systemctl restart wildfly.service

) | tee ~/setup.log

exit 0
