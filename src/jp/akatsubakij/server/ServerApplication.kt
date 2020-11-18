package jp.akatsubakij.server

import jp.akatsubakij.config.CommonMessages
import jp.akatsubakij.util.info
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.Socket

class ServerApplication(var sc: Socket) {

    fun exec() {
        val inputStream = sc.getInputStream()
        val bReader = BufferedReader(InputStreamReader(inputStream))
        try {
            while (true) {
                while (inputStream.available() == 0) {}
                val recvData = bReader.readLine()
                info(recvData)
                if (recvData == CommonMessages.FIN_FROM_ANY_NODE.value) break
            }
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        bReader.close()
        inputStream.close()
        info("Connection is closed")
    }
}