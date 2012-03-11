DESCRIPTION = "Default wallpaper for JLime images"

inherit allarch

LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=3248afbd148270ac7337a6f3e2558be5"

SRC_URI = "file://jlime-wallpaper.png \
           file://LICENSE"

FILES_${PN} = "${datadir}/wallpapers"

do_install () {
	install -d "${D}${datadir}/wallpapers"
    install -m 0644 "${WORKDIR}/jlime-wallpaper.png" "${D}${datadir}/wallpapers"
}
