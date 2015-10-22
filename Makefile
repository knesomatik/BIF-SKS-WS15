deploy:
	mvn install wildfly:deploy
	echo "app running on localhost:9991"

redeploy:
	mvn install wildfly:redeploy
	echo "app running on localhost:9991"
