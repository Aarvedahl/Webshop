Vagrant.configure("2") do |config|
	config.vm.provider "virtualbox" do |v|
		v.memory = 1024
		v.cpus = 1
	end
	config.vm.box = "ubuntu/trusty64"
	config.vm.network "forwarded_port", guest: 8080, host: 18080
	config.vm.network "forwarded_port", guest: 5432, host: 15432
	config.vm.provision "docker", run: "always" do|d|
        d.build_image "-t webshop /vagrant"
	    d.run "webshop",
	        args: "-p 8080:8080"
	end
	config.vm.provision "docker" do |d|
	    d.run "postgres",
	        args: "-p 5432:5432"
	end
end
