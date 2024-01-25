package other.mvvm.activity

fun mvvmAcitivityKt(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String
) = """
 package ${packageName}
import android.os.Bundle
import com.mvvm.base.BaseActivity
import ${applicationPackage}.BR
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Activity${activityClass}Binding
import ${packageName}.viewModel.${activityClass}ViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ${activityClass}Activity : BaseActivity<Activity${activityClass}Binding, ${activityClass}ViewModel>() {
    override fun initView(): Int {
        return R.layout.${layoutName}
    }

    override fun initVariableId(): Int {
        return BR.vm
    }
    
    override fun initViewObservable() {
       
           
    }
    
    override fun initData(savedInstanceState: Bundle?) {

    }
    
    override fun hideRefresh() {
    
    }

    override fun hideLoadMore() {
    }
}
                  
                  
                  
                  
                  
"""