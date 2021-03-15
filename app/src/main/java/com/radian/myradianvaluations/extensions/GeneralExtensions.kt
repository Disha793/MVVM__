package com.radian.myradianvaluations.extensions

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.utils.LogUtils
import java.util.*


/**
 * Wrapping try/catch to ignore catch block
 */
inline fun <T> justTry(block: () -> T) = try {
    block()
} catch (e: Exception) {
    LogUtils.logE("GeneralExtension", e)
}

/**
 * App's debug mode
 */
inline fun debugMode(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}

fun Uri.getRealPathString(context: Context): String {
    var path = ""
    justTry {
        context.contentResolver.query(this, arrayOf(MediaStore.Images.Media.DATA), null, null, null)
                ?.apply {
                    val columnIndex = getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                    moveToFirst()
                    path = getString(columnIndex)
                    close()
                }
    }
    return path
}

fun String.getUri(): Uri {
    return Uri.parse(this)
}

fun String.getPathFromStringUri(): String {
    return Uri.parse(this).path.toString()
}

fun String.toDoubleDigit(): String {
    return String.format("%02d", this.toInt())
}

fun String.toCapFirstLetter(): String {
    return if (this.isNotEmpty()) this.substring(
            0, 1
    ).toUpperCase(Locale.ROOT) + this.substring(1).toLowerCase(Locale.ROOT) else ""
}

fun String.toReplaceDotWithSpace(): String {
    return this.replace(".", " ")
}

