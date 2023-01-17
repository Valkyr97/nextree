package com.janyel97.nextree.utils

fun hrefToId(href: String): String {
    return href
        .dropLast(1)
        .substringAfterLast('/')
}