package it.alexm.dndbot.vo


data class Character(
    val characteristics: List<Characteristic>,
    val proficiencyBonus: Int
)

data class Characteristic(
    val name: String,
    val value: Int,
    val savingThrowProficient: Char? = null,
    val skills: List<ProficientSkill>
) {
    fun type() = CharacteristicType(name)

    fun proficiencyType() = ProficiencyType(savingThrowProficient)
}

data class ProficientSkill(
    val name: String,
    val proficient: Char? = null
) {
    fun type() = SkillType(name)

    fun proficiencyType() = ProficiencyType(proficient)
}

enum class ProficiencyType(private val key: Char) {
    NONE('n'), NORMAL('y'), DOUBLE('d');

    val multiplier: Int
        get() = when (this) {
            DOUBLE -> 2
            NORMAL -> 1
            else -> 0
        }

    companion object {
        operator fun invoke(c: Char?): ProficiencyType = values().find {
            it.key == c?.toLowerCase()
        } ?: NONE
    }
}