package tech.ascendio.mvvmstarter.ui.fragments

import android.os.Bundle
import tech.ascendio.mvvmstarter.R
import tech.ascendio.mvvmstarter.databinding.FragmentRegisterBinding

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

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    override val layoutResource: Int
        get() = R.layout.fragment_register

    override fun onBoundViews(savedInstanceState: Bundle?) {
    }
}