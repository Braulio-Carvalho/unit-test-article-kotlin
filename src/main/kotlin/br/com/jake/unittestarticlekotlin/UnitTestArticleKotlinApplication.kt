package br.com.jake.unittestarticlekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnitTestArticleKotlinApplication

fun main(args: Array<String>) {
	runApplication<UnitTestArticleKotlinApplication>(*args)
}
