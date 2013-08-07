DESCRIPTION = "A standards compliant, fast, light-weight, extensible window manager"
HOMEPAGE = "http://openbox.org"
SECTION = "x11/wm"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

PR = "r3"

RDEPENDS = "glib-2.0 libxml2 pango imlib2 startup-notification libxft libxrandr libxt"
DEPENDS = "${RDEPENDS} xextproto xf86vidmodeproto"
RDEPENDS_${PN} = "openbox-theme-clearlooks"

SRC_URI = "http://openbox.org/dist/openbox/openbox-${PV}.tar.gz"
SRC_URI[md5sum] = "00441b53cf14c03566c8e82643544ff9"
SRC_URI[sha256sum] = "6fa90016530b3aa6102e254079461977439398531fb23e7ec076ff2c140fea0a"

inherit autotools update-alternatives gettext pkgconfig

EXTRA_OECONF += "\
    --enable-session-management \
    --disable-xinerama \
    --with-x\
    "

ALTERNATIVE_PATH = "${bindir}/openbox"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "10"

PACKAGES =+ "${PN}-gnome ${PN}-gnome-dbg ${PN}-kde ${PN}-kde-dbg"
FILES_${PN} += "${datadir}/gnome ${datadir}/xsessions"
FILES_${PN}-gnome = "\
    ${bindir}/${PN}-gnome-session \
    ${bindir}/gnome-panel-control \
    ${bindir}/gdm-control \
    ${datadir}/xsessions/${PN}-gnome.desktop \
    ${datadir}/gnome \
    "
FILES_${PN}-gnome-dbg = "\
    ${bindir}/.debug/${PN}-gnome-session \
    ${bindir}/.debug/gnome-panel-control \
    ${bindir}/.debug/gdm-control \
    "
FILES_${PN}-kde = "\
    ${bindir}/${PN}-kde-session \
    ${datadir}/xsessions/${PN}-kde.desktop \
    "
FILES_${PN}-kde-dbg = "\
    ${bindir}/.debug/${PN}-kde-session \
    "

PACKAGES_DYNAMIC += "${PN}-theme-*"

python populate_packages_prepend() {
    theme_dir = bb.data.expand('${datadir}/themes/', d)
    theme_name = bb.data.expand('${PN}-theme-%s', d)
    do_split_packages(d, theme_dir, '(.*)', theme_name, '${PN} theme for %s', extra_depends='', allow_dirs=True)
}
