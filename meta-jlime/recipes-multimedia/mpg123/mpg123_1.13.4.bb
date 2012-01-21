DESCRIPTION = "Realtime MPEG 1.0/2.0/2.5 audio player for layers 1,2 and 3"
HOMEPAGE = "http://www.mpg123.org/"
SECTION = "multimedia"

PR = "r1"

DEPENDS = "alsa-lib"

LICENSE = "GPLv2 | LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a7aa23a2b646eca38ad4eeb7a853761c"

SRC_URI = "http://www.mpg123.org/download/${P}.tar.bz2"
SRC_URI[md5sum] = "073620b3938c4cb9c4f70e8fe3e114b8"
SRC_URI[sha256sum] = "f7ec51069ad0d6ac589d78ee431fbf7a4874f9c7338f01b67964640305e627c3"

OPTIMIZE_CPU = "generic_fpu"
OPTIMIZE_CPU_arm = "arm_nofpu"

ARM_INSTRUCTION_SET = "arm"

EXTRA_OECONF = "\
    --with-audio=alsa \
    --with-default-audio=alsa \
    --enable-network \
    ${@base_contains('DISTRO_FEATURES', 'ipv6', '--enable-ipv6', '',d)} \
    --enable-cpu=${OPTIMIZE_CPU} \
    "

PACKAGES =+ "${PN}-player ${PN}-player-dbg"
FILES_${PN}-player = "${bindir}/${PN}"
FILES_${PN}-player-dbg = "${bindir}/.debug/${PN}"

inherit autotools pkgconfig
