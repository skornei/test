package studio.lifehack.application.dependencies.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import studio.lifehack.ui.activity.main.MainActivity
import studio.lifehack.application.dependencies.scope.ActivityScope

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}