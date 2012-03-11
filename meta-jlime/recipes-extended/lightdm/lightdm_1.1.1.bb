DESCRIPTION = "A lightweight display manager"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/LightDM"
SECTION = "x11"

PR = "r1"

LICENSE = "GPLv3 & LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "glib-2.0 libpam libxklavier libxml2 virtual/libx11"

SRC_URI = "http://launchpad.net/${PN}/trunk/${PV}/+download/${P}.tar.gz \
           file://${P}-disable-novtswitch.diff \
           file://${P}-oe-config.diff \
           file://Xsession \
           file://${PN}.pam \
           file://${PN}.service \
           file://${PN}.tmpfiles \
           file://${PN}.init \
           "
SRC_URI[md5sum] = "e42e1ac0b07b3591de44ff7b6daa6c7a"
SRC_URI[sha256sum] = "285b7df76cd580ccb11d606fdd4ec8dfc3751891485d81c654d063264c47fc29"

EXTRA_OECONF = " \
    --disable-static \
    --disable-introspection \
    --disable-tests \
    --with-user-session=xuser \
    --with-greeter-user=root \
    --with-greeter-session=lightdm-gtk-greeter \
    "

FILES_${PN}-dev += "${datadir}/vala/vapi/*"
FILES_${PN}-dbg += "${libexecdir}/${PN}/.debug/*"
#FILES_${PN}-systemd = "${systemd_unitdir}/system/${PN}.service \
#                       ${libdir}/tmpfiles.d/${PN}.conf"

inherit autotools pkgconfig gettext update-rc.d

#SYSTEMD_PACKAGES = "${PN}-systemd"
#SYSTEMD_SERVICE_${PN}-systemd = "${PN}.service"

INITSCRIPT_NAME = "lightdm"
INITSCRIPT_PARAMS = "start 9 5 2 . stop 20 0 1 6 ."

do_install_append () {
    # Remove useless la files
    find ${D} -type f -name '*.la' -exec rm -f {} +

    # In oe minimum-uid seems to be 1000
    sed -i -e "/minimum-uid/s:500:1000:" data/users.conf || bb_fatal "sed failed"

    install -d ${D}/${sysconfdir}/${PN}
    install -m 0644 ${S}/data/users.conf ${D}/${sysconfdir}/${PN}
    install -m 0644 ${S}/data/keys.conf ${D}/${sysconfdir}/${PN}
    install -m 0755 ${WORKDIR}/Xsession ${D}/${sysconfdir}/${PN}

    install -d ${D}/${sysconfdir}/pam.d
    install -m 0644 ${WORKDIR}/${PN}.pam ${D}/${sysconfdir}/pam.d/

    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/${PN}.init ${D}/${sysconfdir}/init.d/${PN}

#    install -d ${D}/${libdir}/tmpfiles.d
#    install -m 0644 ${WORKDIR}/${PN}.tmpfiles ${D}/${libdir}/tmpfiles.d/${PN}.conf

    rm -rf ${D}/${sysconfdir}/apparmor.d
    rm -rf ${D}/${sysconfdir}/init
}

RDEPENDS_${PN} = "accounts-daemon consolekit lightdm-gtk-greeter"
