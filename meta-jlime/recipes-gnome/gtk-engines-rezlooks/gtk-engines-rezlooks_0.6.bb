DESCRIPTION="Rezlooks GTK+ Engine"
HOMEPAGE="http://www.gnome-look.org/content/show.php?content=39179"
SECTION = "x11/themes"

PR = "r0"

DEPENDS = "gtk+"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI="http://www.gnome-look.org/CONTENT/content-files/39179-rezlooks-${PV}.tar.gz"
SRC_URI[md5sum] = "87b768eb372dd5065f9e36bf10245ac7"
SRC_URI[sha256sum] = "a7dbc45ba32b8f1f40a097d7bafbdff595464c4af16a5bbb9febf63d15cab699"

EXTRA_OECONF = "--enable-animation"

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/*.so"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug/*.so"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/engines/*"

S = "${WORKDIR}/rezlooks-${PV}"

inherit autotools pkgconfig
