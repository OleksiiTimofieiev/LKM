SUMMARY = "LKM image"

USB_WIFI = " \
    wpa-supplicant \
    iw \
    linux-firmware-mt7601u \
"

IMAGE_INSTALL = " \
packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} \
vim \
git \
aws-iot-device-sdk-python-v2 \
libssh \
openssh \
openssh-keygen \
openssh-scp \
openssh-ssh \
openssh-sshd \
openssh-misc \
openssl \
openssl-bin \
openssl-conf \
openssl-engines \
chrony \
chronyc \
python3-pip \
curl \
grep \
gzip \
kernel-devicetree \
kernel-modules \
kernel-dev \
kernel-devsrc \
bmp280 \
i2c-tools \
packagegroup-core-buildessential \
nfs-utils \
nfs-utils-client \
cmake \
bash \
usbutils \
${USB_WIFI} \
"

IMAGE_LINGUAS = " "
IMAGE_FSTYPES = "wic"


LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
