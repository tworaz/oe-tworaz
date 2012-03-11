PRINC = "1"
FILESEXTRAPATHS := "${THISDIR}/files"

SRC_URI += "file://xfce4-notifyd.xml"

do_install_append () {
    install -d "${D}${sysconfdir}/xdg/xfce4/xfconf/xfce-perchannel-xml"
	install -m 0644 "${WORKDIR}/xfce4-notifyd.xml" "${D}${sysconfdir}/xdg/xfce4/xfconf/xfce-perchannel-xml/"
}

RDEPENDS_${PN} += "xfce4-theme-acid"

