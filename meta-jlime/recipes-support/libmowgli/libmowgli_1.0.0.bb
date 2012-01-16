DESCRIPTION = "High-performance C development framework."
HOMEPAGE = "http://www.atheme.org/project/mowgli"
SECTION = "libs"

PR = "r0"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=e2a909529593b7b0d8d0afae18bbf060"

SRC_URI = "git://git.atheme.org/libmowgli;protocol=git;branch=master"
SRCREV = "${P}"

S = "${WORKDIR}/git"

inherit autotools 
