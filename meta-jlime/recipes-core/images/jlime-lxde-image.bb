IMAGE_FEATURES += "package-management"

PR = "r3"

POKY_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-lxde-extended \
    libgtkstylus \
    task-jlime-apps-cli \
    task-jlime-apps-gui \
    connman \
    connman-gnome \
    "

LICENSE = "MIT"

inherit core-image
