package studio.lifehack.application.dependencies

import dagger.Component
import studio.lifehack.application.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
}