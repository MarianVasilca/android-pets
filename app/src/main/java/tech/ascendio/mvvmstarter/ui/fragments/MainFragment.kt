package tech.ascendio.mvvmstarter.ui.fragments

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject
import tech.ascendio.mvvmstarter.R
import tech.ascendio.mvvmstarter.databinding.FragmentMainBinding
import tech.ascendio.mvvmstarter.ui.adapters.BookAdapter
import tech.ascendio.mvvmstarter.utilities.autoCleared
import tech.ascendio.mvvmstarter.viewmodels.BookViewModel

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

/**
 * A fragment representing the start destination of the application.
 */
class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResource: Int
        get() = R.layout.fragment_main
    override val tag: String
        get() = "MainFragment"

    private val compositeDisposable = CompositeDisposable()
    private val viewModel: BookViewModel by inject()
    private var adapter by autoCleared<BookAdapter>()

    override fun onBoundViews(savedInstanceState: Bundle?) {
        setAdapter()
        subscribeUI()
        fetch()
    }

    private fun setAdapter() {
        adapter = BookAdapter { book ->
            Snackbar.make(view!!, "Clicked on ${book.name}", Snackbar.LENGTH_LONG).show()
        }
        rvBooks.adapter = adapter
    }

    private fun fetch() = viewModel.fetch()

    private fun subscribeUI() {
        compositeDisposable += viewModel.observeCats(onNext = { books -> adapter.submitList(books) })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }
}