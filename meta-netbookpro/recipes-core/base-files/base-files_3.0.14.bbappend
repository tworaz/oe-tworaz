FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC = "5"

do_install_append_netbookpro () {
    mkdir -p ${D}/run
    rmdir ${D}/tmp
    ln -sf /var/tmp ${D}/tmp
}
