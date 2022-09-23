package com.challenge.wefitchallenge.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.challenge.wefitchallenge.data.models.RepositoryInfo
import com.challenge.wefitchallenge.databinding.ItemRepoCardBinding
import com.challenge.wefitchallenge.domain.loadImage

class HomeCardAdapter(
    private val repositoryList: ArrayList<RepositoryInfo>,
    private val onClick: ((repository: RepositoryInfo) -> Unit)?
) : RecyclerView.Adapter<HomeCardAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: ItemRepoCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ItemRepoCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.binding.run {
            val currentRepository = repositoryList[position]
            tvDescription.text = currentRepository.description
            tvNameRepo.text = currentRepository.full_name
            ivIcon.loadImage(currentRepository.owner.avatar_url)
            tvCounterFavorites.text = currentRepository.stargazers_count.toString()
            tvLanguage.text = currentRepository.language
            if (onClick != null) {
                buttonFavorite.setOnClickListener {
                    onClick.invoke(currentRepository)
                    repositoryList.remove(currentRepository)
                    notifyDataSetChanged()
                }
            } else {
                buttonFavorite.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int = repositoryList.size
}