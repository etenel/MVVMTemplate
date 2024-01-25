package com.github.etenel.mvvmtemplate.listeners

import com.github.etenel.mvvmtemplate.services.MyProjectService
import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.IdeFrame
import java.awt.Window

internal class MyApplicationActivationListener : ApplicationActivationListener {

    override fun applicationActivated(ideFrame: IdeFrame) {
        projectInstance=ideFrame.project
        projectInstance?.getService(MyProjectService::class.java)

    }

    override fun applicationDeactivated(ideFrame: IdeFrame) {
        projectInstance=null
        super.applicationDeactivated(ideFrame)
    }
    companion object{
        var projectInstance:Project?=null
    }
}
