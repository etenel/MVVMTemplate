package other.mvvm.fragment

fun mvvmMoudle (packageName:String,
                fragmentClass:String)="""
 
package ${packageName}.di

import com.mvvm.base.IRepository
import ${packageName}.repository.${fragmentClass}Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ${fragmentClass}Module {
    @Binds
    fun bind${fragmentClass}Repository(repository: ${fragmentClass}Repository): IRepository

}                     
                  """