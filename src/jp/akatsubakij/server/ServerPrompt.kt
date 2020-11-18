package jp.akatsubakij.server

import jp.akatsubakij.util.info
import jp.akatsubakij.util.prompt
import jp.akatsubakij.util.warn
import java.lang.Exception
import kotlin.system.exitProcess

class ServerPrompt {

    fun run() {
        while (true) {
            try {
                info("input command (type 'exit' if you finish)")
                val promptValue = readLine()
                if (promptValue.equals("exit")) {
                    break
                }
                else {
                    warn("""Command is invalid.

[Hint]
    exit: shutdown server process
""")
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
        info("Shutdown server")
        exitProcess(0)
    }
}