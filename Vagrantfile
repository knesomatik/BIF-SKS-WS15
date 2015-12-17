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
		v.memory = 2048
		v.cpus = 4
	end

	config.vm.provider :libvirt do |libvirt|

		# A hypervisor name to access. Different drivers can be specified, but
		# this version of provider creates KVM machines only. Some examples of
		# drivers are kvm (qemu hardware accelerated), qemu (qemu emulated),
		# xen (Xen hypervisor), lxc (Linux Containers),
		# esx (VMware ESX), vmwarews (VMware Workstation) and more. Refer to
		# documentation for available drivers (http://libvirt.org/drivers.html).
		libvirt.driver = "kvm"

		# The name of the server, where libvirtd is running.
		# libvirt.host = "localhost"

		# If use ssh tunnel to connect to Libvirt.
		libvirt.connect_via_ssh = false

		# The username and password to access Libvirt. Password is not used when
		# connecting via ssh.
		libvirt.username = "root"
		#libvirt.password = "secret"

		# Libvirt storage pool name, where box image and instance snapshots will
		# be stored.
		libvirt.storage_pool_name = "default"

		# Set a prefix for the machines that's different than the project dir name.
		#libvirt.default_prefix = ''
	end

	# forward VM ports
	config.vm.network :forwarded_port, guest: 9990, host: 9990
	config.vm.network :forwarded_port, guest: 8080, host: 9991
	config.vm.network :forwarded_port, guest: 3306, host: 3307

	# sync folder
	#config.vm.synced_folder 'vagrant/data', '/vagrant-data', nfs: false
	config.vm.synced_folder 'vagrant/logs', '/vagrant-logs', nfs: false
	#config.vm.synced_folder 'vagrant/mysql', '/var/lib/mysql', nfs: false

	# set provisioning
	config.vm.provision 'shell' do |s|
		s.keep_color = true
		s.path = 'vagrant/setup.sh'
	end
end

