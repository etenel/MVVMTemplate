package other.mvvm.activity

fun mvvmMoudle (  packageName:String,
                  activityClass:String)="""
 
package ${packageName}.di

import com.mvvm.base.IRepository
import ${packageName}.repository.${activityClass}Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ${activityClass}Module {
    @Binds
    fun bind${activityClass}Repository(repository: ${activityClass}Repository): IRepository

}                     
                  """