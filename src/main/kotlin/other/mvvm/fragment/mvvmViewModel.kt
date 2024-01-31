package other.mvvm.fragment

fun mvvmViewModel(packageName:String,
                  fragmentClass:String)="""
                      
package ${packageName}.viewModel
import com.mvvm.base.BaseViewModel
import ${packageName}.repository.${fragmentClass}Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${fragmentClass}ViewModel @Inject constructor(model: ${fragmentClass}Repository) :
    BaseViewModel<${fragmentClass}Repository>(model) {

 
      
}

                    """