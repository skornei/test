package studio.lifehack.application.dependencies.fragment.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import studio.lifehack.application.dependencies.model.DaggerViewModelFactory
import studio.lifehack.ui.fragment.info.InfoContract
import studio.lifehack.ui.fragment.info.InfoFragment
import studio.lifehack.ui.fragment.info.InfoViewModel

@Module
class InfoFragmentModule {

    @Provides
    fun provideViewModel(
        fragment: InfoFragment,
        viewModelFactory: DaggerViewModelFactory
    ): InfoContract.ViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(InfoViewModel::class.java)
}