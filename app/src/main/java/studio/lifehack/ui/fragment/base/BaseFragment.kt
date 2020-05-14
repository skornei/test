package studio.lifehack.ui.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    /**
     * Получить ресурс разметки
     */
    abstract fun getContentView(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Резолвим зависимости
        AndroidSupportInjection.inject(this)
    }

    /**
     * Создаем фрагмент
     * @param inflater инфлейтер
     * @param container группа
     * @param savedInstanceState бандл
     * @return вью
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getContentView(), container, false)
}