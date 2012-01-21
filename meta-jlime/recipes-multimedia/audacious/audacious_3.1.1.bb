DESCRIPTION = "Audacious Player - Yoyr music, your way, no exceptions"
HOMEPAGE = "http://audacious-media-player.org/"
SECTION = "multimedia"

PR = "r0"

DEPENDS = "libmowgli libmcs libguess glib-2.0 dbus-glib libxml2 pango gtk+ libsm"
RDEPENDS = "audacious-plugins-base"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=84c871515d3c467f8627056f5158dcc3"

SRC_URI = "http://distfiles.atheme.org/${P}.tar.bz2"
SRC_URI[md5sum] = "dd305072a8f9229409ff8c8c06469517"
SRC_URI[sha256sum] = "50e229579a0ee06e88d2b123c8db6b373db73e87898e8b4843a1bd02e3cab8ac"

EXTRA_OECONF = " \
    --disable-rpath \
    --enable-dbus \
    --disable-gtk3 \
    --enable-sm \
    --enable-chardet \
    "

FILES_${PN} += "${datadir}/icons/hicolor/*"

inherit autotools pkgconfig gettext
