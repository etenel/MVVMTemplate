package other.mvvm.activity

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.EnumWidget
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.Revision
import com.android.tools.idea.wizard.template.StringParameter
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.enumParameter
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val mvvmActivityTemplate
    get() = template {
        name = "MVVM Activity"
        description = "用于MVVM的Activity"
        minApi = MIN_API
        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val pageName = stringParameter {
            name = "Activity Name"
            default = "MVVM"
            help = "只输入页面名字，不要包含Activity"
            constraints = listOf(Constraint.NONEMPTY, Constraint.UNIQUE)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_mvvm"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { activityToLayout(pageName.value.lowercase()) }
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
            mvvmActivityRecipe(
                data as ModuleTemplateData,
                pageName.value,
                layoutName.value,
                packageName.value
            )
        }
    }
