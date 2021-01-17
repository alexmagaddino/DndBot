package it.alexm.dndbot

import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import it.alexm.dndbot.logic.getPgs
import java.io.File
import java.nio.charset.Charset


suspend fun main() {
    val keyFile = File("/Users/alex/.dndbot/key.txt")

    val botKey = keyFile.readText(Charset.defaultCharset())

    bot(botKey) {
        commands("!") {
            getPgs()?.forEach {
                command(it.toLowerCase()) {
                    reply("Ciao Magaz questa è una prova!")
                }
            }
        }
    }
}