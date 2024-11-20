package com.example.movieapp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonAdapter(private val people: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImageView: ImageView = itemView.findViewById(R.id.profileImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val knownForTextView: TextView = itemView.findViewById(R.id.knownForTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.nameTextView.text = person.name

        val knownForTitles = person.known_for.joinToString(", ") {
            it.title ?: it.name ?: ""
        }
        holder.knownForTextView.text = "Known for: $knownForTitles"

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + person.profile_path)
            .placeholder(R.drawable.placeholder_image)
            .into(holder.profileImageView)
    }

    override fun getItemCount() = people.size
}
