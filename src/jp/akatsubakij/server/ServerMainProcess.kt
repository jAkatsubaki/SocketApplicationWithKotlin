package jp.akatsubakij.server

import kotlin.concurrent.thread

class ServerMainProcess {

}

fun main(args: Array<String>) {
    thread {
        ServerPrompt().run()
    }
    thread {
        ServerReceiver().run()
    }
}