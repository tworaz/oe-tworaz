DESCRIPTION="Notification daemon"
HOMEPAGE="http://git.gnome.org/browse/notification-daemon/"
SECTION = "x11/misc"
PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "gtk+ glib-2.0 libcanberra libnotify virtual/libx11 dbus-glib libwnck"
RDEPENDS = "dbus"

SRC_URI[archive.md5sum] = "18919b2aa2a88b71a40f59393edf70d0"
SRC_URI[archive.sha256sum] = "aa1d3546fd1d5c51087317f4921c419927b644c12c39b557c959c9b45deb1475"

EXTRA_OECONF = "--disable-static"

FILES_${PN} += "\
    ${datadir}/dbus-1/services/* \
    ${libdir}/${PN}-1.0/engines/* \
    "
FILES_${PN}-dbg += "${libdir}/${PN}-1.0/engines/.debug/*"

inherit gettext gnome
