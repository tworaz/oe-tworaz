IMAGE_FEATURES += "package-management ssh-server-openssh"

PR = "r3"

CORE_IMAGE_EXTRA_INSTALL = "\
    task-jlime-apps-cli \
    "

LICENSE = "MIT"

inherit core-image
