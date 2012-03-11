PRINC = "3"
FILESEXTRAPATHS := "${THISDIR}/files"

SRC_URI += "file://xsettings.xml"

do_install_append () {
	install -m 0644 "${WORKDIR}/xsettings.xml" "${D}${sysconfdir}/xdg/xfce4/xfconf/xfce-perchannel-xml/"
}

RDEPENDS_${PN} += "gnome-colors-wise xfce4-theme-acid"
