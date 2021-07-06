import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin.Companion.findKaptConfiguration

plugins {
	java
	kotlin("jvm") version "1.5.10"
	`maven-publish`
}

group = "io.github.mrpng"
version = "1.0.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}

publishing {

	repositories {
		maven {
			name = "GitHubPackages"
			setUrl("https://maven.pkg.github.com/" + System.getenv("GITHUB_REPOSITORY"))
			credentials {
				username = System.getenv("GITHUB_ACTOR")
				password = System.getenv("GITHUB_TOKEN")
			}
		}
	}
}