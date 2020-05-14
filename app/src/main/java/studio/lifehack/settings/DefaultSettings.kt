package studio.lifehack.settings

import okhttp3.logging.HttpLoggingInterceptor

object DefaultSettings {

    /**
     * Адрес сервера
     */
    const val ROOT_URL = "http://megakohz.bget.ru/test_task/"

    /**
     * Время подключения
     */
    const val NETWORK_CONNECT_TIMEOUT: Long = 20 * 1000

    /**
     * Время чтения пакета
     */
    const val NETWORK_READ_TIMEOUT: Long = 20 * 1000

    /**
     * Уровень логирования запросов
     */
    val HTTP_LOG_LEVEL = HttpLoggingInterceptor.Level.BODY

    /**
     * Имя экстры
     */
    const val ID_EXTRA_NAME = "ID_EXTRA_NAME"
}