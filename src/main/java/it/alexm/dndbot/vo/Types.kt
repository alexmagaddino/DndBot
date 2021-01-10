package it.alexm.dndbot.vo

import it.alexm.dndbot.vo.CharacteristicType.*


enum class CharacteristicType(val prettyString: String) {
    STR("STRENGTH"),
    DEX("DEXTERITY"),
    CON("CONSTITUTION"),
    WIS("WISDOM"),
    INT("INTELLIGENCE"),
    CHA("CHARISMA");

    companion object {
        operator fun invoke(s: String): CharacteristicType? = values().find {
            it.prettyString.contains(s, ignoreCase = true)
        }
    }
}

enum class SkillType(val superType: CharacteristicType, val prettyString: String) {
    ACROBATICS(DEX, "Acrobatics"),
    ANIMAL_HANDLING(WIS, "Animal Handling"),
    ARCANA(INT, "Arcana"),
    ATHLETICS(STR, "Athletics"),
    DECEPTION(CHA, "Deception"),
    HISTORY(INT, "History"),
    INSIGHT(WIS, "Insight"),
    INTIMIDATION(CHA, "Intimidation"),
    INVESTIGATION(INT, "Investigation"),
    MEDICINE(WIS, "Medicine"),
    NATURE(INT, "Nature"),
    PERCEPTION(WIS, "Perception"),
    PERFORMANCE(CHA, "Performance"),
    PERSUASION(CHA, "Persuasion"),
    RELIGION(INT, "Religion"),
    SLEIGHT_OF_HAND(DEX, "Sleight of Hand"),
    STEALTH(DEX, "Stealth"),
    SURVIVAL(WIS, "Survival");

    companion object {
        operator fun invoke(s: String): SkillType? = values().find {
            it.prettyString.contains(s, ignoreCase = true)
        }
    }
}