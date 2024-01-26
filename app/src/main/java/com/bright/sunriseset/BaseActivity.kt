package com.bright.sunriseset

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.bright.sunriseset.helper.LocaleHelper
import java.util.Locale

open class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(base, Locale.CHINESE.language));
    }
}