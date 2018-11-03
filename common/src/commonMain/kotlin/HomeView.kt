package io.daio.kungfood

import io.daio.kungfood.api.models.Response

interface HomeView {
    fun setData(data: Response)
    var isLoading: Boolean
    fun error(message: String)
}