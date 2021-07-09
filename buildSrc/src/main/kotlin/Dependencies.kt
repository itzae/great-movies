import Versions.activityVersion
import Versions.appcompatVersion
import Versions.constraintlayoutVersion
import Versions.coreKtxVersion
import Versions.coroutineVersion
import Versions.espressocoreVersion
import Versions.extjunitVersion
import Versions.fragmentVersion
import Versions.hiltVersion
import Versions.hiltViewModelVersion
import Versions.junitVersion
import Versions.kotlinVersion
import Versions.lifecycleVersion
import Versions.logginInterceptorVersion
import Versions.materialVersion
import Versions.navigationVersion
import Versions.retrofit2Version

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val corektx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
    const val material = "com.google.android.material:material:$materialVersion"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"
    const val junit = "junit:junit:$junitVersion"
    const val extjUnit = "androidx.test.ext:junit:$extjunitVersion"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressocoreVersion"
    const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$hiltViewModelVersion"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    const val hiltAndroidCompiler = "androidx.hilt:hilt-compiler:$hiltViewModelVersion"
    const val class_path_hilt = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:$retrofit2Version"
    const val retrofit2_gson = "com.squareup.retrofit2:converter-gson:$retrofit2Version"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:$logginInterceptorVersion"
    const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val activityktx = "androidx.activity:activity-ktx:$activityVersion"
    const val fragmentktx = "androidx.fragment:fragment-ktx:$fragmentVersion"
}
