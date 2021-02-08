/*
 * Copyright (c) 2020 Julian van Schijndel (JulianDev)
 * --------------------------------------------------
 * MdiCompletion - Version 1.0
 * --------------------------------------------
 * GitHub: https://github.com/Julianvschijndel
 * Website: https://juliandev.nl
 *
*/
package nl.juliandev.mdicompletion.contributions

import nl.juliandev.mdicompletion.data.IconCompletion
import nl.juliandev.mdicompletion.external.findColonPosition

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext


abstract class IconCompletionContributor(protected val provider: CompletionProvider<CompletionParameters> = IconCompletion()) : CompletionContributor() {
    abstract val place: ElementPattern<out PsiElement>
    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) { super.fillCompletionVariants(parameters, result)
        if(parameters.completionType == CompletionType.BASIC && place.accepts(parameters.position)) {
            val colonPosition = parameters.findColonPosition()
            val newResult = if(colonPosition >= 0) {
                val prefix = parameters.editor.document.getText(TextRange(colonPosition, parameters.editor.caretModel.currentCaret.offset))
                result.withPrefixMatcher(prefix)
            } else {
                result
            }
            provider.addCompletionVariants(parameters, ProcessingContext(), newResult)
        }
    }
}