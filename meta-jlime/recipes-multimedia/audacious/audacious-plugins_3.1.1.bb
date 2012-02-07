DESCRIPTION = "Plugins for audacious player"
HOMEPAGE = "http://audacious-media-player.org/"
SECTION = "multimedia"

PR = "r1"

DEPENDS = "gtk+ libxml2 dbus-glib neon libmodplug faad2 alsa-lib libav flac libvorbis mpg123 \
           lame libnotify libsamplerate0 libmms libsndfile1 libogg wavpack audacious"
RDEPENDS = "unzip"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eaa553a9b694ef7978d3ee9023fbef1c"

SRC_URI = "http://distfiles.atheme.org/${P}.tar.bz2"
SRC_URI[md5sum] = "d7342835617a57d98e66153678142192"
SRC_URI[sha256sum] = "dd85e982a49a2794041a391aba3d12a12505338b2c9623b60f16842ae89215ad"

EXTRA_OECONF = " \
	--disable-rpath \
    --disable-sdltest \
    --disable-sdlout \
    --enable-chardet \
    --enable-modplug \
    --enable-neon \
    --enable-aac \
    --enable-alsa \
    --enable-amidiplug-alsa \
    --enable-flacng \
    --enable-filewriter_flac \
    --enable-filewriter_mp3 \
    --enable-notify \
    --enable-resample \
    --enable-mms \
    --enable-mp3 \
    --enable-vorbis \
    --enable-filewriter_vorbis \
    --enable-wavpack \
    --disable-amidiplug \
    ${@base_contains('DISTRO_FEATURES', 'ipv6', '--enable-ipv6', '',d)} \
    "

inherit autotools pkgconfig gettext

PROVIDES = "${PN}-base"
PACKAGES = "${PN}-base ${PN}-dbg"
FILES_${PN}-dbg = "/usr/src/debug/*"
ALLOW_EMPTY_${PN}-base = "1"

PACKAGES_DYNAMIC = "\
    audacious-skin-* \
    audacious-container-* \
    audacious-effect-* \
    audacious-general-* \
    audacious-input-* \
    audacious-output-* \
    audacious-transport-* \
    audacious-visualization-* \
    "

RDEPENDS_${PN}-base = "\
	audacious-container-m3u \
	audacious-container-pls \
	audacious-effect-mixer \
	audacious-general-albumart \
	audacious-general-notify \
	audacious-general-skins \
	audacious-general-statusicon \
    audacious-general-gtkui \
	audacious-input-flacng \
	audacious-input-madplug \
	audacious-input-vorbis \
	audacious-output-alsa \
	audacious-skin-default \
    audacious-transport-unix-io \
	"

FILES_audacious-general-gtkui += "${datadir}/audacious/ui/*"

python populate_packages_prepend () {
	def audacious_plugins_split (t):
		rootdir = bb.data.expand('${libdir}/audacious/%s' % t, d)
		pattern = 'audacious-' + t.lower() + '-%s'
		descr = 'Audacious %s ' + t.lower()
		rootdir_dbg = bb.data.expand('${libdir}/audacious/%s/.debug' % t, d)
		pattern_dbg = 'audacious-' + t.lower() + '-%s-dbg'
		descr_dbg = 'Audacious %s ' + t.lower() + 'debug data'
		do_split_packages(d, rootdir, '^(.*)\.so$', output_pattern=pattern, description=descr, prepend=True)
		do_split_packages(d, rootdir_dbg, '^(.*)\.so$', output_pattern=pattern_dbg, description=descr_dbg,
			prepend=True, extra_depends='${PN}-dbg')

	audacious_plugins_split('Container')
	audacious_plugins_split('Effect')
	audacious_plugins_split('General')
	audacious_plugins_split('Input')
	audacious_plugins_split('Output')
	audacious_plugins_split('Transport')
	audacious_plugins_split('Visualization')

	import os;
	skins = bb.data.expand('${D}/${datadir}/audacious/Skins', d)
	packages = d.getVar('PACKAGES')
	for top, dirs, files in os.walk(skins):
		for skindir in dirs:
			package = 'audacious-skin-%s' % skindir.lower()
			packages = "%s %s" % (packages, package)
			pkg_files = "${datadir}/audacious/Skins/%s/*" % skindir
			d.setVar("FILES_%s" % package, pkg_files)
			d.setVar("DESCRIPTION_%s" % package, "Audacious %s skin" % skindir)
	d.setVar('PACKAGES', packages)
}
