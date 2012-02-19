DESCRIPTION = "UNIX Shell similar to the Korn shell"
HOMEPAGE="http://www.zsh.org"
SECTION = "base/shell"

LICENSE = "ZSH"
LIC_FILES_CHKSUM = "file://LICENCE;md5=ad234d4b46db63491c4a9789da4fb341"

DEPENDS = "ncurses libcap libpcre gdbm groff-native"

SRC_URI = "ftp://ftp.zsh.org/pub/${P}.tar.bz2"
SRC_URI[md5sum] = "11766b0dd674a513810903cd33ffcac4"
SRC_URI[sha256sum] = "8708f485823fb7e51aa696776d0dfac7d3558485182672cf9311c12a50a95486"

FILES_${PN}-dbg += "\
    ${libdir}/${PN}/${PV}/${PN}/.debug/*.so \
    ${libdir}/${PN}/${PV}/${PN}/db/.debug/*.so \
    ${libdir}/${PN}/${PV}/${PN}/net/.debug/*.so \
    "

inherit autotools

EXTRA_OECONF = " \
    --bindir=${base_bindir} \
    --enable-etcdir=${sysconfdir} \
    --enable-fndir=${datadir}/${PN}/${PV}/functions \
    --enable-site-fndir=${datadir}/${PN}/site-functions \
    --enable-function-subdirs \
    --with-term-lib='ncursesw ncurses' \
    --with-tcsetpgrp \
    --enable-pcre \
    --enable-cap \
    --enable-multibyte \
    --enable-gdbm \
    --enable-dynamic \
    zsh_cv_shared_environ=yes \
    "

do_configure () {
    oe_runconf
}

pkg_postinst_${PN} () {
    touch $D${sysconfdir}/shells
    grep -q "bin/zsh" $D${sysconfdir}/shells || echo "/bin/zsh" >> $D${sysconfdir}/shells
}

pkg_postrm_${PN} () {
    if [ -e $D${sysconfdir}/shells ]; then
        sed -i -e '/\/bin\/zsh/d' $D${sysconfdir}/shells
    fi
}
