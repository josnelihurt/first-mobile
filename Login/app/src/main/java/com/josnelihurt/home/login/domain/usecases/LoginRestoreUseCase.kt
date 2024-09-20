package com.josnelihurt.home.login.domain.usecases

import com.josnelihurt.home.login.domain.entities.LoginEntity
import com.josnelihurt.home.login.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginRestoreUseCase @Inject constructor(
    private val repository: LoginRepository
){
    operator fun invoke(): LoginEntity {
        return repository.get()
    }
}
