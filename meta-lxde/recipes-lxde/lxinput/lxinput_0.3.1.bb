DESCRIPTION = "LXDE keyboard and mouse configuration tool"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "glib-2.0 gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.gz"
SRC_URI[md5sum] = "948ad3371325f53bf8c4a7ed555558a4"
SRC_URI[sha256sum] = "b30f3be6cd250d548d40f9d2dcc5882ad5a2fe233149e90b96eab5b6e6e0a256"

inherit autotools gettext pkgconfig
