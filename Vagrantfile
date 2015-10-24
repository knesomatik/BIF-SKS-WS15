#
# Vagrant Config for SKS
#
Vagrant.configure(2) do |config|
	# start with centos 7
	config.vm.box = "centos/7"

	# options for parallels provider
	config.vm.provider "parallels" do |v, override|
		v.memory = 1024
		v.cpus = 2
		override.vm.box = "parallels/centos-7.1"
	end

	# options for virtualbox provider
	config.vm.provider "virtualbox" do |v|
		v.memory = 1024
		v.cpus = 2
	end

	# forward VM ports
	config.vm.network :forwarded_port, guest: 9990, host: 9990
	config.vm.network :forwarded_port	, guest: 8080, host: 9991

	# sync folder
	config.vm.synced_folder "vagrant/data", "/vagrant-data"
	config.vm.synced_folder "vagrant/logs/server", "/opt/jboss/wildfly/standalone/log"

	# set provisioning
	config.vm.provision "shell" do |s|
		s.keep_color = true
		s.path = "vagrant/setup.sh"
	end
end

