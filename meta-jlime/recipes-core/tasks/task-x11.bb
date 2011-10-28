DESCRIPTION = "Tasks for X11 support"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r1"

PACKAGES = "\
    task-x11-core \
    task-x11-core-dev \
    task-x11-core-dbg \
    "

PACKAGE_ARCH = "${MACHINE_ARCH}"

XSERVER ?= "xserver-kdrive-fbdev"

ALLOW_EMPTY = "1"

RDEPENDS_task-x11-core = "\
    dbus \
    pointercal \
    ${XSERVER} \
    x11-common \
    xserver-nodm-init \
    liberation-fonts \
    xauth \
    xhost \
    xset \
    xrandr \
    "
