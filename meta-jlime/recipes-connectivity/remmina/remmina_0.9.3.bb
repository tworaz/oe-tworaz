DESCRIPTION="A GTK+ RDP, VNC, XDMCP and SSH client"
HOMEPAGE="http://remmina.sourceforge.net/"
SECTION = "x11/network"
PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "gtk+ libgcrypt vte libunique libssh"
RDEPENDS = "remmina-plugins"

SRC_URI="${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
SRC_URI[md5sum] = "c87004a70ec62acbae732e8d47f71ba7"
SRC_URI[sha256sum] = "ea10eba6f60676f7ebfebd285884e41fbb081f3809064588564f53624a3cee82"

EXTRA_OECONF = " \
    --enable-gcrypt \
    --enable-ssh \
    --enable-unique \
    --enable-vte \
    "

inherit gettext pkgconfig gtk-icon-cache autotools
