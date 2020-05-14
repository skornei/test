package studio.lifehack.application.dependencies.model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import studio.lifehack.ui.fragment.info.InfoViewModel
import studio.lifehack.ui.fragment.list.ListViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun listViewModel(viewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InfoViewModel::class)
    fun infoViewModel(viewModel: InfoViewModel): ViewModel
}