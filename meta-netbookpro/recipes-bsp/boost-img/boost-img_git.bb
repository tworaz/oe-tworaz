# Copyright (C) 2011 Peter Tworek <tworaz666@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Tool for creating bootable images for Psion Teklogix NetBook Pro"
DEPENDS = "zlib-native"

SRCREV = "a04194c06b63d60b2db137c69b5fe359c0659a13"
PV = "0.1.99+git${SRCPV}"
PR = "r0"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=454d9914f9ad7daf446a82976f7ea7e3"

SRC_URI = "git://github.com/tworaz/boost-img.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 boost-img ${D}${bindir}/boost-img
}
