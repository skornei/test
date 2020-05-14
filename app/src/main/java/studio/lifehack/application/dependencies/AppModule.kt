package studio.lifehack.application.dependencies

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import studio.lifehack.application.dependencies.activity.ActivityModule
import studio.lifehack.application.dependencies.fragment.FragmentModule
import studio.lifehack.application.dependencies.model.ViewModelModule
import javax.inject.Singleton

@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        CloudApiModule::class,
        ActivityModule::class,
        FragmentModule::class
    ]
)
class AppModule(

    /**
     * Контекст приложения
     */
    private val application: Application
) {

    /**
     * Контекст приложения
     * @return контекст приложения
     */
    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }
}