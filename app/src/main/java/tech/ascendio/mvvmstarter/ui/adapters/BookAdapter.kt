package tech.ascendio.mvvmstarter.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import tech.ascendio.mvvmstarter.R
import tech.ascendio.mvvmstarter.data.vo.Book
import tech.ascendio.mvvmstarter.databinding.BookItemBinding

/*
 * Copyright (C) 2018 Marian Vasilca@Ascendio TechVision
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class BookAdapter(
        private val callback: ((Book) -> Unit)?
) : DataBoundListAdapter<Book, BookItemBinding>(
        diffCallback = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.name == newItem.name
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int): BookItemBinding {
        val binding = DataBindingUtil
                .inflate<BookItemBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.book_item,
                        parent,
                        false
                )
        binding.root.setOnClickListener { _ ->
            binding.book?.let {
                callback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: BookItemBinding, item: Book, position: Int) {
        binding.book = item
    }
}