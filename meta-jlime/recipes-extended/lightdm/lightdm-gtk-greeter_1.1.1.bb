DESCRIPTION = "GTK+ greeter for lightweight display manager"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/LightDM"
SECTION = "x11"

PR = "r1"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "glib-2.0 gtk+ lightdm"

SRC_URI = "http://launchpad.net/${PN}/trunk/${PV}/+download/${P}.tar.gz \
           file://${P}-fix-missing-greeter-ui.diff"
SRC_URI[md5sum] = "6dcbcd2b8e71ab510fd16550368b4996"
SRC_URI[sha256sum] = "bfab54008fbb7ea992c43ca9398a06a65a90c26dc2c64e11b4be7bbabf8b7056"

FILES_${PN} += "${datadir}/xgreeters/${PN}.desktop"

LIGHTDM_GTK_BACKGROUND = "/usr/share/wallpapers/jlime-wallpaper.png"
LIGHTDM_GTK_THEME = "ACID"

inherit autotools pkgconfig gettext

do_configure_prepend () {
	sed -i -e "s:gtk+-3.0:gtk+-2.0:" configure.ac || bb_fatal "sed failed"
}

do_install_append () {
	if  [ "x${LIGHTDM_GTK_BACKGROUND}" != "x" ]; then
		sed -i -e "s@#background=@background=${LIGHTDM_GTK_BACKGROUND}@" "${D}${sysconfdir}/lightdm/lightdm-gtk-greeter.conf"
	fi
	if  [ "x${LIGHTDM_GTK_THEME}" != "x" ]; then
		sed -i -e "s@#theme-name=@theme-name=${LIGHTDM_GTK_THEME}@" "${D}${sysconfdir}/lightdm/lightdm-gtk-greeter.conf"
	fi
}

RDEPENDS_${PN} = "gnome-icon-theme"
RDEPENDS_${PN} += "xfce4-theme-acid jlime-wallpapers"
