package io.daio.kungfood

import io.daio.kungfood.api.RecipeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class Presenter : CoroutineScope {

    // Should really inject this stuff.. but hey.. its a mess about project
    private val ioContext: CoroutineContext = ioDispatcher
    private val uiContext: CoroutineContext = uiDispatcher

    private val recipeApi: RecipeApi = RecipeApi()

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    private lateinit var homeView: HomeView

    fun setView(homeView: HomeView){
        this.homeView = homeView
        load()
    }

    fun close() {
        job.cancel()
    }

    private fun load(){
        launch {
            homeView.isLoading = true
            val recipes = async(ioContext) { recipeApi.allRecipes() }
            recipes.await()
                ?.also(homeView::setData) ?: homeView.error("Data Was Null")

            homeView.isLoading = false
        }

    }

}