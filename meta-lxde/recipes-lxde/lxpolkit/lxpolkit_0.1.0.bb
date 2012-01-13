DESCRIPTION = "Simple PolicyKit authentication agent"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "glib-2.0 gtk+ polkit"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.gz"
SRC_URI[md5sum] = "2597b00035fe1d695219e0f9bfa8c26f"
SRC_URI[sha256sum] = "511affca8f55adc67031fb3627b9889064c685e4b983737d8deecdf4f94f008b"

inherit autotools gettext pkgconfig
