DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"
PR = "r7"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://tap.c;beginline=1;endline=19;md5=9c958f540d061319195fababadef1835"

inherit autotools

SRC_URI = "http://burtonini.com/temp/${BPN}-${PV}.tar.gz \
           file://gtkstylus.sh"
SRC_URI[md5sum] = "fa1c82cd9fd2fafd7ff10d78eb5781c5"
SRC_URI[sha256sum] = "383e0a22a537f653b8d41688277560f95678a042967198085ec7caa1a5cc2f4c"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xinit.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xinit.d/45gtkstylus
}

FILES_${PN} = "${sysconfdir} \
               ${libdir}/gtk-2.0/*/modules/libgtkstylus.so.*"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/modules/.debug"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/modules/libgtkstylus.so"
FILES_${PN}-staticdev += "${libdir}/gtk-2.0/*/modules/libgtkstylus.*a"
