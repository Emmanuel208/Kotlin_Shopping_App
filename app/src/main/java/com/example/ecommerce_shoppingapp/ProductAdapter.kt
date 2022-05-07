package com.example.ecommerce_shoppingapp
/**
 * Chukwuemeka Emmanuel Obasi 23606
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce_shoppingapp.ProductAdapter.*
//import com.example.kotlin_ecommerceapp.model.Product
import kotlinx.android.synthetic.main.product_row.view.*


class ProductAdapter  (private val newsList : ArrayList<formate>) : RecyclerView.Adapter<ProductAdapter.ViewHolder> () {

    private var title = arrayOf("Backing powder", "item", "item", "item")
    private var image =
       intArrayOf(R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image)
    private var price = arrayOf("$20", "$10", "$80", "$34")

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)

        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
        holder.price.text = currentItem.price

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView3)
        val title: TextView = itemView.findViewById(R.id.textView4)
        val price: TextView = itemView.findViewById(R.id.price)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }
}