FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
PRINC = "1"

SRC_URI_append = " \
	file://Xserver.netbookpro.patch \
    file://Xserver.fbset-path.patch \
    "
