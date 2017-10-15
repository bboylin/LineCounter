package xyz.bboylin.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import xyz.bboylin.task.LineCounterTask;

/**
 * Created by lin on 2017/10/15.
 */
class LineCounterPlugin implements Plugin<Project> {

    private static final String TASK_NAME = "lineCounter"
    private static final String WINDOWS_JAVA_PATH = "\\app\\src\\main\\java"
    private static final String WINDOWS_RES_PATH = "\\app\\src\\main\\res\\layout"
    private static final String UNIX_JAVA_PATH = "/app/src/main/java"
    private static final String UNIX_RES_PATH = "/app/src/main/res/layout"

    @Override
    void apply(Project project) {
        LineCounterExtension ext=project.extensions.create(TASK_NAME, LineCounterExtension)
        LineCounterTask task = project.tasks.create(TASK_NAME, LineCounterTask)
        task.doFirst {
            String rootPath = project.rootDir.absolutePath
            String javaPath=ext.unix?UNIX_JAVA_PATH:WINDOWS_JAVA_PATH
            String resPath=ext.unix?UNIX_RES_PATH:WINDOWS_RES_PATH
            task.javaPath = rootPath + javaPath
            task.resPath = rootPath + resPath
        }
    }
}
