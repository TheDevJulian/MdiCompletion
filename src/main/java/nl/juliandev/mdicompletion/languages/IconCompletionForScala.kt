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
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import org.jetbrains.plugins.scala.lang.psi.api.base.ScLiteral
import org.jetbrains.plugins.scala.lang.psi.api.expr.ScInfixExpr

class IconCompletionForScala : IconCompletionContributor() {
    override val place: PsiElementPattern.Capture<PsiElement> = PlatformPatterns.psiElement().inside(ScLiteral::class.java)
            .andNot(PlatformPatterns.psiElement().inside(ScInfixExpr::class.java))
}