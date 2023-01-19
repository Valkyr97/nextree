package com.janyel97.nextree.utils

fun String.hrefToId() : String =
    this
        .dropLast(1)
        .substringAfterLast('/')
