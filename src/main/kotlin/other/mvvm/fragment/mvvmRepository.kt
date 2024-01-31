package other.mvvm.fragment

fun mvvmRepository(packageName:String, fragmentClass:String)="""
package ${packageName}.repository
import com.mvvm.base.BaseRepository
import javax.inject.Inject

class ${fragmentClass}Repository @Inject constructor()  : BaseRepository() {

    
}
"""