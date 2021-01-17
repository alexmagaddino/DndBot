package it.alexm.dndbot.logic

import java.io.File

fun getPgs() = File("/Users/alex/.dndbot/pgs/").list { _, file ->
    file.contains(".json")
}?.map { it.removeSuffix(".json") }
