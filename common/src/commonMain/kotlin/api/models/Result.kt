package io.daio.kungfood.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(val title: String,
                  val method: String,
                  val image: String,
                  val group: String,
                  val ingredients: List<Ingredient>,
                  val time: String)

@Serializable
data class Ingredient(val amount: String,
                      val name: String,
                      val type: String)