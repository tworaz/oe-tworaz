DESCRIPTION = "Base package set for Jlime images."
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r8"

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
    tmux \
    vim \
    "

RDEPENDS_${PN}-gui = " \
    abiword \
    claws-mail \
    epdfview \
    gcalctool \
    gnumeric \
    gnome-mplayer \
    leafpad \
    liferea \
    midori \
    pidgin \
    remmina \
    xarchiver \
    xchat \
    "
