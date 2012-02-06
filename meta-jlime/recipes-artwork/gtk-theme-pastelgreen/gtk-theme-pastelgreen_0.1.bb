DESCRIPTION = "Rezlooks pasteelgreen theme"
HOMEPAGE = "http://xfce-look.org/content/show.php/Rezlooks-pastelgreen?content=40990"
SECTION = "x11/themes"

inherit allarch

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://gtk-2.0/gtkrc;md5=a45dcb709c8bb8eb9e73da7a22a1522e"

SRC_URI = "http://xfce-look.org/CONTENT/content-files/40990-Rezlooks-pastelgreen.tar.gz"
SRC_URI[md5sum] = "6b9ea4fa673c17e25c266ba70b9b4cef"
SRC_URI[sha256sum] = "129ffb05daee8e10624e535947c61e003441138f2025404867b3fd01031a92e8"

THEME_NAME = "Rezlooks-pastelgreen"
S = "${WORKDIR}/${THEME_NAME}"

PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/themes/${THEME_NAME}/gtk-2.0/gtkrc"

do_install () {
    install -d -m 0755 "${D}/${datadir}/themes/${THEME_NAME}/gtk-2.0"
    install -m 0644 "${S}/gtk-2.0/gtkrc" "${D}/${datadir}/themes/${THEME_NAME}/gtk-2.0"
}

RDEPENDS_${PN} = "gtk-engines-rezlooks"
