# not a "real" Makefile - just some commands to make our life easier

deploy:
	mvn -T 2C install wildfly:deploy
	echo "app running on localhost:9991"

redeploy:
	mvn -T 2C install wildfly:redeploy
	echo "app running on localhost:9991"

up:
	vagrant up

forceup:
	vagrant destroy --force; vagrant up --provision
