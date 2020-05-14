package studio.lifehack.ui.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import studio.lifehack.R
import studio.lifehack.network.entity.CompanyEntity
import studio.lifehack.settings.DefaultSettings
import javax.inject.Inject

class ListAdapter @Inject constructor(
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<ListAdapter.ListHolder>() {

    private var items: List<CompanyEntity> = emptyList()

    var listener: ((CompanyEntity) -> Unit)? = null

    fun setItems(items: List<CompanyEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            inflater.inflate(R.layout.item_company, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image = itemView.findViewById<ImageView>(R.id.image)
        private val name = itemView.findViewById<TextView>(R.id.name)

        fun bind(company: CompanyEntity, listener: ((CompanyEntity) -> Unit)?) {
            Glide.with(image.context)
                .load(DefaultSettings.ROOT_URL + company.img)
                .into(image)

            name.text = company.name

            itemView.setOnClickListener {
                listener?.invoke(company)
            }
        }
    }
}