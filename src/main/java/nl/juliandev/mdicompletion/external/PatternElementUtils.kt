/*
 * Copyright (c) 2020 Julian van Schijndel (JulianDev)
 * --------------------------------------------------
 * MdiCompletion - Version 1.0
 * --------------------------------------------
 * GitHub: https://github.com/Julianvschijndel
 * Website: https://juliandev.nl
 *
*/
package nl.juliandev.mdicompletion.external

import com.intellij.patterns.ElementPattern
import com.intellij.patterns.StandardPatterns

infix fun <T> ElementPattern<T>.or(rhs: ElementPattern<T>) = StandardPatterns.or(this, rhs)