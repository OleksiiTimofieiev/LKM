SUMMARY = "bmp280 driver"
DESCRIPTION = "${SUMMARY}"
LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "file://Makefile \
           file://bmp280.c \
          "

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES:${PN} += "kernel-module-bmp280"

# python do_display_banner() {
#     bb.plain("*  otimofie recipe created by bitbake-layers   *");
# }

# addtask display_banner before do_build
