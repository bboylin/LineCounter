### LineCounter:一个简单的统计代码行数的gradle插件

----

主要是为了学习gradle插件开发写的小demo

#### usage：

1.下载[line_counter-1.0.0.jar](https://github.com/bboylin/LineCounter/blob/master/line_counter-1.0.0.jar)，放置于项目根目录

2.在project的build.gradle中添加依赖和配置：
```groovy
buildscript {
    ......
    dependencies {
        ......
        classpath files('line_counter-1.0.0.jar')
    }
}

apply plugin: 'LineCounterPlugin'

lineCounter {
    unix = false //用户系统是否是Unix
}
```

3.项目根目录下命令行执行`./gradlew lineCounter`即可见到统计结果。

![](https://github.com/bboylin/LineCounter/blob/master/cmd.png)