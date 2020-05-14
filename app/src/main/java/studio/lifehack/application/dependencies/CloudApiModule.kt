package studio.lifehack.application.dependencies

import com.jaredsburrows.retrofit2.adapter.synchronous.SynchronousCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import studio.lifehack.settings.DefaultSettings
import studio.lifehack.network.CloudAPI
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class CloudApiModule {

    /**
     * Получаем конвертер
     * @return конвертер
     */
    private fun defaultConverter(): retrofit2.Converter.Factory = JacksonConverterFactory.create()

    /**
     * Получаем адаптер
     * @return адаптер
     */
    private fun defaultCallAdapter(): retrofit2.CallAdapter.Factory =
        SynchronousCallAdapterFactory.create()

    /**
     * Создаем экземпляр Retrofit
     * @param baseUrl базовый адрес
     * @param client клиент
     * @return экземпляр Retrofit
     */
    private fun buildRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(defaultConverter())
            .addCallAdapterFactory(defaultCallAdapter())
            .client(client)
            .baseUrl(baseUrl)
            .build()
    }

    /**
     * Логирование
     * @return интерсептор логирования
     */
    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = DefaultSettings.HTTP_LOG_LEVEL
        }
    }

    /**
     * REST
     * @return инстанс REST клиента
     */
    @Provides
    @Singleton
    fun providesCloudAPI(): CloudAPI {
        //Настройки подключения
        val okHttpClient = OkHttpClient.Builder()
            .connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT))
            .connectTimeout(DefaultSettings.NETWORK_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DefaultSettings.NETWORK_READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
            .build()

        //Создаем ретрофит
        val retrofit = buildRetrofit(DefaultSettings.ROOT_URL, okHttpClient)

        //Возвращаем экземпляр
        return retrofit.create(CloudAPI::class.java)
    }
}