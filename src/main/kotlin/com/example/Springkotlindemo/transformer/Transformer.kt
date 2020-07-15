package com.example.Springkotlindemo.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}