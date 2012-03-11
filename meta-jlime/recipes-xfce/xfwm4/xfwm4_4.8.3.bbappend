PRINC = "3"
FILESEXTRAPATHS := "${THISDIR}/files"

SRC_URI += "file://xfwm4.xml"

do_install_append () {
	install -d "${D}${sysconfdir}/xdg/xfce4/xfconf/xfce-perchannel-xml"
	install -m 0644 "${WORKDIR}/xfwm4.xml" "${D}${sysconfdir}/xdg/xfce4/xfconf/xfce-perchannel-xml/"
}

RDEPENDS_${PN} += "xfce4-theme-acid"
