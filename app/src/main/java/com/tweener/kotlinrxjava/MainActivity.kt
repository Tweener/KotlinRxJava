package com.tweener.kotlinrxjava

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.tweener.kotlinrxjava.api.GithubService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GithubService.create().getUser("tweener")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            user ->
                            persistUser(user)

                            Log.i("MainActivity", "user: " + user.name)
                            Log.i("MainActivity", "repos: " + user.publicRepos)
                        },
                        {
                            error ->
                            Log.e("MainActivity", "error: " + error.message)
                        })
    }
}
