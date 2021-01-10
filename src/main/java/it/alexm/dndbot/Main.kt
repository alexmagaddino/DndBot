package it.alexm.dndbot

import com.google.gson.Gson
import it.alexm.dndbot.logic.rollCharacteristic
import it.alexm.dndbot.logic.rollSkill
import it.alexm.dndbot.vo.Character
import it.alexm.dndbot.vo.CharacteristicType
import it.alexm.dndbot.vo.SkillType
import java.io.File
import java.nio.charset.Charset


fun main() {
    println("Prova")
    val file = File("/Users/alex/Library/Application Support/JetBrains/IdeaIC2020.3/scratches/DndPg.json")

    val json = file.readText(Charset.defaultCharset())

    val gson = Gson()

    val c = gson.fromJson(json, Character::class.java)

    println(c)
    println()

    println(c.rollCharacteristic(CharacteristicType.STR))

    println(c.rollSkill(SkillType.ARCANA))

    println(c.rollCharacteristic(CharacteristicType.STR, true))

}