package com.oliverbotello.movies.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(format: String = "yyyy-MM-dd"): Date
    = SimpleDateFormat(format).parse(this)

fun Date.toStringFormat(format: String = "dd/MM/yyyy"): String
    = SimpleDateFormat(format).format(this)
