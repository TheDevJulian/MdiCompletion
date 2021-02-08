/*
 * Copyright (c) 2020 Julian van Schijndel (JulianDev)
 * --------------------------------------------------
 * MdiCompletion - Version 1.0
 * --------------------------------------------
 * GitHub: https://github.com/Julianvschijndel
 * Website: https://juliandev.nl
 *
*/
package nl.juliandev.mdicompletion.languages

import nl.juliandev.mdicompletion.contributions.IconCompletionContributor

import com.intellij.patterns.PlatformPatterns
import org.jetbrains.kotlin.psi.KtBlockStringTemplateEntry
import org.jetbrains.kotlin.psi.KtStringTemplateExpression

class IconCompletionForKotlin : IconCompletionContributor() {
    override val place = PlatformPatterns.psiElement().inside(KtStringTemplateExpression::class.java)
            .andNot(PlatformPatterns.psiElement().inside(KtBlockStringTemplateEntry::class.java))
}