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

import nl.juliandev.mdicompletion.external.or
import nl.juliandev.mdicompletion.contributions.IconCompletionContributor

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.xml.XmlComment
import com.intellij.psi.xml.XmlText
import com.intellij.psi.xml.XmlToken


class IconCompletionForXml : IconCompletionContributor() {
    override val place = PlatformPatterns.psiElement().inside(XmlText::class.java)
        .or(PlatformPatterns.psiElement().inside(XmlToken::class.java))
        .or(PlatformPatterns.psiElement().inside(XmlComment::class.java))
}