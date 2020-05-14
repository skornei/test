package studio.lifehack.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import studio.lifehack.network.entity.CompanyEntity

interface CloudAPI {

    /**
     * Получаем список компаний
     * @return список компаний
     */
    @GET("test.php")
    @Headers(
        "Accept: application/json"
    )
    fun getCompanyList(): List<CompanyEntity>

    /**
     * Получаем информацию о компании
     * @param id идентификатор компании
     * @return иформация о компании
     */
    @GET("test.php")
    @Headers(
        "Accept: application/json"
    )
    fun getCompany(@Query("id") id: String): List<CompanyEntity>
}