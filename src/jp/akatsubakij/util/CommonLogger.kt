package jp.akatsubakij.util

import java.text.SimpleDateFormat
import java.util.*

private fun timestamp(): String {
    val dt: Date = Date()
    val sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
    return sdf.format(dt)
}
private fun logging(type: String, msg: String) {
    System.out.println("%s [%-6s] %s".format(timestamp(), type, msg))
}

fun info(msg: String) = logging("INFO", msg)
fun warn(msg: String) = logging("WARN", msg)
fun error(msg: String) = logging("ERROR", msg)
fun fatal(msg: String) = logging("FATAL", msg)
