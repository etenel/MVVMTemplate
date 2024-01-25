package other.mvvm.activity

fun mvvmRepository(packageName:String,activityClass:String)="""
package ${packageName}.repository
import com.mvvm.base.BaseRepository
import javax.inject.Inject

class ${activityClass}Repository @Inject constructor()  : BaseRepository() {
//        fun login(name: String): Flow<BaseData<PhoneInfo?>> = flow {
//        emit(RetrofitClient.service.login(name))
//        }
    
}
"""