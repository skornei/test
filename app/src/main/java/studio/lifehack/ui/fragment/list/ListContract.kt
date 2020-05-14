package studio.lifehack.ui.fragment.list

import androidx.lifecycle.MutableLiveData
import studio.lifehack.network.entity.CompanyEntity

interface ListContract {

    interface ViewModel {
        val data: MutableLiveData<List<CompanyEntity>>
        val error: MutableLiveData<String>
    }
}