package com.example.tatsulokpos.components.header.data

import com.example.tatsulokpos.components.header.model.Account

object AccountDao {
    private val acounts = mutableListOf<Account>(
        Account(
            id = 1,
            firstName = "Nikko",
            lastName = "Roque",
            email = "nroque@tatsulok.com",
            password = "password"
        )
    )

    fun getAccount(): Account {
        return acounts[0]
    }
}