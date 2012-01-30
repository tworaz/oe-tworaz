DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"
PR = "r6"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://tap.c;beginline=1;endline=19;md5=9c958f540d061319195fababadef1835"

inherit autotools

SRC_URI = "http://burtonini.com/temp/${BPN}-${PV}.tar.gz \
           file://gtkstylus.sh"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xinit.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xinit.d/45gtkstylus
}

FILES_${PN} = "${sysconfdir} \
               ${libdir}/gtk-2.0/*/modules/libgtkstylus.so.*"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/modules/.debug"
FILES_${PN}-dev += "${libdir}/gtk-2.0/*/modules/libgtkstylus.so \
                    ${libdir}/gtk-2.0/*/modules/libgtkstylus.*a"
