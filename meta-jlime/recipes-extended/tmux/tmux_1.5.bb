DESCRIPTION = "Terminal multiplexer"
HOMEPAGE = "http://tmux.sourceforge.net"
SECTION = "console/utils"

PR = "r0"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://tmux.c;startline=3;endline=17;md5=d408ab1cc03604a8957e3e359a246e69"

DEPENDS = "ncurses libevent"

SRC_URI = "${SOURCEFORGE_MIRROR}/tmux/${P}.tar.gz"
SRC_URI[md5sum] = "3d4b683572af34e83bc8b183a8285263"
SRC_URI[sha256sum] = "eb8215b57c05b765d2446d9acb2bc5edcdb3eb4ea31af89ee127a27e90056306"

inherit autotools

do_configure_prepend () {
	sed -i -e 's:-I/usr/local/include::' Makefile.in Makefile.am || bb_fatal "sed failed"
}
