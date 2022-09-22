package com.challenge.wefitchallenge.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.wefitchallenge.databinding.ItemRepoCardBinding

class HomeCardAdapter(val listaRepo: List<String>)
    : RecyclerView.Adapter<HomeCardAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: ItemRepoCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(ItemRepoCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.binding.run {
            tvDescription.text
            tvNameRepo.text
            ivIcon
            buttonFavorite
            ivStar
            tvCounterFavorites.text
            ivDotRed
            tvLanguage.text
        }
    }

    override fun getItemCount(): Int = listaRepo.size
}