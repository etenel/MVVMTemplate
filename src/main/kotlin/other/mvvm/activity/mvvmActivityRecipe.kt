package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
){
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = false
//    )
    val mvvmActivity = mvvmAcitivityKt(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
//    com.etrnel.demo.ui.activity   com.eternel.demo
    val suffix = packageName.removeSuffix(projectData.applicationPackage.toString())
    save(mvvmActivityXml(packageName, suffix,activityClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
    save(mvvmViewModel(packageName, activityClass), srcOut.resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}"))
    // 保存repository
    save(mvvmRepository(packageName, activityClass), srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}"))
    //保存dagger的module
    save(mvvmMoudle(packageName,activityClass),srcOut.resolve("di/${activityClass}Module.${ktOrJavaExt}"))

}