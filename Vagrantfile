#
# Vagrant Config for SKS
#

unless Vagrant.has_plugin? "vagrant-vbguest"
	print "\nvagrant-vbguest plugin must be installed\n- to install, just run 'vagrant plugin install vagrant-vbguest'\n\n"
	exit
end

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
	config.vm.network :forwarded_port, guest: 8080, host: 9991

	# sync folder
	config.vm.synced_folder "vagrant/data", "/vagrant-data"
	config.vm.synced_folder "vagrant/logs", "/vagrant-logs"

	# set provisioning
	config.vm.provision "shell" do |s|
		s.keep_color = true
		s.path = "vagrant/setup.sh"
	end
end

