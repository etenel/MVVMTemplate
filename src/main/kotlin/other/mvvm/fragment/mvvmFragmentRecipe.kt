package other.mvvm.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.mvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    fragmentClass: String,
    layoutName: String,
    packageName: String
){
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val mvvmFragment = mvvmFragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    // 保存Activity
    save(mvvmFragment, srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
    // 保存xml
    val suffix = packageName.removeSuffix(projectData.applicationPackage.toString())
    save(mvvmFragmentXml(packageName, suffix,fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
    save(mvvmViewModel(packageName, fragmentClass), srcOut.resolve("viewmodel/${fragmentClass}ViewModel.${ktOrJavaExt}"))
    // 保存repository
    save(mvvmRepository(packageName, fragmentClass), srcOut.resolve("repository/${fragmentClass}Repository.${ktOrJavaExt}"))
    //保存dagger的module
    save(mvvmMoudle(packageName,fragmentClass),srcOut.resolve("di/${fragmentClass}Module.${ktOrJavaExt}"))

}