# Copyright (C) 2011 Peter Tworek <tworaz666@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Tool for creating bootable images for Psion Teklogix NetBook Pro"
DEPENDS = "zlib-native"

SRCREV = "2a9036d5b67066f533c37c41f4c03cc7dc62214f"
PV = "0.1.99+git${SRCPV}"
PR = "r0"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=3775480a712fc46a69647678acb234cb"

SRC_URI = "git://github.com/tworaz/boost-img.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 boost-img ${D}${bindir}/boost-img
}
