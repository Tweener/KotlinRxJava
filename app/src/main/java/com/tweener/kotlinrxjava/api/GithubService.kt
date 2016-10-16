package com.tweener.kotlinrxjava.api

import com.google.gson.Gson
import com.tweener.kotlinrxjava.model.User
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

/**
 * @author Tweener
 */
interface GithubService {

    companion object {
        fun create(): GithubService {
            val gson = Gson()

            return Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(GithubService::class.java)
        }
    }

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Observable<User>
}