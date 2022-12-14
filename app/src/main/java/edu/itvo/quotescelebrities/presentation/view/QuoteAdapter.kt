package edu.itvo.quotescelebrities.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import edu.itvo.quotescelebrities.R
import edu.itvo.quotescelebrities.core.utils.CellClickListener
import edu.itvo.quotescelebrities.databinding.QuoteItemBinding
import edu.itvo.quotescelebrities.domain.model.QuoteModel


class QuoteAdapter(private val quotes: List<QuoteModel>,
                 private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val binding = QuoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(binding)
    }
    inner class ViewHolder(val binding: QuoteItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder){
            with(quotes[position]){
                binding.tvQuote.text =  this.quote
                binding.tvAuthor.text = this.author

                binding.cvQuote.findViewById<ImageView>(R.id.btnEdit).setOnClickListener {
                    cellClickListener.onCellClickListener(this)
                }

                binding.cvQuote.findViewById<ImageView>(R.id.btnDelete).setOnClickListener {
                    // Función para eliminar la cita
                }

                /*binding.cvQuote.setOnClickListener{
                    cellClickListener.onCellClickListener(this)
                }*/
            }
        }
    }


    override fun getItemCount(): Int {
        return quotes.size
    }

}