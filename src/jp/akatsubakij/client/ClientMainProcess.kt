package jp.akatsubakij.client

import kotlin.concurrent.thread

class ClientMainProcess {}

fun main(args: Array<String>) {
    thread {
        ClientApplication().run()
    }
}