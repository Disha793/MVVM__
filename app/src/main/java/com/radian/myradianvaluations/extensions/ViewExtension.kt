package com.radian.myradianvaluations.extensions

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatRadioButton
import com.google.android.material.snackbar.Snackbar
import com.radian.myradianvaluations.R

/**
 * Visibility modifiers and check functions
 */
fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInVisible() {
    this.visibility = View.INVISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.makeEnabled() {
    this.isEnabled = true
}

fun View.makeDisabled() {
    this.isEnabled = false
}

fun AppCompatRadioButton.makeCheckedAndSelected() {
    this.isChecked = true
    this.isSelected = true
}

fun AppCompatRadioButton.makeNotCheckedAndSelected() {
    this.isChecked = false
    this.isSelected = false
}

fun AppCompatRadioButton.makeChecked() {
    this.isChecked = true
}

fun AppCompatRadioButton.makeSelected() {
    this.isSelected = true
}

fun AppCompatRadioButton.makeNotSelected() {
    this.isSelected = false
}

fun AppCompatRadioButton.makeNotChecked() {
    this.isChecked = false
}

fun AppCompatCheckBox.makeChecked() {
    this.isChecked = true
}

fun AppCompatCheckBox.makeNotChecked() {
    this.isChecked = false
}

inline fun View.snack(
    message: String,
    length: Int = Snackbar.LENGTH_SHORT,
    f: Snackbar.() -> Unit
) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

inline fun View.snackAction(

    mView: View,
    msg: String,
    actionText: String,
    onClickListener: View.OnClickListener
) {
    val snackbar = Snackbar.make(mView, msg, Snackbar.LENGTH_INDEFINITE)
    val snackView = snackbar.view
    snackView.setBackgroundColor(Color.BLACK)
    snackbar.setActionTextColor(Color.WHITE)
    var textView: TextView = snackView.findViewById<TextView>(R.id.snackbar_text)
    textView.setTextColor(Color.WHITE)
    snackbar.setAction(actionText, onClickListener)
    snackbar.show()
}

