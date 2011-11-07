DESCRIPTION="nuoveXT2 iconset"
HOMEPAGE="http://lxde.sf.net/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6a6a8e020838b23406c81b19c1d46df6"

RDEPENDS = "gtk+"
DEPENDS = "${RDEPENDS} pkgconfig-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "0c6ed34bb678f832345fc4495647a705"
SRC_URI[sha256sum] = "a75c0412033a0a0bf6b3912bb37409fbdae1b9a574f2821929aca8749e7ff3a3"

inherit autotools gettext

FILES_${PN} += "${datadir}/icons"
