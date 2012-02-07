DESCRIPTION = "Colorized icon sets for GNOME"
HOMEPAGE = "http://gnome-look.org/content/show.php/GNOME-colors?content=82562"
SECTION = "x11/gnome"

inherit allarch

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

# Original archive is compressed using 7zip which OE can't unpack
SRC_URI = "http://gnome-colors.googlecode.com/files/gnome-colors-${PV}.tar.gz"
SRC_URI[md5sum] = "8ec81b556bac351817bd56a1701dbbfb"
SRC_URI[sha256sum] = "1e91d845a753eb38671e7614a786f852ab858a12983111e780da4a47c9debe58"

S = "${WORKDIR}"

PACKAGES = "gnome-colors-common"
FILES_gnome-colors-common = "${datadir}/icons/gnome-colors-common"

python populate_packages_prepend () {
	themes = ['brave', 'dust', 'human', 'illustrious', 'noble', 'wine', 'wise']
	packages = d.getVar('PACKAGES')
	for theme in themes:
		package = 'gnome-%s-icon-theme' % theme
		packages = "%s %s" % (packages, package)
		pkg_files = "${datadir}/icons/gnome-%s/" % theme
		d.setVar("FILES_%s" % package, pkg_files)
		d.setVar("RDEPENDS_%s" % package, "gnome-colors-common")
	d.setVar('PACKAGES', packages)
}

do_install () {
    oe_runmake DESTDIR=${D} install || bb_fatal "install failed"
}

RDEPENDS_gnome-colors-common = "gnome-icon-theme"
