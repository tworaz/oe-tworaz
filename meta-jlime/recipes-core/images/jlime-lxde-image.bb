IMAGE_FEATURES += "package-management"

PR = "r1"

POKY_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-lxde-base \
    libgtkstylus \
    "

LICENSE = "MIT"

inherit core-image
