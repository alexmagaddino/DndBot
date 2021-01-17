package it.alexm.dndbot

import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import java.io.File
import java.nio.charset.Charset


suspend fun main() {
    val keyFile = File("/Users/alex/.dndbot/key.txt")

    val botKey = keyFile.readText(Charset.defaultCharset())

    bot(botKey) {
        commands("!") {
            command("h") {
                reply("Ciao Magaz questa è una prova!")
            }
        }
    }

}