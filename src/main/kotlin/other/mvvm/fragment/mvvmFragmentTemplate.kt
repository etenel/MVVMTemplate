package other.mvvm.fragment

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.EnumWidget
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.enumParameter
import com.android.tools.idea.wizard.template.fragmentToLayout
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val mvvmFragmentTemplate
    get() = template {
        name = "MVVM Fragment"
        description = "用于MVVM的Fragment"
        minApi = MIN_API
        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery,
            WizardUiContext.MenuEntry
        )


        val pageName = stringParameter {
            name = "Fragment Name"
            default = "MVVM"
            help = "只输入页面名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY, Constraint.UNIQUE)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_mvvm"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { fragmentToLayout(pageName.value.lowercase()) }
        }

        //val packageName = defaultPackageNameParameter
        val packageName = stringParameter {
            name = " Package Name"
            default = defaultPackageNameParameter.value
            constraints = listOf(Constraint.PACKAGE)
        }
        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }
        widgets(
            TextFieldWidget(pageName),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName),
            EnumWidget(language)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmFragmentRecipe(
                data as ModuleTemplateData,
                pageName.value,
                layoutName.value,
                packageName.value
            )
        }
    }
