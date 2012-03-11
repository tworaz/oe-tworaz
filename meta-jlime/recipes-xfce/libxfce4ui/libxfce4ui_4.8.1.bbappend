PRINC = "1"
FILESEXTRAPATHS := "${THISDIR}/files"

SRC_URI += "file://xfce4-keyboard-shortcuts.xml"

do_install_append () {
	install -m 0644 "${WORKDIR}/xfce4-keyboard-shortcuts.xml" "${D}${sysconfdir}/xdg/xfce4/xfconf/xfce-perchannel-xml/"
}
