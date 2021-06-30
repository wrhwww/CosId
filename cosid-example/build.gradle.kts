plugins {
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
    implementation(platform(project(":cosid-dependencies")))
    implementation(project(":spring-boot-starter-cosid"))
    implementation(project(":cosid-redis"))
    implementation("me.ahoo.cosky:cosky-spring-cloud-core")
//    implementation(project(":spring-boot-starter-cosid")){
//        capabilities {
//            requireCapability("me.ahoo.cosid:redis-support")
//        }
//    }
    implementation("io.springfox:springfox-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("com.google.guava:guava")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok:${rootProject.ext.get("lombokVersion")}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${rootProject.ext.get("springBootVersion")}")
    annotationProcessor("org.projectlombok:lombok:${rootProject.ext.get("lombokVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
