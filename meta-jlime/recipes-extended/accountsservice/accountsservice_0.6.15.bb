DESCRIPTION = "D-Bus interfaces for querying and manipulating user account information"
HOMEPAGE="http://www.fedoraproject.org/wiki/Features/UserAccountDialog"
SECTION = "x11"

inherit gnome systemd

PR = "r5"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "glib-2.0 dbus-glib polkit gobject-introspection-native libxslt"

SRC_URI = "http://www.freedesktop.org/software/${PN}/${P}.tar.xz"
SRC_URI[md5sum] = "47b5af77b544528c02d82761bd574c09"
SRC_URI[sha256sum] = "9feb3d58c5c739f2df4b5410404b29f16e3f4aa6739b685ceb12903f4d5ea867"

PACKAGES += "accounts-daemon"
SYSTEMD_PACKAGES = "accounts-daemon-systemd"
SYSTEMD_SERVICE_accounts-daemon-systemd = "accounts-daemon.service"

FILES_accounts-daemon = " \
    ${libexecdir}/accounts-daemon \
    ${sysconfdir}/dbus-1/* \
    ${datadir}/dbus-1/* \
    ${datadir}/polkit-1/* \
    ${datadir}/${localstatedir}/lib/AccountsService \
    "
FILES_accounts-daemon-systemd = "${systemd_unitdir}"

EXTRA_OECONF = " \
    --disable-static \
    --disable-more-warnings \
    "
