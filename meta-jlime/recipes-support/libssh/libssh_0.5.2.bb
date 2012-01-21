DESCRIPTION="Access a working SSH implementation by means of a library"
HOMEPAGE="http://www.libssh.org/"
SECTION = "libs"

PR = "r0"

DEPENDS = "zlib openssl libgcrypt"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=388a4fb1dea8ceae0be78ba9b01fc139"

SRC_URI="https://red.libssh.org/attachments/download/27/${P}.tar.gz \
         file://${PN}-0.5.0-no-pdf-doc.patch \
         file://${PN}-0.5.0-tests.patch"
SRC_URI[md5sum] = "38b67c48af7a9204660a3e08f97ceba6"
SRC_URI[sha256sum] = "41e8b9c1af077544625e8b398582f101dacc3b8457fee1811a724ca4245ab227"

OECMAKE_BUILDPATH = "${S}/build"
OECMAKE_SOURCEPATH = "${S}"
EXTRA_OECMAKE = " \
    -DWITH_GCRYPT=1 \
    -DWITH_PCAP=1 \
    -DWITH_SFTP=1 \
    -DWITH_ZLIB=1 \
    "
EXTRA_OEMAKE = "-C ${OECMAKE_BUILDPATH}"

inherit cmake

do_configure_prepend () {
	sed -i -e '/add_subdirectory(examples)/s/^/#DONOTWANT/' CMakeLists.txt || bb_fatal "sed failed"
}
