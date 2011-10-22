FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC = "3"

do_install_append_netbookpro () {
    ln -sf /var/run ${D}/run
}
