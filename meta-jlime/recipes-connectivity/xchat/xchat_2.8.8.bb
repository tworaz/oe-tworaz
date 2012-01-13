DESCRIPTION = "Full-featured IRC chat client with scripting support"
HOMEPAGE = "http://www.xchat.org"
SECTION = "x11/network"
PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"

DEPENDS = "gtk+ glib-2.0 openssl dbus-glib libnotify pango"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.bz2 \
           file://${PN}-input-box4.patch \
           file://${P}-libnotify07.patch \
           file://${P}-cflags.patch \
           "
SRC_URI[md5sum] = "6775c44f38e84d06c06c336b32c4a452"
SRC_URI[sha256sum] = "0d6d69437b5e1e45f3e66270fe369344943de8a1190e498fafa5296315a27db0"

EXTRA_OECONF = " \
    --disable-perl \
    --disable-python \
    --disable-tcl \
    --enable-shm \
    --enable-dbus \
    --enable-gtkfe \
    --enable-xft \
    ${@base_contains('DISTRO_FEATURES', 'ipv6', '--enable-ipv6', '',d)} \
    "

FILES_${PN} += "${datadir}/dbus-1"

inherit gettext pkgconfig autotools gtk-icon-cache

do_configure_prepend () {
	# use libdir/xchat/plugins as the plugin directory
	sed -i -e 's:${prefix}/lib/xchat:${libdir}/xchat:' "${S}"/configure.in \
        || bbfatal "Failed to change libdir"

	# xchat sourcecode ships with po/Makefile.in.in from gettext-0.17
	# which fails with >=gettext-0.18
	cp "${datadir_native}"/gettext/po/Makefile.in.in "${S}"/po/ \
        || bbfatal "Failed to replace Makefile.in.in"
}
