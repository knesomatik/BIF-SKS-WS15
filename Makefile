# not a "real" Makefile - just some commands to make our life easier

deploy:
	mvn install wildfly:deploy
	echo "app running on localhost:9991"

redeploy:
	mvn install wildfly:redeploy
	echo "app running on localhost:9991"

up:
	vagrant up

forceup:
	vagrant destroy --force; vagrant up --provision
