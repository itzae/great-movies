import Versions.appcompatVersion
import Versions.constraintlayoutVersion
import Versions.coreKtxVersion
import Versions.espressocoreVersion
import Versions.extjunitVersion
import Versions.junitVersion
import Versions.kotlinVersion
import Versions.materialVersion

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val corektx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
    const val material = "com.google.android.material:material:$materialVersion"
    const val constraintLayout ="androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"
    const val junit = "junit:junit:$junitVersion"
    const val extjUnit = "androidx.test.ext:junit:$extjunitVersion"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressocoreVersion"
}