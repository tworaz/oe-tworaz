DESCRIPTION="Set of plugins for Remmina GTK+ RDP, VNC, XDMCP and SSH client"
HOMEPAGE="http://remmina.sourceforge.net/"
SECTION = "x11/network"
PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "freerdp libssh gnutls telepathy-glib remmina"
RDEPENDS = "xserver-kdrive-epson"

SRC_URI="${SOURCEFORGE_MIRROR}/remmina/${P}.tar.gz \
         file://${PN}-crosscompile.patch"
SRC_URI[md5sum] = "6f6b7cb18f7604f3f17eeda5173ede6a"
SRC_URI[sha256sum] = "f2df73a3a8f678f8c186755572072a744302b03b949a328ae1522f8bbb6da762"

EXTRA_OECONF = " \
    --enable-rdp \
    --enable-ssh \
    --enable-vnc \
    --enable-xdmcp \
    --disable-nx \
    --disable-static \
    "

FILES_${PN} += "\
    ${datadir}/remmina/icons/* \
    ${datadir}/dbus-1/services/* \
    ${datadir}/telepathy/* \
    ${libdir}/remmina/plugins/*.so \
    ${libdir}/remmina/plugins/*.la \
    "

FILES_${PN}-dbg += "\
    ${libdir}/remmina/plugins/.debug/*.so \
    "

inherit autotools gettext pkgconfig gtk-icon-cache
