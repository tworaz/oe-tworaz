SRCREV="84144d142cb9f041dd18285cb2ad9dbe6619b0a2"

require uclibc.inc
PR = "${INC_PR}.0"
PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI = "git://uclibc.org/uClibc.git;branch=${PV};protocol=git \
	file://uClibc.machine \
	file://uClibc.distro \
	file://uclibc-arm-ftruncate64.patch \
	file://uclibc_enable_log2_test.patch \
	file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch \
	file://powerpc_copysignl.patch \
	file://argp-support.patch \
	file://argp-headers.patch \
	file://remove_attribute_optimize_Os.patch \
	file://compile-arm-fork-with-O2.patch \
	file://orign_path.patch \
	file://rtld_no.patch \
	file://0001-mips-signalfd.h-SFD_NONBLOCK-for-mips-is-0200-unlike.patch \
	file://uclibc-execvpe.patch \
	file://uclibc_scheduler_update.patch \
	file://sync_file_range2.patch \
	file://mount.h-update.patch \
	"

S = "${WORKDIR}/git"
