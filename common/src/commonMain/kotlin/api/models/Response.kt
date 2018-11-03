package io.daio.kungfood.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Response(val status: String,
                    val result: List<Recipe>)