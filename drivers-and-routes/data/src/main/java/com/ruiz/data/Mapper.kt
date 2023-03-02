package com.ruiz.data

abstract class Mapper<in FROM, out TO> {
    abstract operator fun invoke(from: FROM): TO
}