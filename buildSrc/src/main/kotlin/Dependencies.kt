import Versions.activityVersion
import Versions.appcompatVersion
import Versions.archCoreVersion
import Versions.compose_activity_version
import Versions.compose_version
import Versions.constraintlayoutVersion
import Versions.coreKtxVersion
import Versions.coroutineVersion
import Versions.coroutinesTestVersion
import Versions.espressocoreVersion
import Versions.exoplayerVersion
import Versions.extjunitVersion
import Versions.fragmentVersion
import Versions.glideVersion
import Versions.hiltVersion
import Versions.hiltViewModelVersion
import Versions.junitVersion
import Versions.kotlinVersion
import Versions.lifecycleVersion
import Versions.logginInterceptorVersion
import Versions.materialVersion
import Versions.mockVersion
import Versions.navigationVersion
import Versions.retrofit2Version
import Versions.roomVersion

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
    const val viewmodel_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:$logginInterceptorVersion"
    const val kotlin_coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val activityktx = "androidx.activity:activity-ktx:$activityVersion"
    const val fragmentktx = "androidx.fragment:fragment-ktx:$fragmentVersion"
    const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
    const val exoplayerCore = "com.google.android.exoplayer:exoplayer-core:$exoplayerVersion"
    const val exoplayerDash = "com.google.android.exoplayer:exoplayer-dash:$exoplayerVersion"
    const val exoplayerUi = "com.google.android.exoplayer:exoplayer-ui:$exoplayerVersion"
    const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    const val ioMock = "io.mockk:mockk:$mockVersion"
    const val archCore = "androidx.arch.core:core-testing:$archCoreVersion"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"
    const val coroutinesTestCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesTestVersion"

    const val compose_runtime = "androidx.compose.runtime:runtime:$compose_version"
    const val compose_ui = "androidx.compose.ui:ui:$compose_version"
    const val compose_foundation = "androidx.compose.foundation:foundation:$compose_version"
    const val compose_foundation_layout = "androidx.compose.foundation:foundation-layout:$compose_version"
    const val compose_material = "androidx.compose.material:material:$compose_version"
    const val compose_runtime_livedata = "androidx.compose.runtime:runtime-livedata:$compose_version"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:$compose_version"
    const val compose_activity = "androidx.activity:activity-compose:$compose_activity_version"
}
