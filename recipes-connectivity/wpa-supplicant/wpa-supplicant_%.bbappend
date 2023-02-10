
FILESEXTRAPATHS:append := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant.conf"
# SRC_URI += "file://wpa-supplicant.sh"
# SRC_URI += "file://defconfig"

inherit useradd

USERADD_PACKAGES = "${PN}"

GROUPADD_PARAM:${PN} = "--system netdev"

do_install:append() {
	install -d ${D}${sysconfdir}
	install -m 600 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant.conf
}