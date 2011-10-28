# Copyright (C) 2011 Peter Tworek <tworaz666@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Useful shell aliases"

PV = "1.0"
PR = "r0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://aliases.sh"

do_install () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 ${WORKDIR}/aliases.sh ${D}${sysconfdir}/profile.d/
}

