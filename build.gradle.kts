plugins {
    java
}

group = "org.socis"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.google.code.gson:gson:2.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}