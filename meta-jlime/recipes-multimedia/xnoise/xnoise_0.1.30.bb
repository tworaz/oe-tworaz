DESCRIPTION = "GTK+ media player with a slick GUI, great speed and lots of features."
HOMEPAGE = "http://www.xnoise-media-player.com"
SECTION = "multimedia"
PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=819b9799052ecc4e5a9dffb13847ee90"

DEPENDS = "sqlite3 glib-2.0 libunique libxml2 gstreamer taglib \
           cairo gdk-pixbuf gtk+ libsoup libnotify"
RRECOMMENDS = "gst-plugins-base"

SRC_URI = "http://${PN}.googlecode.com/files/${P}.tar.bz2"
SRC_URI[md5sum] = "43169e4972b158029580134f1be0a3d0"
SRC_URI[sha256sum] = "fdc121bf567a88a6f62bc01ccba2c39402f53417d0b22a6e5a369612b351c8f7"

EXTRA_OECONF = " \
    --disable-soundmenu \
    --enable-soundmenu2 \
    --enable-lastfm \
    --enable-notifications \
    --enable-leoslyrics \
    --enable-lyricsfly \
    --enable-lyricwiki \
    --enable-chartlyrics \
    "

FILES_${PN}-dev += "${datadir}/vala/vapi/*"
INSANE_SKIP_${PN} = "dev-so"

inherit gettext pkgconfig gtk-icon-cache autotools
