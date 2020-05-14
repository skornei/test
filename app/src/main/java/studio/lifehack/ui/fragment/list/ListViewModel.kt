package studio.lifehack.ui.fragment.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import studio.lifehack.extensions.IOWithErrorHandling
import studio.lifehack.network.CloudAPI
import studio.lifehack.network.entity.CompanyEntity
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val cloudAPI: CloudAPI
): ViewModel(), ListContract.ViewModel {

    override val data: MutableLiveData<List<CompanyEntity>> = MutableLiveData()

    override val error: MutableLiveData<String> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IOWithErrorHandling { throwable ->
            error.postValue(throwable.printStackTrace().toString())
        }) {
            data.postValue(cloudAPI.getCompanyList())
        }
    }
}