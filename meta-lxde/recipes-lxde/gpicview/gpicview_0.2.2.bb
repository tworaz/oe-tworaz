DESCRIPTION = "Simple Image Viewer for X"
HOMEPAGE = "http://lxde.sourceforge.net/gpicview"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "jpeg gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.gz"
SRC_URI[md5sum] = "943da9f4a23541accd5acdd4fb69966f"
SRC_URI[sha256sum] = "7c62e396804c2e97e3d6eea071dc1865eb207f2f499ca5ab35b2e768749d036c"

inherit autotools gettext pkgconfig
