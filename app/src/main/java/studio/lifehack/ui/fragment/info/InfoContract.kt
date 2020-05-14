package studio.lifehack.ui.fragment.info

import androidx.lifecycle.MutableLiveData
import studio.lifehack.network.entity.CompanyEntity

interface InfoContract {

    interface ViewModel {
        val data: MutableLiveData<CompanyEntity>
        val error: MutableLiveData<String>
        fun setCompanyId(id: String)
    }
}