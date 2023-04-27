plugins {
    id("java")
}

group = "org.gorbunov"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.postgresql:postgresql:42.6.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter")


}

tasks.test {
    useJUnitPlatform()
}