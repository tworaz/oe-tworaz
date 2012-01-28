DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"

PV = "0.5+git${SRCPV}"
PR = "r1"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://tap.c;beginline=1;endline=19;md5=9c958f540d061319195fababadef1835"

SRC_URI = "git://github.com/tworaz/gtkstylus.git;branch=master;protocol=git \
           file://gtkstylus.sh"
SRCREV = "43406cb0b1fae129f964674a044c9c62e5764548"

FILES_${PN} = "${libdir}/gtk-2.0/*/modules/${PN}.so"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/modules/.debug/${PN}.so"

S = "${WORKDIR}/git"

FILES_${PN} += "${sysconfdir}/X11/Xinit.d/45gtkstylus"

inherit autotools

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xinit.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xinit.d/45gtkstylus
    find "${D}" -type f -name '*.la' -exec rm -f {} +
}
