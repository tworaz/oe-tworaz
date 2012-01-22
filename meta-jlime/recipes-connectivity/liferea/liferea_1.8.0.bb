DESCRIPTION="News Aggregator for RDF/RSS/CDF/Atom/Echo feeds"
HOMEPAGE="http://liferea.sourceforge.net/"
SECTION = "x11/network"
PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "gtk+ glib-2.0 pango libunique json-glib libxml2 libxslt sqlite3 webkit-gtk libnotify"

SRC_URI="${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
SRC_URI[md5sum] = "6313e3049b586be110c9402900609fe0"
SRC_URI[sha256sum] = "0b5f4afa0cf5b9b93ce5e069747646b674ee414e6e0e637d975c09acf798ee37"

EXTRA_OECONF = " \
    --enable-sm \
    --disable-schemas-install \
    --enable-libnotify \
    "

inherit gettext pkgconfig gtk-icon-cache autotools gconf
