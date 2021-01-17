package it.alexm.dndbot

import com.google.gson.Gson
import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import it.alexm.dndbot.logic.rollCharacteristic
import it.alexm.dndbot.logic.rollSkill
import it.alexm.dndbot.vo.Character
import it.alexm.dndbot.vo.CharacteristicType
import it.alexm.dndbot.vo.SkillType
import java.io.File
import java.nio.charset.Charset


suspend fun main() {
    val keyFile = File("/Users/alex/.dndbot/key.txt")

    val botKey = keyFile.readText(Charset.defaultCharset())

    bot(botKey) {
        commands("!")  {
            command("h") {
                reply("Ciao Magaz questa è una prova!")
            }
        }
    }

}

fun main2() {
    println("Prova")
    val file = File("/Users/alex/.dndbot/DndPg.json")

    val json = file.readText(Charset.defaultCharset())

    file.exists()

    val gson = Gson()

    val c = gson.fromJson(json, Character::class.java)

    println(c)
    println()

    println(c.rollCharacteristic(CharacteristicType.STR))

    println(c.rollSkill(SkillType.ARCANA))
    println(c.rollCharacteristic(CharacteristicType.STR, true))

}