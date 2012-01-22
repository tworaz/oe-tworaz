DESCRIPTION = "Rezlooks Gil-Ouch theme"
HOMEPAGE = "http://gnome-look.org/content/show.php/Rezlooks-Gil-Ouch?content=70394"
SECTION = "x11/themes"

PR = "r1"

RDEPENDS = "gtk-engines-rezlooks"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://gtk-2.0/gtkrc;md5=9b78ae1658f1b5b77d271ea2ba42bdca"

SRC_URI = "http://gnome-look.org/CONTENT/content-files/70394-Rezlooks-Gil-Ouch.tar.gz"
SRC_URI[md5sum] = "bf8c33d3754513d286f9feffebebebe0"
SRC_URI[sha256sum] = "03f3da37e76b2f09b0ff51c0aa423f353214a9b0af87a0d31c22143bc33139c7"

S = "${WORKDIR}/Rezlooks-Gil-Ouch"

PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/themes/Rezlooks-Gil-Ouch/gtk-2.0/gtkrc"

do_install () {
    install -d -m 0755 "${D}/${datadir}/themes/Rezlooks-Gil-Ouch/gtk-2.0"
    install -m 0644 "${S}/gtk-2.0/gtkrc" "${D}/${datadir}/themes/Rezlooks-Gil-Ouch/gtk-2.0"
}
