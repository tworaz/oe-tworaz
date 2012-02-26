DESCRIPTION="A portable, efficient middleware for different kinds of mail access."
HOMEPAGE = "http://www.etpan.org"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=f18ebe7e452708c26f83954f81062ba7"

DEPENDS = "gnutls"

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/libetpan/libetpan-${PV}.tar.gz"
SRC_URI[md5sum] = "6fee60d08506e941642b8fa087e60b07"
SRC_URI[sha256sum] = "ce3ac567d0f07e5b2d1fdb0045042a8295ec477cd933de1a391fd48139c1f75e"

inherit autotools pkgconfig gettext binconfig

EXTRA_OECONF = "\
	--without-openssl \
    --with-gnutls \
    --disable-db \
    ${@base_contains('DISTRO_FEATURES', 'ipv6', '--enable-ipv6', '--disable-ipv6', d)} \
    "

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${bindir} ${includedir} ${libdir}/lib*.so ${libdir}/*.la ${libdir}/pkgconfig"
FILES_${PN}-staticdev = "${libdir}/*.a"
