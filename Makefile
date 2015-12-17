deploy:
	mvn -B -T 2C clean -Dmaven.test.skip=true
	mvn -B -T 2C install wildfly:deploy -Dmaven.test.skip=true
	echo "app running on localhost:8080"

up:
	vagrant up

forceup:
	vagrant destroy --force; vagrant up --provision
