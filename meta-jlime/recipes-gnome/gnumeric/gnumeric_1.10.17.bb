DESCRIPTION="Gnumeric, the GNOME Spreadsheet"
HOMEPAGE="http://projects.gnome.org/gnumeric/"
SECTION = "x11/office"
PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=44ac4678311254db62edf8fd39cb8124"

DEPENDS = "zlib bzip2 libgsf goffice libxml2 pango gtk+ cairo"
RDEPENDS = "dbus"

SRC_URI[archive.md5sum] = "aacc0899222c98fa9cdd85c49a6840be"
SRC_URI[archive.sha256sum] = "bb2a13424811d132fe1be7a6e82d61157a18c630fc91b7409503dbd7ef600ea5"

EXTRA_OECONF = " \
    --enable-ssindex \
    --disable-static \
    --without-gnome \
    --without-gda \
    --with-zlib \
    --without-perl \
    --without-python \
    "

PACKAGES =+ "${PN}-plugins ${PN}-plugins-dbg"
RDEPENDS_${PN} += "${PN}-plugins"

FILES_${PN} += "${libdir}/goffice/*/plugins/${PN}/* ${libdir}/libspreadsheet-${PV}.so"
FILES_${PN}-dbg += "${libdir}/goffice/*/plugins/${PN}/.debug/*.so"
FILES_${PN}-plugins = "${libdir}/${PN}/${PV}/plugins/*/*.so"
FILES_${PN}-plugins-dbg = "${libdir}/${PN}/${PV}/plugins/*/.debug/*.so"

inherit gettext gnome
