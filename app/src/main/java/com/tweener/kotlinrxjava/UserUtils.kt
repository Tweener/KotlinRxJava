package com.tweener.kotlinrxjava

import com.tweener.kotlinrxjava.model.User
import io.realm.Realm

/**
 * @author Tweener
 */
fun persistUser(user: User) {
    val realm: Realm = Realm.getDefaultInstance()
    realm.beginTransaction()
    realm.copyToRealmOrUpdate(user)
    realm.commitTransaction()
}