SECTION = "kernel"
DESCRIPTION = "Linux kernel for Psion Teklogix NetBook Pro"
LICENSE = "GPLv2"
PR = "r0"

SRCREV="ddaab3c2c3bd6bf74c98e9efeabb033469f56493"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "netbookpro"

SRC_URI = "git://github.com/tworaz/linux.git;protocol=git;branch=3.1-rc9-nbpro"

S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

ARCH = "arm"

FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${S}/arch/arm/configs/netbookpro_defconfig ${S}/.config
}
