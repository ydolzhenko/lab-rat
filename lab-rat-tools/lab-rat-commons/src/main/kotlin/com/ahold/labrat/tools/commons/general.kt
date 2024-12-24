package com.ahold.labrat.tools.commons

import java.util.Optional

fun <T> Optional<T>.orNull(): T? = orElse(null)