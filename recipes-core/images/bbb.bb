SUMMARY = "LKM image"

USB_WIFI = " \
wpa-supplicant \
iw \
linux-firmware-mt7601u \
"

SSH = " \
libssh \
openssh \
openssh-keygen \
openssh-scp \
openssh-ssh \
openssh-sshd \
openssh-misc \
"

SSL = " \
openssl \
openssl-bin \
openssl-conf \
openssl-engines \
"

LKM = " \
kernel-devicetree \
kernel-modules \
kernel-dev \
kernel-devsrc \
"

UTILS = " \
curl \
grep \
gzip \
vim \
git \
nfs-utils \
nfs-utils-client \
gcc \
g++ \
make \
cmake \
bash \
usbutils \
packagegroup-core-buildessential \
"

AWS = " \
aws-iot-device-sdk-python-v2 \
python3-pip \
"

DRIVERS = " \
i2c-tools \
bmp280i2c \
"

IMAGE_INSTALL = " \
packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} \
chrony \
chronyc \
${SSH} \
${SSL} \
${LKM} \
${USB_WIFI} \
${AWS} \
${DRIVERS} \
tests \
"

IMAGE_LINGUAS = " "
IMAGE_FSTYPES = "wic"


LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
