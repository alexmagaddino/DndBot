package it.alexm.dndbot

import com.google.gson.Gson
import it.alexm.dndbot.logic.getPgs
import it.alexm.dndbot.logic.rollCharacteristic
import it.alexm.dndbot.logic.rollSkill
import it.alexm.dndbot.vo.Character
import it.alexm.dndbot.vo.CharacteristicType
import it.alexm.dndbot.vo.SkillType
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset


class Test {

    @Test
    fun prova1() {
        println("Prova")
        val file = File("/Users/alex/.dndbot/pgs/DndPg.json")

        val json = file.readText(Charset.defaultCharset())

        file.exists()

        val gson = Gson()

        val c = gson.fromJson(json, Character::class.java)

        println(c)
        println()

        println(c.rollCharacteristic(CharacteristicType.STR))

        println(c.rollSkill(SkillType.ARCANA))
        println(c.rollCharacteristic(CharacteristicType.STR, true))
        println()
    }


    @Test
    fun prova2() {
        println("Lista di file dentro .dndbot/pgs:")
        val pgs = getPgs()
        pgs?.forEach(::println)
    }
}