package jp.akatsubakij.server

import java.io.IOException
import java.net.InetSocketAddress
import java.net.ServerSocket
import kotlin.concurrent.thread
import kotlin.system.exitProcess

class ServerReceiver {
    val socket = ServerSocket()

    constructor() {
        socket.reuseAddress = true
        socket.bind(InetSocketAddress(9090))
    }

    fun run() {
        while (true){
            val sc = socket.accept()
            thread {
                ServerApplication(sc).exec()
            }
        }
    }
}