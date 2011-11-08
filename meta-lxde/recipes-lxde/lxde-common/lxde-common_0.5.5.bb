DESCRIPTION="LXDE Session default configuration files"
HOMEPAGE="http://lxde.sf.net/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=597980c597fe9ce16d7b6b19c44cfced"

RDEPENDS = "gtk+ lxde-icon-theme"
DEPENDS = "${RDEPENDS}"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz \
           file://lxde-common-0.5.5-logout.patch"
SRC_URI[md5sum] = "e51a6b2a815a89fda1f497b509465a97"
SRC_URI[sha256sum] = "ee18a09b64a442b33c1b54f0269649a1b4d9490460c400a07ed785d41bf6dde6"

inherit autotools pkgconfig update-alternatives

FILES_${PN} += "${datadir}/lxde/ ${datadir}/lxpanel ${datadir}/xsessions"

ALTERNATIVE_PATH = "${bindir}/startlxde"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "15"

