package com.oliverbotello.movies.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toStringFormat(format: String = "dd/MM/yyyy"): String
    = SimpleDateFormat(format).format(this)
