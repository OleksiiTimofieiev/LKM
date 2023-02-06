init:
	@ . /opt/poky/4.0.6/environment-setup-cortexa8hf-neon-poky-linux-gnueabi 

git:
	@ git add . && git commit -m "update" && git push