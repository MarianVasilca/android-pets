package tech.ascendio.mvvmstarter.utilities.extensions

import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

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

fun View.showSnackbarLong(@StringRes message: Int) =
        showSnackbarLong(resources.getString(message))

fun View.showSnackbarLong(message: String) =
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()

fun View.setVisibleIf(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.GONE
}

fun EditText.onChange(cb: (String) -> Unit) = this.addTextChangedListener(object : TextWatcher {
    override fun afterTextChanged(s: Editable?) = cb(s.toString())
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
})

fun EditText.onPasswordTransformation(hidePassword: Boolean) {
    transformationMethod = if (hidePassword) PasswordTransformationMethod() else null
    setSelection(length())
}