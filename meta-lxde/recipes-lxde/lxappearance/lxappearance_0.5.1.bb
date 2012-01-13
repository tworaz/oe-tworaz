DESCRIPTION = "LXDE GTK+ theme switcher"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.gz"
SRC_URI[md5sum] = "34d157a7fe97ef0b93db8fab3f251e07"
SRC_URI[sha256sum] = "74e638257092201a572f1fcd4eb93c195c9fa75e27602662de542b002e6deade"

inherit autotools gettext pkgconfig
