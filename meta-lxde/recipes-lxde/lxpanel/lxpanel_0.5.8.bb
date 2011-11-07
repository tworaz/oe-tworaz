DESCRIPTION = "LXDE Panel"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

RDEPENDS = "gtk+ menu-cache lxmenu-data libxmu libxpm alsa-lib"
DEPENDS = "${RDEPENDS}"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz \
           file://lxpanel-0.5.6-broken-apps.patch"
SRC_URI[md5sum] = "129fae75d1cd3983fd94542c573a70a1"
SRC_URI[sha256sum] = "6a3579d6f384c03a33a03e4d32016428c84eb0f2bc421704f724fe2cc015cddd"

inherit autotools gettext

EXTRA_OECONF += "--enable-alsa --with-x --with-plugins=all"

FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"
