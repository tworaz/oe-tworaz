DESCRIPTION = "LXDE Display Manager"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

PR = "r1"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "gtk+ consolekit libxcb ${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"

RCONFLICTS_${PN} = "xserver-nodm-init"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz \
           file://${P}-pam_console-disable.patch \
           file://${P}-git-fix-null-pointer-deref.patch \
           file://${P}-use-oe-pam-config.patch \
           file://${P}-use-xserver-script.patch \
           file://${P}-oe-xsession.patch \
           file://${P}-uclibc-friendly.patch \
           file://xinitrc \
           file://init"
SRC_URI[md5sum] = "8da1cfc2be6dc9217c85a7cf51e1e821"
SRC_URI[sha256sum] = "9e0d0a5672fcf31a18de8178ce73eab1723d6ae7097dfe41e9fe2c46e180cf08"

EXTRA_OECONF += "--enable-password --with-x --with-xconn=xcb"

inherit autotools pkgconfig gettext update-rc.d

INITSCRIPT_NAME = "lxdm"
INITSCRIPT_PARAMS = "start 9 5 2 . stop 20 0 1 6 ."

do_install_append () {
    rm ${D}/${sysconfdir}/pam.d/lxdm
    install -d ${D}/${sysconfdir}/lxdm
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/xinitrc ${D}/${sysconfdir}/lxdm
    install -m 0755 ${WORKDIR}/init ${D}/etc/init.d/lxdm
}
