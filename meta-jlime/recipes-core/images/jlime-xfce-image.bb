IMAGE_FEATURES += "package-management"

POKY_EXTRA_INSTALL = "\
    task-x11-server\
    task-x11-utils \
    task-xfce-base \
    shell-aliases \
    file \
    htop \
    vim \
    "

LICENSE = "MIT"

inherit core-image
