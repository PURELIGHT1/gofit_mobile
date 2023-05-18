package com.example.gofit.retrofit

import com.example.gofit.retrofit.booking.ResponseSlot
import com.example.gofit.retrofit.booking.gym.BookingGymRequest
import com.example.gofit.retrofit.booking.gym.ResponseBooking
import com.example.gofit.retrofit.booking.gym.riwayat.ResponseDataRiwayat
import com.example.gofit.retrofit.booking.gym.riwayat.ResponseRiwayat
import com.example.gofit.retrofit.login.ResponseLogin
import com.example.gofit.retrofit.login.UserRequest
import com.example.gofit.retrofit.profile.PasswordRequest
import com.example.gofit.retrofit.profile.ResponseDataInstruktur
import com.example.gofit.retrofit.izin.IzinRequest
import com.example.gofit.retrofit.izin.ResponseCreateIzin
import com.example.gofit.retrofit.izin.ResponseDataIzinInstruktur
import com.example.gofit.retrofit.jadwal.ResponseDataJadwalHarian
import com.example.gofit.retrofit.kelas.ResponseDataKelas
import com.example.gofit.retrofit.profile.ResponseDataMember
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import java.time.LocalDate

interface api {
    @POST("login")
    fun login(
        @Body userRequest: UserRequest
    ): Call<ResponseLogin>

    //instruktur
    @GET("api/instrukturs/{id}")
    fun getInstrukturById(
        @Path("id") id: String? = null
    ): Call<ResponseDataInstruktur>

    @GET("api/presensi_instruktur/{id}")
    fun getIzinInstruktur(
        @Path("id") id: String? = null
    ): Call<ResponseDataIzinInstruktur>

    @POST("api/presensi_instruktur")
    fun addIzin(
        @Body izinRequest: IzinRequest
    ): Call<ResponseCreateIzin>

    @PUT("api/instrukturs/edit-password/{id}")
    fun updatePasswordInstruktur(
        @Path("id") id: String? = null,
        @Body passwordRequest: PasswordRequest
    ): Call<ResponseUpdate>

    //member
    @GET("api/members/{id}")
    fun getMemberById(
        @Path("id") id: String? = null
    ): Call<ResponseDataMember>

    //kelas
    @GET("api/kelas")
    fun getKelas(): Call<ResponseDataKelas>

    @PUT("api/pegawais/edit-password/{id}")
    fun updatePasswordPegawai(
        @Path("id") id: String? = null,
        @Body passwordRequest: PasswordRequest
    ): Call<ResponseUpdate>

    //Jadwal
    @GET("api/jadwal_harian")
    fun getJadwalHarian(
    ): Call<ResponseDataJadwalHarian>

    //jadwal harian
    @GET("api/jadwal_harian/find_today/{cari}")
    fun getJadwalHarianByDate(
        @Path("cari") String: String? = null,
    ): Call<ResponseUpdate>

    //booking Kelas
    @PUT("api/booking_gym/{id}")
    fun addBookingKelas(
        @Path("id") id: String? = null,
    ): Call<ResponseUpdate>

    //Booking Gym
    @GET("api/jadwal_harian/{awal}")
    fun getJadwalHarian(
        @Path("awal") awal: String? = null,
    ): Call<ResponseUpdate>

    // riwayat booking
    @GET("api/booking_gym/find/{id}/{cari}")
    fun getRiwayatBook(
        @Path("id") id: String? = null,
        @Path("cari") String: String? = null,
    ): Call<ResponseRiwayat>

    @GET("api/booking_gym/cari/{id}")
    fun getRiwayatById(
        @Path("id") id: String? = null,
    ): Call<ResponseDataRiwayat>

    @PUT("api/booking_gym/{id}")
    fun addBookingGym(
        @Path("id") id: String? = null,
        @Body bookingGymReqest: BookingGymRequest
    ): Call<ResponseBooking>

    @DELETE("api/booking_gym/{id}")
    fun deleteRiwayatById(
        @Path("id") id: String? = null,
    ): Call<ResponseDelete>

    @GET("api/booking_gym/slot/{tgl}/{sesi}")
    fun getSlot(
        @Path("tgl") tgl: String? = null,
        @Path("sesi") sesi: Int? = null,
    ): Call<ResponseSlot>

    // MO
    @GET("api/pegawais/{id}")
    fun getPegawaiById(
        @Path("id") id: String? = null
    ): Call<ResponseDataMember>

    @PUT("api/pegawais/edit-password/{id}")
    fun updatePasswordMo(
        @Path("id") id: String? = null,
        @Body passwordRequest: PasswordRequest
    ): Call<ResponseUpdate>

}
