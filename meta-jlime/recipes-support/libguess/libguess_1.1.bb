DESCRIPTION = "Fast character set detection library."
HOMEPAGE = "http://www.atheme.org/project/libguess"
SECTION = "libs"

PR = "r0"

DEPENDS = "libmowgli"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=be4f672df672e6a0fe09c2abe3ccbe98"

SRC_URI = "git://git.atheme.org/libguess;protocol=git;branch=master"
SRCREV = "${P}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
