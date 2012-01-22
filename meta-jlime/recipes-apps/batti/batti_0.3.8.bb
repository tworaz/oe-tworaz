DESCRIPTION="A upower based battery monitor for the system tray, similar to batterymon"
HOMEPAGE="http://code.google.com/p/batti-gtk/"
SECTION = "x11/network"
PR = "r0.4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "libnotify"
RDEPENDS = "hicolor-icon-theme upower python-pygtk python-dbus"

SRC_URI="http://batti-gtk.googlecode.com/files/${P}.tar.gz"
SRC_URI[md5sum] = "4b239ead1643c95a6d89c380bc167781"
SRC_URI[sha256sum] = "a63f99bc63dad743abef18ac666e11247011cf9136a11286b131467d9f484d1c"

inherit gtk-icon-cache distutils

FILES_${PN} += " ${datadir}/icons/hicolor/* ${datadir}/applications/${PN}.desktop"
