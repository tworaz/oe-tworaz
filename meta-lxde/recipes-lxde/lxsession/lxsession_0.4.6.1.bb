DESCRIPTION = "LXDE session manager"
HOMEPAGE = "http://lxde.sf.net/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a76102f7f48780284bee49e6edaeb5a9"

COMMON_DEPENDS = "gtk+ glib-2.0 lxde-common dbus"
DEPENDS = "${COMMON_DEPENDS} xproto virtual/libx11"
RDEPENDS = "${COMMON_DEPENDS} upower"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "e456b64c5ab3652a4dec661ec706dc6e"
SRC_URI[sha256sum] = "bd6a7ef3c0ba4b9eedf3c58624dbce8bbbba3b179abbc552bf10c2830eec3ee1"

inherit autotools gettext

EXTRA_OECONF += "--enable-dbus"

#RPROVIDES_${PN} = "lxsession-lite"
FILES_${PN} += "${datadir}/lxsession"

