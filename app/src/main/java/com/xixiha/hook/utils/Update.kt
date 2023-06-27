package com.xixiha.hook.utils

import java.io.*
import java.nio.file.*
import java.nio.file.attribute.BasicFileAttributes

object Update {
    fun deleteOld(patchDir: File) {
        val path = Paths.get(patchDir.path)
        Files.walkFileTree(path, object : SimpleFileVisitor<Path>() {
            override fun visitFile(file: Path?, attrs: BasicFileAttributes?): FileVisitResult {
                Files.delete(file)
                return FileVisitResult.CONTINUE
            }

            override fun postVisitDirectory(dir: Path?, exc: IOException?): FileVisitResult {
                Files.delete(dir)
                return FileVisitResult.CONTINUE
            }
        })
        patchDir.mkdir()
    }
}
