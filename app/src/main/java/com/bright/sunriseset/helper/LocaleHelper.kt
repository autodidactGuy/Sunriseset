package com.bright.sunriseset.helper

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.bright.sunriseset.R
import java.util.Locale

class LocaleHelper {
    companion object {
        private val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"

        fun onAttach(context: Context?, defaultLanguage: String?): Context? {
            val lang = getPersistedData(context!!, defaultLanguage!!)
            return setLocale(context, lang!!)
        }

        private fun setLocale(context: Context, languageCode: String): Context {
            persist(context, languageCode)

            val locale = Locale(languageCode)
            Locale.setDefault(locale)

            val config = context.resources.configuration.apply {
                setLocale(locale)
                setLayoutDirection(locale)
            }
            context.createConfigurationContext(config)
            return context
        }

        private fun getPersistedData(context: Context, defaultLanguage: String): String? {
            val preferences = context.getSharedPreferences(context.getString(R.string.app_name), MODE_PRIVATE)
            return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)
        }

        private fun persist(context: Context, language: String) {
            val preferences = context.getSharedPreferences(context.getString(R.string.app_name), MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(SELECTED_LANGUAGE, language)
            editor.apply()
        }
    }
}