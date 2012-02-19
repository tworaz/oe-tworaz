IMAGE_FEATURES += "package-management"

PR = "r2"

CORE_IMAGE_EXTRA_INSTALL = "\
    task-jlime-apps-cli \
    "

LICENSE = "MIT"

inherit core-image
