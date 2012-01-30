IMAGE_FEATURES += "package-management"

PR = "r0"

POKY_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-xfce-extended \
    task-jlime-apps-cli \
    task-jlime-apps-gui \
    network-manager-applet \
    libgtkstylus \
    "

LICENSE = "MIT"

inherit core-image
