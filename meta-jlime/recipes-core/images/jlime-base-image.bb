IMAGE_FEATURES += "package-management"

PR = "r1"

POKY_EXTRA_INSTALL = "\
    task-jlime-apps-cli \
    "

LICENSE = "MIT"

inherit core-image
