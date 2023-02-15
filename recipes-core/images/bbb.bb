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
gdb \
gdbserver \
cmake \
bash \
usbutils \
packagegroup-core-buildessential \
python3-pip \
"

AWS = " \
aws-cli \
aws-iot-device-client \
aws-sdk-cpp \
aws-iot-device-sdk-cpp-v2 \
aws-iot-device-sdk-python-v2 \
aws-greengrass-core-sdk-c \
aws-greengrass-core-sdk-python \
"

FRONTEND = " \
nginx \
"

DRIVERS = " \
i2c-tools \
bmp280i2c \
"

TIME = " \
chrony \
chronyc \
"

TESTS = " \
tests \
"

IMAGE_INSTALL = " \
packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} \
${TIME} \
${SSH} \
${SSL} \
${LKM} \
${USB_WIFI} \
${AWS} \
${DRIVERS} \
${UTILS} \
${FRONTEND} \
${TESTS} \
"

IMAGE_LINGUAS = " "
IMAGE_FSTYPES = "wic"


LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES:remove += " \
debug-tweaks \
"

INHERIT += "extrausers"
EXTRA_USERS_PARAMS = "usermod -P pass root;"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
