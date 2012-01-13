DESCRIPTION = "LXDE session autostart editor"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "glib-2.0 gtk+"
RDEPENDS = "lxde-common lxsession"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.gz"
SRC_URI[md5sum] = "1e763a9b7f297ba964cd41b30edfccd7"
SRC_URI[sha256sum] = "558088aa8e0219a71a003fc0a66941cc828635615873b043e4ad239fc0889c5e"

inherit autotools gettext pkgconfig

