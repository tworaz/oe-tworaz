DESCRIPTION = "LXDE desktop menu data"
HOMEPAGE = "http://lxde.sourceforge.net/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b99dd46479fb9eb2899071cd03f6cb86"

DEPENDS = "intltool-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "2184ab3746d572477f1bea7e98e230a8"
SRC_URI[sha256sum] = "34c285a0430404e815263a4bb33a79eb47b168c56469be0f7ffb19730a57a045"

inherit autotools gettext pkgconfig

FILES_${PN} += "${datadir}/desktop-directories/"

