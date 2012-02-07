DESCRIPTION = "A dark, minimalistic & fast Xfce4 theme."
HOMEPAGE = "http://sixsixfive.deviantart.com/art/ACID-280889262"
SECTION = "x11/themes"

inherit allarch

LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://gtk-2.0/gtkrc;md5=3cc9810c420b55419e8372aa0d1a3def"

# Original archive is compressed using 7zip which OE can't unpack
SRC_URI = "http://www.tworaz.net/downloads/distfiles/acid_by_sixsixfive-d4n8fji.zip"
SRC_URI[md5sum] = "1528f2b99153145ca5dc2fb8b5de1d60"
SRC_URI[sha256sum] = "5364c8d851d50256f54490a6d14ae65a3b8467282d38e88727b3983a7d359da0"

THEME_NAME = "ACID"
S = "${WORKDIR}/${THEME_NAME}"

PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/themes/${THEME_NAME}"

do_install () {
    install -d -m 0755 "${D}/${datadir}/themes/${THEME_NAME}"
    cp -r "${S}"/* "${D}/${datadir}/themes/${THEME_NAME}/"
    find "${D}/${datadir}/themes/${THEME_NAME}" -type d -exec chmod 0755 {} +
    find "${D}/${datadir}/themes/${THEME_NAME}" -type f -exec chmod 0644 {} +
}
