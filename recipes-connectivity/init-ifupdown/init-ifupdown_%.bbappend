FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# SRC_URI += "file://set-mac-address"

# do_install:append() {
# 	install -d ${D}/${sysconfdir}/network/if-pre-up.d
# 	install -m 0755 ${WORKDIR}/set-mac-address ${D}${sysconfdir}/network/if-pre-up.d
# }