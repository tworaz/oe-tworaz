DESCRIPTION = "Base package set for Jlime GUI images."
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r2"

inherit task

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    ${PN}-cli \
    ${PN}-gui \
    "

RDEPENDS_${PN}-cli = " \
    htop \
    lsof \
    file \
    vim \
    "

RDEPENDS_${PN}-gui = " \
    leafpad \
    gcalctool \
    epdfview \
    midori \
    claws-mail \
    pidgin \
    "
