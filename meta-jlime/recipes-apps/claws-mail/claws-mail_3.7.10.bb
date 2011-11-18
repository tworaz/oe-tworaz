DESCRIPTION = "An email client (and news reader) based on GTK+"
HOMEPAGE="http://www.claws-mail.org"
SECTION = "x11/network"

LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e059bde2972c1790af786f3e86bac22e"

DEPENDS = "gtk+ libetpan gnutls dbus enchant startup-notification libsm libice"

PR = "r0"

inherit autotools pkgconfig gettext

SRC_URI = "${SOURCEFORGE_MIRROR}/sylpheed-claws/claws-mail-${PV}.tar.bz2"
SRC_URI[md5sum] = "fcf58dcff52f0908ff3bc368d820408b"
SRC_URI[sha256sum] = "5c4119630e4b0b3d1486f3d96ef847a48c1389ef6426d6b5d6e6545413721638"

EXTRA_OECONF = "\
	${@base_contains('DISTRO_FEATURES', 'ipv6', '--enable-ipv6', '--disable-ipv6', d)} \
	--enable-enchant \
	--enable-dbus \
	--enable-startup-notification \
	--enable-libsm \
	--enable-libetpan \
	--disable-manual \
	--disable-crash-dialog \
	--disable-jpilot \
	--disable-spamassassin-plugin \
	--disable-bogofilter-plugin	\
	--disable-dillo-viewer-plugin \
	--disable-pgpmime-plugin \
	--disable-pgpinline-plugin \
	--disable-pgpcore-plugin \
	--disable-trayicon-plugin \
	--disable-valgrind \
	"

do_install_prepend() {
	sed -i -e 's:${STAGING_INCDIR}:${includedir}:g;s:${STAGING_LIBDIR}:${libdir}:g' claws-mail.pc
}

# Work-around broken GPE icon lookup:
do_install_append () {
	rm -r ${D}${datadir}/icons
	install -d ${D}${datadir}/pixmaps
	install -m 0644 claws-mail.png ${D}${datadir}/pixmaps/
	sed -i 's/Icon=[^.]*$/&.png/' ${D}${datadir}/applications/claws-mail.desktop
}
