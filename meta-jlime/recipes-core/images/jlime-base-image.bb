IMAGE_FEATURES += "package-management"

POKY_EXTRA_INSTALL = "\
    task-x11-core \
    shell-aliases \
    htop \
    "

LICENSE = "MIT"

inherit core-image
