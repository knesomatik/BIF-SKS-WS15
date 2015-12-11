#
# Vagrant Config for SKS
#

unless Vagrant.has_plugin? 'vagrant-vbguest'
	print "\nvagrant-vbguest plugin must be installed\n- to install, just run 'vagrant plugin install vagrant-vbguest'\n\n"
	exit
end

Vagrant.configure(2) do |config|

	# start with centos 7
	config.vm.box = 'centos/7'

	# options for parallels provider
	config.vm.provider 'parallels' do |v, override|
		v.update_guest_tools = true
		v.memory = 2048
		v.cpus = 8
		v.customize ["set", :id, "--adaptive-hypervisor", "on"]
		override.vm.box = 'parallels/centos-7.1'
	end

	# options for virtualbox provider
	config.vm.provider 'virtualbox' do |v|
		v.memory = 1024
		v.cpus = 8
	end

	# forward VM ports
	config.vm.network :forwarded_port, guest: 9990, host: 9990
	config.vm.network :forwarded_port, guest: 8080, host: 9991
	config.vm.network :private_network, ip: '10.10.100.10'

	# sync folder
	config.vm.synced_folder 'vagrant/data', '/vagrant-data', nfs: false
	config.vm.synced_folder 'vagrant/logs', '/vagrant-logs', nfs: false

	# set provisioning
	config.vm.provision 'shell' do |s|
		s.keep_color = true
		s.path = 'vagrant/setup.sh'
	end
end

