IMAGE_FEATURES += "package-management"

PR = "r4"

CORE_IMAGE_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-lxde-extended \
    libgtkstylus \
    task-jlime-apps-cli \
    task-jlime-apps-gui \
    notification-daemon \
    batti \
    connman \
    connman-gnome \
    "

LICENSE = "MIT"

inherit core-image
