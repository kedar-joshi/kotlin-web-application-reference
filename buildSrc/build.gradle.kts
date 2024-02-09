import org.jetbrains.kotlin.gradle.dsl.JvmTarget

description = "kotlin-web-application-parent"

// Convention plugin configuration
plugins {
	// Enables convention definitions in src/main/kotlin
	`kotlin-dsl`
}

// Java compiler configuration
java {

	/**
	 * Gradle with Kotlin DSL is dependent on Kotlin to officially support the latest JDK.
	 * This means it often lags behind in offering full compilation support on the project JDK.
	 *
	 * This configuration allows compiling Gradle build scripts with the supported JDK version as target,
	 * irrespective of the target JDK for the project.
	 *
	 * See also, kotlin > compilerOptions > jvmTarget.
	 */
	targetCompatibility = JavaVersion.VERSION_21
}

// Kotlin compiler configuration
kotlin {

	// JDK specific toolchain configuration
	jvmToolchain(21)

	compilerOptions {

		/**
		 * Gradle with Kotlin DSL is dependent on Kotlin to officially support the latest JDK.
		 * This means it often lags behind in offering full compilation support on the project JDK.
		 *
		 * This configuration allows compiling Gradle build scripts with the supported JDK version as target,
		 * irrespective of the target JDK for the project.
		 *
		 * See also, java > targetCompatibility.
		 */
		jvmTarget = JvmTarget.JVM_21
	}
}

// 'buildSrc' specific dependencies
dependencies {

	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
	implementation("org.jetbrains.kotlin:kotlin-allopen:1.9.23")

	// Spring Boot
	implementation("org.springframework.boot:spring-boot-gradle-plugin:3.2.4")
}