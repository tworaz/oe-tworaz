DESCRIPTION="library for creating vnc servers"
HOMEPAGE="http://libvncserver.sourceforge.net/"
SECTION = "libs"

PR = "r0"

DEPENDS = "zlib libgcrypt gnutls jpeg"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=361b6b837cad26c6900a926b62aada5f"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz \
           file://${PN}-disable-x11vnc.diff"
SRC_URI[md5sum] = "dfed1dcc25cb338c7fdbcda2c3df7f50"
SRC_URI[sha256sum] = "2d243cd4b8d7f09a26b5d65e74375cedc85f3298621540a0724bde7e0fa1eaff"

S = "${WORKDIR}/LibVNCServer-${PV}"

EXTRA_OECONF = "\
    --without-x11vnc \
    --without-24bpp \
    ${@base_contains('DISTRO_FEATURES', 'ipv6', '--with-ipv6', '',d)} \
    --with-jpeg \
    --with-pthread \
    --with-zlib \
    "

inherit autotools

do_configure_prepend () {
	sed -i -r -e '/^CFLAGS =/d' Makefile.in || bb_fatal "sed failed"
}

do_configure_append () {
	cp ${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool ${S}/libtool
}
