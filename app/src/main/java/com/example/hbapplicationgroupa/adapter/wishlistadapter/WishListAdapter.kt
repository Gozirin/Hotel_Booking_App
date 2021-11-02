package com.example.hbapplicationgroupa.adapter.wishlistadapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.hbapplicationgroupa.R
import com.example.hbapplicationgroupa.databinding.WishListItemsBinding
import com.example.hbapplicationgroupa.model.customermodule.getcustomerwishlistbypagenumber.WishlistByPageNumberResponseItems


class WishListAdapter(var context: Context,
                      private val wishListItemClickListener: WishListItemClickListener,
                      private val wishListPreviewButtonClickListener: WishListPreviewButtonClickListener,
                      private val wishListRemoveButtonClickListener: WishListRemoveButtonClickListener
                      ) :
    RecyclerView.Adapter<WishListAdapter.WishListViewHolder>() {

     var listOfWishList = mutableListOf<WishlistByPageNumberResponseItems>()

    inner class WishListViewHolder(binding: WishListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        var hotelPrice: TextView = binding.tvHotelprice
        var hotelName: TextView = binding.tvNameOfHotel
        var hotelRating: TextView = binding.tvHotelRating
        val removeText: TextView = binding.tvRemove
        val removeIcon: ImageView = binding.removeIcon
        val previewBtn: Button = binding.bookingBtn
        val savedImage: ImageView = binding.hotelImageView

    }

    interface WishListItemClickListener {
        fun wishListClicked(position: Int)
    }

    interface WishListPreviewButtonClickListener {
        fun wishListPreviewBtnClicked(position: Int)
    }

    interface WishListRemoveButtonClickListener {
        fun wishlistRemoveBtnClicked(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListViewHolder {
        val binding = WishListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return WishListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WishListViewHolder, position: Int) {
        holder.hotelName.text = listOfWishList[position].hotelName
        Log.d("Name", listOfWishList[position].hotelName)
        holder.hotelPrice.text = listOfWishList[position].price.toString()
        holder.hotelRating.text = listOfWishList[position].percentageRating.toInt().toString()
        holder.savedImage.let {
            Glide.with(it.context)
                .load(listOfWishList[position].ImageUrl)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.savedImage)
        }


        holder.apply {

            // set the onclick listener to the bookmark icon
            removeIcon.setOnClickListener {
                wishListRemoveButtonClickListener.wishlistRemoveBtnClicked(position)
            }

            // set the onclick listener to the booking button
            previewBtn.setOnClickListener {
                wishListPreviewButtonClickListener.wishListPreviewBtnClicked(position)
//
            }

            //click listener for each saved Item
            holder.savedImage.setOnClickListener {
                wishListItemClickListener.wishListClicked(position)
            }
        }
    }
    override fun getItemCount() = listOfWishList.size

    //setting data to listOfWishList
    fun setDataToAdapter(list: ArrayList<WishlistByPageNumberResponseItems>){
        listOfWishList.clear()
        listOfWishList = list
        notifyDataSetChanged()
    }

}