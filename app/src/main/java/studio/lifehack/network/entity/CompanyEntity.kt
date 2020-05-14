package studio.lifehack.network.entity

import studio.lifehack.network.BaseNetworkEntity

class CompanyEntity: BaseNetworkEntity() {

    /**
     * Идентификатор
     */
    var id: String? = null

    /**
     * Название
     */
    var name: String? = null

    /**
     * Изображение
     */
    var img: String? = null

    /**
     * Описание
     */
    var description: String? = null

    /**
     * Широта
     */
    var lat: Double? = null

    /**
     * Долгота
     */
    var lon: Double? = null

    /**
     * Сайт
     */
    var www: String? = null

    /**
     * Телефон
     */
    var phone: String? = null
}