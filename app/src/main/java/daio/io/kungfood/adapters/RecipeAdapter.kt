package daio.io.kungfood.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import daio.io.kungfood.R
import io.daio.kungfood.api.models.Recipe

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    var resources: List<Recipe>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        resources?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount() = resources?.count() ?: 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleText = itemView.findViewById<TextView>(R.id.recipe_title)
        private val imageView = itemView.findViewById<ImageView>(R.id.recipe_image)

        fun bind(recipe: Recipe) {
            titleText.text = recipe.title
            if (recipe.image.isEmpty()) return
            Picasso.get().load(recipe.image).into(imageView)
        }
    }

}