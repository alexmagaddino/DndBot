package it.alexm.dndbot.logic

import it.alexm.dndbot.vo.*

fun roll20() = (1..20).random()

fun Characteristic.getModifier(): Int = (this.value - 10) / 2

fun Characteristic.getSkillProficiency(skillType: SkillType): ProficiencyType {
    return skills.find { skill ->
        skill.type() == skillType
    }?.proficiencyType() ?: ProficiencyType.NONE
}

fun Character.rollCharacteristic(characteristicType: CharacteristicType, isSavingThrow: Boolean = false): String {
    val characteristic = characteristics.find { it.type() == characteristicType }
    val proficiencyType = characteristic?.proficiencyType()

    val rolled = roll20()
    val modifier = characteristic?.getModifier() ?: 0
    val proficiencyBonus = (proficiencyType?.multiplier ?: 0) * proficiencyBonus
    val total = rolled + modifier + proficiencyBonus

    return if (isSavingThrow)
        "Rolled: $rolled + modifier: $modifier + proficiency bonus:  $proficiencyBonus = $total"
    else
        "Rolled: $rolled + modifier: $modifier = ${rolled + modifier}"
}

fun Character.rollSkill(skillType: SkillType): String {
    val characteristic = characteristics.find { it.type() == skillType.superType }
    val proficiencyType = characteristic?.getSkillProficiency(skillType)
    val rolled = roll20()
    val modifier = characteristic?.getModifier() ?: 0
    val proficiencyBonus = (proficiencyType?.multiplier ?: 0) * proficiencyBonus

    val total = rolled + modifier + proficiencyBonus

    return "Rolled: $rolled + modifier: $modifier + proficiency bonus:  $proficiencyBonus = $total"
}