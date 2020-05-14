package studio.lifehack.application.dependencies.fragment.modules

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import studio.lifehack.application.dependencies.model.DaggerViewModelFactory
import studio.lifehack.ui.fragment.list.ListContract
import studio.lifehack.ui.fragment.list.ListFragment
import studio.lifehack.ui.fragment.list.ListViewModel

@Module
class ListFragmentModule {

    @Provides
    fun layoutInflater(fragment: ListFragment): LayoutInflater =
        LayoutInflater.from(fragment.requireContext())

    @Provides
    fun provideViewModel(
        fragment: ListFragment,
        viewModelFactory: DaggerViewModelFactory
    ): ListContract.ViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(ListViewModel::class.java)
}