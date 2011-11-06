LICENSE = "MIT"
DEPENDS = "compositeproto damageproto fixesproto recordproto resourceproto \
        scrnsaverproto xineramaproto videoproto xextproto xproto libxau libxext \
        libxdmcp libxfont libxrandr tslib virtual/libx11 xtrans bigreqsproto \
        xcmiscproto libdrm openssl"

PROVIDES = "virtual/xserver"
PACKAGES =+ "xserver-kdrive-fbdev \
             xserver-kdrive-fake \
             xserver-kdrive-ephyr \
             xserver-kdrive-epson \
            "

SECTION = "x11/base"
DESCRIPTION = "X server from freedesktop.org"
DESCRIPTION_xserver-kdrive-fbdev = "X server from freedesktop.org, supporting generic framebuffer devices"
DESCRIPTION_xserver-kdrive-fake = "Fake X server"
DESCRIPTION_xserver-kdrive-ephyr = "X server in an X window"
DESCRIPTION_xserver-kdrive-epson = "X server from freedesktop.org, supporting Epson S1D13806 devices"

FILES_${PN} += "${libdir}/xserver/SecurityPolicy"
ALLOW_EMPTY_${PN} = "1"

FILES_xserver-kdrive-fbdev = "${bindir}/Xfbdev"
FILES_xserver-kdrive-fake = "${bindir}/Xfake"
FILES_xserver-kdrive-xephyr = "${bindir}/Xephyr"
FILES_xserver-kdrive-epson = "${bindir}/Xepson"

RDEPENDS_xserver-kdrive-fbdev = "${PN}"
RDEPENDS_xserver-kdrive-fake = "${PN}"
RDEPENDS_xserver-kdrive-xephyr = "${PN}"
RDEPENDS_xserver-kdrive-epson = "${PN}"

inherit autotools pkgconfig

ARM_INSTRUCTION_SET = "arm"

EXTRA_OECONF = "--enable-composite \
                --enable-kdrive \
                --enable-kdrive-kbd \
                --enable-kdrive-mouse \
                --enable-kdrive-evdev \
                --disable-dga \
                --disable-dri \
                --disable-glx \
                --disable-xinerama \
                --disable-xf86vidmode \
                --disable-xorg \
                --disable-xnest \
                --disable-xvfb \
                --disable-dmx \
                --enable-xepson \
                --with-default-font-path=built-ins \
                --enable-tslib \
                --disable-unit-tests \
                ac_cv_file__usr_share_X11_sgml_defs_ent=no \
                "
#                --disable-xf86misc \
#                --disable-xorgcfg \
#                --disable-xevie \
#                --disable-xkb \
#                --disable-xprint \
#                --disable-xtrap \
#                --enable-xcalibrate \

do_configure_prepend() {
    sed -i -e 's/tslib-0.0/tslib-1.0/' ${S}/configure.ac
}
