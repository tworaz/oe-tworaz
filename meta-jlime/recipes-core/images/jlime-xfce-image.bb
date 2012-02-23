IMAGE_FEATURES += "package-management ssh-server-openssh"

PR = "r2"

CORE_IMAGE_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-xfce-extended \
    task-jlime-apps-cli \
    task-jlime-apps-gui \
    network-manager-applet \
    xfce4-power-manager \
    libgtkstylus \
    "

LICENSE = "MIT"

inherit core-image
