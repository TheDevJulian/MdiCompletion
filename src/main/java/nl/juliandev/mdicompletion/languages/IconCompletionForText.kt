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

import com.intellij.patterns.ElementPattern
import nl.juliandev.mdicompletion.contributions.IconCompletionContributor

import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiPlainText

class IconCompletionForText : IconCompletionContributor() {
    override val place: PsiElementPattern.Capture<PsiPlainText> = PlatformPatterns.psiElement(PsiPlainText::class.java)
}