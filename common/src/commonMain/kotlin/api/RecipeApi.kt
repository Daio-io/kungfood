package io.daio.kungfood.api

import io.daio.kungfood.api.models.Ingredient
import io.daio.kungfood.api.models.Recipe
import io.daio.kungfood.api.models.Response
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.http.takeFrom

class RecipeApi {

    private val endPoint = "https://jay-pi.herokuapp.com/recipes"

    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer().apply {
                setMapper(Response::class, Response.serializer())
                setMapper(Recipe::class, Recipe.serializer())
                setMapper(Ingredient::class, Ingredient.serializer())
            }
        }
    }

    suspend fun allRecipes() : Response? {
        val req = request { url {
            takeFrom(endPoint)
        } }

        return try {
            httpClient.get<Response>(req)
        } catch (ex: Throwable) {
            null
        }
    }

}