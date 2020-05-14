package studio.lifehack.ui.fragment.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import studio.lifehack.extensions.IOWithErrorHandling
import studio.lifehack.network.CloudAPI
import studio.lifehack.network.entity.CompanyEntity
import javax.inject.Inject

class InfoViewModel@Inject constructor(
    private val cloudAPI: CloudAPI
): ViewModel(), InfoContract.ViewModel {

    override val data: MutableLiveData<CompanyEntity> = MutableLiveData()

    override val error: MutableLiveData<String> = MutableLiveData()

    override fun setCompanyId(id: String) {
        viewModelScope.launch(Dispatchers.IOWithErrorHandling { throwable ->
            error.postValue(throwable.printStackTrace().toString())
        }) {
            data.postValue(cloudAPI.getCompany(id).first())
        }
    }
}