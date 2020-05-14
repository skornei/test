package studio.lifehack.application

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import studio.lifehack.application.dependencies.AppModule
import studio.lifehack.application.dependencies.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    /**
     * Инжектор
     */
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        //Создаем компонент
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }

    /**
     * Инжектор
     */
    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}