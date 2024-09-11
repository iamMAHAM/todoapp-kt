package com.todoapp.ci

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform