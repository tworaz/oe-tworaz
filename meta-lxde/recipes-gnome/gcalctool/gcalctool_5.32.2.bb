DESCRIPTION = "Powerful calculator for GNOME"
HOMEPAGE = "http://calctool.sourceforge.net/"
SECTION = "x11"

PR = "r2"

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "gtk+ gnome-doc-utils"
RDEPENDS = "glib-2.0-utils"

SRC_URI = "http://download.gnome.org/sources/${PN}/5.32/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "edc7227b9c9cf8c4114918b84dab11b6"
SRC_URI[sha256sum] = "307b277785b656a45c37a77e891caaa4ff21e9919fd7ab58148874c98f4d37d2"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-gnome"

FILES_${PN} += "${datadir}/glib-2.0"

pkg_postinst_${PN} () {
if [ -n "$D" ]; then
    exit 1
fi

glib-compile-schemas ${datadir}/glib-2.0/schemas
}
