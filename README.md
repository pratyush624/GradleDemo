# Setup of basic  gradle using cli
'''agsl
gradle init --use-defaults --type java-application
'''

The above command will setup a basic gradle project

'''agsl
.gradle build
'''

To prepare a jar which is executable, you need to setup manifest property in '''agsl build.gradle''' to identify what is in the main class to execute
'''groovy
jar{
    manifest {
        attributes(
            'Main-Class': 'org.example.Main'
        )
    }
}
'''

The above command can build your project

'''agsl
gradle jar
'''

The above command creates a new jar file in 'build/libs folder

'''agsl
java -jar build/libs/filename.jar
'''

The above command will execute your code
