// Plugins common for sub-modules
plugins {

	// Spring Boot plugin configuration
	id("org.springframework.boot")

	// Spring Boot dependency management configuration
	id("io.spring.dependency-management")

	// Kotlin compiler plugin for JVM
	kotlin("jvm")

	// Kotlin plugin for Spring
	kotlin("plugin.spring")
}

group = "dev.workingtheory.reference"
version = "1.0.0-SNAPSHOT"

// Spring Boot dependency overrides
extra["slf4j.version"] = "2.0.9"

// Enabled by 'Java' plugin
java {

}

// Enabled by 'Kotlin' plugin
kotlin {

	// JDK specific toolchain configuration
	jvmToolchain(21)

	compilerOptions {
		freeCompilerArgs.add("-Xjsr305=strict")
	}
}

// JUnit platform configuration
tasks.withType<Test> {
	useJUnitPlatform()
}

// Dependencies common for sub-modules
dependencies {

	// Logging
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	implementation("com.lmax:disruptor:3.4.4") // Required by Log4j2 for asynchronous logging

	// Spring framework
	implementation("org.springframework.boot:spring-boot-starter-web") {

		// Disabling default 'logback' logging in favor of Log4j2
		exclude("org.springframework.boot", "spring-boot-starter-logging")

		// Disabling unused snakeyaml dependency.
		exclude("org.yaml", "snakeyaml")
	}

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}