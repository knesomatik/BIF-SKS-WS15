ENV['VAGRANT_DEFAULT_PROVIDER'] = 'virtualbox'

Vagrant.configure(2) do |config|
	config.vm.box = "centos/7"

	config.vm.provider "virtualbox" do |v|
		v.memory = 1024
		v.cpus = 1
	end

	config.vm.network :forwarded_port, guest: 9990, host: 9990
	config.vm.network :forwarded_port, guest: 8080, host: 9991

	config.vm.provision "shell" do |s|
		s.keep_color = true
		s.path = "vagrant/setup.sh"
	end

	config.vm.synced_folder ".", "/vagrant"
end
