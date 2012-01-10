IMAGE_FEATURES += "package-management"

PR = "r2"

POKY_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-lxde-base \
    libgtkstylus \
    task-jlime-apps-cli \
    task-jlime-apps-gui \
    "

LICENSE = "MIT"

inherit core-image
