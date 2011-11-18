DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
HOMEPAGE = "http://trac.emma-soft.com/epdfview/"
SECTION = "x11/applications"

DEPENDS = "poppler pango gtk+ cups"

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

PR="r0"

SRC_URI = "http://trac.emma-soft.com/epdfview/chrome/site/releases/epdfview-${PV}.tar.bz2"
SRC_URI[md5sum] = "e50285b01612169b2594fea375f53ae4"
SRC_URI[sha256sum] = "948648ae7c9d7b3b408d738bd4f48d87375b1196cae1129d6b846a8de0f2f8f0"

inherit autotools gettext mime

FILES_${PN} += "${datadir}/icons/"

do_configure_append () {
    sed -i -e 's:Icon=icon_epdfview-48:Icon=epdfview:' ${S}/data/epdfview.desktop || bbfatal "sed failed"
}

do_install_append () {
	local res
	for res in 24 32 48; do
		install -d -m 0755 ${D}/${datadir}/icons/hicolor/${res}x${res}/apps
		install -m 0644 ${S}/data/icon_epdfview-${res}.png \
			${D}/${datadir}/icons/hicolor/${res}x${res}/apps/epdfview.png
	done
}
