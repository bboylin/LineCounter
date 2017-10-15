package xyz.bboylin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by lin on 2017/10/15.
 */
class LineCounterTask extends DefaultTask {
    def javaPath
    def resPath
    def javaLines = 0
    def resLines = 0

    @TaskAction
    def startCounting() {
        if (javaPath != null) {
            count(new File(javaPath))
        }
        if (resPath != null) {
            count(new File(resPath))
        }
        printResult()
    }

    def count(File file) {
        if (file.directory) {
            file.traverse { dir ->
                countSingleFile(dir)
            }
        }
    }

    def countSingleFile(File file) {
        if (file.directory) {
            return
        }
        int lines = file.readLines().size()
        String fileName = file.name
        println fileName + ":" + lines + " lines"
        if (fileName.endsWith(".java")) {
            javaLines += lines
        } else if (fileName.endsWith(".xml")) {
            resLines += lines
        }
    }

    def printResult() {
        println '-----------------------------'
        println 'you wrote:'
        println javaLines + ' lines in java'
        println resLines + ' lines in xml'
        println 'powered by line counter , bboylin'
        println '-----------------------------'
    }
}
