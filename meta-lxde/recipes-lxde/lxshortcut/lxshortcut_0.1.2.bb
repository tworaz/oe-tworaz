DESCRIPTION = "LXDE tool to edit desktop entry files"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "glib-2.0 gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.gz"
SRC_URI[md5sum] = "72f0dfafa8098be853beae6e33b5e13b"
SRC_URI[sha256sum] = "8097f2522657374162a4e5e3c58898fe0c367e307b0ff4c50848b6b0323409fe"

inherit autotools gettext pkgconfig
