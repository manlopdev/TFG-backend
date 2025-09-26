package com.manlop.tfg.TFG_backend

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<TfgBackendApplication>().with(TestcontainersConfiguration::class).run(*args)
}
