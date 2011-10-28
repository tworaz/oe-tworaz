require xserver-kdrive.inc

DEPENDS += "libxkbfile libxcalibrate font-util pixman"

RDEPENDS_${PN} += "xkeyboard-config"

DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	file://crosscompile.patch \
    file://fix_open_max_preprocessor_error.patch \
	file://macro_tweak.patch \
    file://xepson-support.patch \
	"
#	file://optional-xkb.patch \


SRC_URI[md5sum] = "4cdf54dc569b6a5548257c93a45dcd3d"
SRC_URI[sha256sum] = "c069c177d9a80bca2ee1d49aa1af6d9f996c83e4ff12393cab2ca3f8817276f6"
LIC_FILES_CHKSUM = "file://COPYING;md5=74df27b6254cc88d2799b5f4f5949c00"

S = "${WORKDIR}/xorg-server-${PV}"
