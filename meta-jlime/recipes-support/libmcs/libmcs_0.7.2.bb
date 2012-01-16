DESCRIPTION = "Library abstracting the storage of configuration settings away from userland applications"
HOMEPAGE = "http://www.atheme.org/project/mcs"
SECTION = "libs"

PR = "r0"

DEPENDS = "libmowgli"
RDEPENDS = "gconf"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=4e50a03f9595c799ccc398d0bac5196a"

SRC_URI = "git://git.atheme.org/libmcs;protocol=git;branch=master"
SRCREV = "9fbfa161967c230f64a77c62c96f6648b1824ffa"

FILES_${PN} += "${libdir}/mcs/*.so"
FILES_${PN}-dbg += "${libdir}/mcs/.debug/*.so"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-kconfig --enable-gconf"

inherit autotools pkgconfig
