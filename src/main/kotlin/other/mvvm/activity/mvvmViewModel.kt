package other.mvvm.activity

fun mvvmViewModel(  packageName:String,
                    activityClass:String)="""
                      
package ${packageName}.viewModel
import com.mvvm.base.BaseViewModel
import ${packageName}.repository.${activityClass}Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${activityClass}ViewModel @Inject constructor(model: ${activityClass}Repository) :
    BaseViewModel<${activityClass}Repository>(model) {

 
      
}

                    """