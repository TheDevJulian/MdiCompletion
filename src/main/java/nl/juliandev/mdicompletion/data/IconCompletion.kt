/*
 * Copyright (c) 2020 Julian van Schijndel (JulianDev)
 * --------------------------------------------------
 * MdiCompletion - Version 1.0
 * --------------------------------------------
 * GitHub: https://github.com/Julianvschijndel
 * Website: https://juliandev.nl
 *
*/
package nl.juliandev.mdicompletion.data

import nl.juliandev.mdicompletion.external.findColonPosition

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class IconCompletion : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext?, result: CompletionResultSet) {
        if(parameters.editor.isOneLineMode) return
        val colonPosition = parameters.findColonPosition()
        if(colonPosition < 0) return
        IconManagement.iconList.forEach {
            result.addElement(LookupElementBuilder.create(":${it.label}:")
                    .withIcon(it.icon)
                    .withInsertHandler { insertionContext, _ ->
                        val document = insertionContext.document
                        document.replaceString(colonPosition, insertionContext.tailOffset, "<i class=\"mdi ${it.label}\"></i>")
                    }
            )
        }
    }
}
