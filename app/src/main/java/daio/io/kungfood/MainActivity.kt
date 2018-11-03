package daio.io.kungfood

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import daio.io.kungfood.adapters.RecipeAdapter
import io.daio.kungfood.HomeView
import io.daio.kungfood.Presenter
import io.daio.kungfood.api.models.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeView {

    private val presenter = Presenter()
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recipeAdapter = RecipeAdapter()
        with(recipes_list) {
            adapter = recipeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        presenter.setView(this)
    }

    override fun error(message: String) {
        Toast.makeText(this, "There was an error", Toast.LENGTH_LONG).show()
    }

    override fun setData(data: Response) {
        recipeAdapter.resources = data.result
    }

    override var isLoading: Boolean
        get() = loading_spinner.visibility == View.VISIBLE
        set(value) {
            if(value) {
                loading_spinner.visibility = View.VISIBLE
            } else {
                loading_spinner.visibility = View.GONE
            }
        }
}
