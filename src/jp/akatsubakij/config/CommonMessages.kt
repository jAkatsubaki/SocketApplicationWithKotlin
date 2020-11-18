package jp.akatsubakij.config

enum class CommonMessages(val code: Int, val value: String) {
    HELLO_FROM_SRC_NODE(1, "CODE: HELLO_FROM_SRC_NODE"),
    ACK_FROM_DST_NODE(2, "CODE: ACK_FROM_DST_NODE"),
    ACK_FROM_SRC_NODE(3, "CODE: ACK_FROM_SRC_NODE"),
    FIN_FROM_ANY_NODE(9999, "CODE: FIN_FROM_ANY_NODE");

    companion object {
        fun fromValue(value: String): CommonMessages? {
            for (msg in CommonMessages.values()) {
                if (msg.value == value) return msg
            }
            return null
        }

        fun fromCode(code: Int): CommonMessages? {
            for (msg in CommonMessages.values()) {
                if (msg.code == code) return msg
            }
            return null
        }
    }
}