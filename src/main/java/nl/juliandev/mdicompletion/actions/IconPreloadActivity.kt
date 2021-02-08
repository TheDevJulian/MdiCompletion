/*
 * Copyright (c) 2020 Julian van Schijndel (JulianDev)
 * --------------------------------------------------
 * MdiCompletion - Version 1.0
 * --------------------------------------------
 * GitHub: https://github.com/Julianvschijndel
 * Website: https://juliandev.nl
 *
*/
package nl.juliandev.mdicompletion.actions

import nl.juliandev.mdicompletion.data.IconData
import nl.juliandev.mdicompletion.data.IconManagement

import com.google.gson.Gson
import com.intellij.openapi.application.PreloadingActivity
import com.intellij.openapi.application.ex.ApplicationUtil.runWithCheckCanceled
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.util.IconLoader
import java.util.concurrent.Callable

class IconPreloadActivity : PreloadingActivity() {
    override fun preload(indicator: ProgressIndicator) {
        val callable = Callable {
            javaClass.getResourceAsStream("/icons/icons.json").use { inputStream ->
                val text = inputStream.bufferedReader().readText()
                Gson().fromJson(text, Map::class.java).map {
                    val url = it.value.toString()
                    val iconPath = url.substringAfterLast("/")
                    try {
                        val icon = IconLoader.getIcon("/icons/svg/$iconPath")
                        IconData(label = it.key.toString(), url = url, icon = icon)
                    } catch (e: NumberFormatException) {
                        // If there is a problem with loading the icon. It will still execute the plugin but without icon.
                        IconData(label = it.key.toString(), url = url, icon = null)
                    }
                }
            }
        }
        IconManagement.iconList = runWithCheckCanceled(callable, indicator)
    }
}