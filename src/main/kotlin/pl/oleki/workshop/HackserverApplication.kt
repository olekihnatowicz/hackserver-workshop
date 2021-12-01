package pl.oleki.workshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HackserverApplication

fun main(args: Array<String>) {
	runApplication<HackserverApplication>(*args)
}
