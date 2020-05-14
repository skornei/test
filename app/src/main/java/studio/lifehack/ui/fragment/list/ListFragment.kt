package studio.lifehack.ui.fragment.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import studio.lifehack.R
import studio.lifehack.settings.DefaultSettings
import studio.lifehack.ui.fragment.base.BaseFragment
import javax.inject.Inject


class ListFragment: BaseFragment() {

    @Inject
    lateinit var viewModel: ListContract.ViewModel

    @Inject
    lateinit var adapter: ListAdapter

    override fun getContentView() = R.layout.fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.listener = {
            Navigation.findNavController(requireActivity(), R.id.activity_placeholder).apply {
                navigate(
                    R.id.action_listFragment_to_infoFragment,
                    Bundle().apply {
                        putString(DefaultSettings.ID_EXTRA_NAME, it.id)
                    }
                )
            }
        }

        //Установка адаптера
        recycler.setHasFixedSize(true)
        recycler.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner, Observer { companyList ->
            adapter.setItems(companyList)
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