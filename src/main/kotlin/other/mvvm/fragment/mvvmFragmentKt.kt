package other.mvvm.fragment

fun mvvmFragmentKt(
    applicationPackage: String?,
    fragmentClass: String,
    layoutName: String,
    packageName: String
) = """
package $packageName
import android.os.Bundle
import com.mvvm.base.BaseFragment
import ${applicationPackage}.BR
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding
import ${packageName}.viewModel.${fragmentClass}ViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ${fragmentClass}Fragment : BaseFragment<Fragment${fragmentClass}Binding, ${fragmentClass}ViewModel>() {
   

    override fun initViewObservable() {

    }
    
    override fun initData(savedInstanceState: Bundle?) {
    
    }
    
    
    override fun hideRefresh() {
    
    }

    override fun hideLoadMore() {
    
    }
    
    override fun initView(): Int {
        return R.layout.${layoutName}
    }

    override fun initVariableId(): Int {
        return BR.vm
    }
}
                  
                  
                  
                  
                  
"""