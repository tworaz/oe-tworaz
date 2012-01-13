DESCRIPTION = "Base package set for Jlime images."
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r3"

inherit task

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    ${PN}-cli \
    ${PN}-gui \
    "

RDEPENDS_${PN}-cli = " \
    file \
    htop \
    lsof \
    sudo \
    vim \
    "

RDEPENDS_${PN}-gui = " \
    claws-mail \
    epdfview \
    gcalctool \
    gnome-mplayer \
    leafpad \
    midori \
    pidgin \
    xarchiver \
    xchat \
    xnoise \
    "
