plugins {
	java
	id("org.springframework.boot") version "4.0.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "br.com.db"
version = "0.0.1-SNAPSHOT"
description = "Desafio votação"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("jakarta.validation:jakarta.validation-api")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("org.apache.commons:commons-lang3:3.20.0")
	implementation("com.h2database:h2")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	main {
		java {
			exclude("br/com/db/desafio/votacao/service/VotacaoService.java")
			exclude("br/com/db/desafio/votacao/controller/VotacaoController.java")
		}
	}
	test {
		java {
			exclude("br/com/db/desafio/votacao/**")
		}
	}
}
