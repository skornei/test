package studio.lifehack.ui.fragment.info

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_info.*
import studio.lifehack.R
import studio.lifehack.settings.DefaultSettings
import studio.lifehack.ui.fragment.base.BaseFragment
import javax.inject.Inject

class InfoFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: InfoContract.ViewModel

    override fun getContentView() = R.layout.fragment_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Отдаем идентификатор компании
        arguments?.getString(DefaultSettings.ID_EXTRA_NAME)?.let {
            viewModel.setCompanyId(it)
        }

        viewModel.data.observe(viewLifecycleOwner, Observer { company ->
            Glide.with(this)
                .load(DefaultSettings.ROOT_URL + company.img)
                .into(image)

            name.text = company.name
            description.text = company.description
            lat.text = company.lat.toString()
            lon.text = company.lon.toString()
            www.text = company.www
            phone.text = company.phone
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                error,
                Snackbar.LENGTH_LONG
            ).show()
        })
    }
}