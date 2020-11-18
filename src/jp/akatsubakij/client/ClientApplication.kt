package jp.akatsubakij.client

import jp.akatsubakij.config.CommonMessages
import jp.akatsubakij.util.info
import jp.akatsubakij.util.prompt
import jp.akatsubakij.util.warn
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.lang.Exception
import java.net.Socket
import kotlin.system.exitProcess

class ClientApplication {
    val sc = Socket("localhost", 9090)

    fun run() {
        val outputStream = PrintWriter(BufferedWriter(OutputStreamWriter(sc.getOutputStream())))
        while (true) {
            try {
                prompt("input your message (type 'exit' if you finish)")
                val promptValue = readLine()
                if (promptValue.equals("exit")) {
                    outputStream.println(CommonMessages.FIN_FROM_ANY_NODE.value)
                    outputStream.flush()
                    break
                }
                outputStream.println(promptValue)
                outputStream.flush()
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
        outputStream.close()
        info("Application is closed")
    }
}