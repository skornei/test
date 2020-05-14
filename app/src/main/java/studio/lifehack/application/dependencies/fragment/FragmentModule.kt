package studio.lifehack.application.dependencies.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import studio.lifehack.application.dependencies.fragment.modules.InfoFragmentModule
import studio.lifehack.application.dependencies.fragment.modules.ListFragmentModule
import studio.lifehack.application.dependencies.scope.FragmentScope
import studio.lifehack.ui.fragment.info.InfoFragment
import studio.lifehack.ui.fragment.list.ListFragment

@Module
abstract class FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ListFragmentModule::class])
    abstract fun listFragment(): ListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [InfoFragmentModule::class])
    abstract fun infoFragment(): InfoFragment
}