Easer [![Build Status](https://travis-ci.org/renyuneyun/Easer.svg?branch=master)](https://travis-ci.org/renyuneyun/Easer) [![codecov](https://codecov.io/gh/renyuneyun/Easer/branch/master/graph/badge.svg)](https://codecov.io/gh/renyuneyun/Easer) [![matrix-chat](https://matrix.to/img/matrix-badge.svg)](https://matrix.to/#/#Easer:matrix.org)  [ ![Download](https://api.bintray.com/packages/renyuneyun/Android/Easer/images/download.svg) ](https://bintray.com/renyuneyun/Android/Easer/_latestVersion)
=======
[<img src="https://f-droid.org/badge/get-it-on.png"
      alt="Get it on F-Droid"
      height="60">](https://f-droid.org/app/ryey.easer)
<img align="right" src='./app/src/main/ic_launcher-web.png' width='128' height='128'/>

Ease your life by automatically performing routine actions.

Introduction
-----
This document centers on development-related things of Easer.

If you are looking for the description of Easer's functionality, please refer to [the website](https://renyuneyun.github.io/Easer/en/).

Extending Easer
------
Extending the functionality of Easer (by adding more *Events* or *Operations*) is really simple (and is becoming even simpler).

Details are described in [this document](https://renyuneyun.github.io/Easer/en/EXTEND).

Support Easer
------
### Raising issues, commenting on issues and solving issues
If you encounter problems when using Easer, you can submit an issue. The more detail you can provide, the better -- it will let the issue be pinned down faster.
You can also open an issue if you think there are features that Easer should have.

You are also welcome to comment on existing issues. If you believe you have the same problem (or idea), you can provide more information about it. Discussion is always welcome.
Issue expecting ideas are labeled with [RFC](https://github.com/renyuneyun/Easer/issues?q=is%3Aopen+label%3A%22RFC+%2F+Discussion+Wanted%22).

Want to do more but don't know where to start? See issues labeled with GFC (Good For Contributors) [L0](https://github.com/renyuneyun/Easer/issues?q=is%3Aissue+is%3Aopen+label%3A%22GFC%3A+L0%22), [L1](https://github.com/renyuneyun/Easer/issues?q=is%3Aissue+is%3Aopen+label%3A%22GFC%3A+L1%22), [L2](https://github.com/renyuneyun/Easer/issues?q=is%3Aissue+is%3Aopen+label%3A%22GFC%3A+L2%22). These issues usually have clear target and involve few components; the L0, L1 and L2 are my subjective classification of the level of difficulty (ascending).

If you are a developer, you may possess the knowledge and time to solve some issues. You can fork the repo, solve the problem, and create a pull request. Then, your code can be merged, and you can be appreciated by others （and you will be listed in the *Contributors* list unless you don't like to).
You're also welcome to create pull requests for issues not raised by others, but first, please create an issue describing what you want to do (and that you are going to do it).

### Donation

If you would like to make a donation, please see [DONATE](https://renyuneyun.github.io/Easer/en/DONATE).

Any amount of help is appreciated.

Copyright
------
Copyright (c) 2016 - 2018 Rui Zhao (renyuneyun) <renyuneyun@gmail.com>

Unless otherwise stated, the program is licensed under GPLv3+ (See LICENSE)

Tools under `utils/` directory are licensed under Apache 2.0 (See `utils/LICENSE`)

### Why GPL?

The expected functions of Easer require access to personal information (e.g. location, calendar) and networking capabilities. We would never want a tool that is expected to better facilitate our lives to spy on us, so we must prevent that from happening as best as we can. The only way to do this is to allow anyone to inspect every part of Easer, which is to say that Easer (and any derived works) must be made open source.
Because of the design of Easer, functionality will eventually become modules / plugins. The GPL requires that derived works also be licensed under the GPL, and thus prevents malicious code from sneaking into these parts.

In fact, ensuring that derived works / plugins are licensed under the **GPL** is unnecessary -- they only need to be **open source**. However, GPL is the only license (that I know of) which requires that derived works / plugins are open sourced, so it's the only choice.

Third-party
-----
* [Logger](https://github.com/orhanobut/logger): Apache License v2
* [android-flowlayout](https://github.com/ApmeM/android-flowlayout): Apache License v2
* [Guava](https://github.com/google/guava): Apache License v2
* [StickyListHeaders](https://github.com/emilsjolander/StickyListHeaders): Apache License v2

* Drawable files named as `*-fa-*` all come from [fontawesome](https://fontawesome.com/): CC-BY 4.0
