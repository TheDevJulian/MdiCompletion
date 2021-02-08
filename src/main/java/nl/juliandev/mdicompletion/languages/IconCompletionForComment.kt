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
import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement

class IconCompletionForComment : IconCompletionContributor() {
    override val place: ElementPattern<out PsiElement> = PlatformPatterns.psiElement().inside(PsiComment::class.java)
}