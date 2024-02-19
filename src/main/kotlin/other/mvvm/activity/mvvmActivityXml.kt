package other.mvvm.activity

fun mvvmActivityXml(packageName: String,suffix:String,
                    activityClass: String)="""
                       
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="vm"
            type="${packageName}.viewModel.${activityClass}ViewModel" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${suffix}.${activityClass}Activity">

  

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>                        
                        
                    """