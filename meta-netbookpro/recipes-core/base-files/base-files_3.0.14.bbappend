FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC = "3"

do_install_append_netbookpro () {
    mkdir -p ${D}/run
}
