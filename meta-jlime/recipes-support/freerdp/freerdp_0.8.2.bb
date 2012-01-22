# Copyright (C) 2010, 2011 O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

DESCRIPTION = "FreeRDP RDP client"
HOMEPAGE = "http://www.freerdp.com"
DEPENDS = "virtual/libx11 openssl libxcursor libxv cups alsa-lib pcsc-lite"
SECTION = "x11/network"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=c9904273735f3141c1dd61533e02246a"

SRC_URI="${SOURCEFORGE_MIRROR}/${PN}/0.8/${P}.tar.gz"
SRC_URI[md5sum] = "cde590336292c977dfc1b4b7badf24d2"
SRC_URI[sha256sum] = "389a707b491bd1905c8395ede3df61ac73a55d866f8a56354c6442c23c8730e1"

INC_PR = "r1"

inherit pkgconfig autotools

EXTRA_OECONF += "--with-smartcard --with-xvideo --without-pulseaudio"

do_install_append() {
	rm ${D}${libdir}/freerdp/*.a ${D}${libdir}/freerdp/*.la
}

PACKAGES =+ "libfreerdp"

LEAD_SONAME = "libfreerdp.so"
FILES_libfreerdp = "${libdir}/lib*${SOLIBS}"

PACKAGES_DYNAMIC = "libfreerdp-plugin-*"

do_configure_append () {
	cp ${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool ${S}/libtool
}

python populate_packages_prepend () {
        freerdp_root = bb.data.expand('${libdir}/freerdp', d)

        do_split_packages(d, freerdp_root, '^(audin_.*)\.so$',
                output_pattern='libfreerdp-plugin-%s',
                description='FreeRDP plugin %s',
                prepend=True, extra_depends='libfreerdp-plugin-audin')

        do_split_packages(d, freerdp_root, '^(rdpsnd_.*)\.so$',
                output_pattern='libfreerdp-plugin-%s',
                description='FreeRDP plugin %s',
                prepend=True, extra_depends='libfreerdp-plugin-rdpsnd')

        do_split_packages(d, freerdp_root, '^(tsmf_.*)\.so$',
                output_pattern='libfreerdp-plugin-%s',
                description='FreeRDP plugin %s',
                prepend=True, extra_depends='libfreerdp-plugin-tsmf')

        do_split_packages(d, freerdp_root, '^([^-]*)\.so$',
                output_pattern='libfreerdp-plugin-%s',
                description='FreeRDP plugin %s',
                prepend=True, extra_depends='')
}
