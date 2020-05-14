package studio.lifehack.ui.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasAndroidInjector {

    /**
     * Получить ресурс разметки
     */
    abstract fun getContentView(): Int

    /**
     * Инжектор
     */
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    /**
     * Создаем активность
     * @param savedInstanceState сохраненное состояние
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //Резолвим зависимости
        AndroidInjection.inject(this)

        //Вызываем родителя
        super.onCreate(savedInstanceState)

        //Устанавливаем файл разметки
        setContentView(getContentView())
    }

    /**
     * Инжектор
     */
    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}