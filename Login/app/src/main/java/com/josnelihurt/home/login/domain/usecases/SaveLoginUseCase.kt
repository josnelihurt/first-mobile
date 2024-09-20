package com.josnelihurt.home.login.domain.usecases

import com.josnelihurt.home.login.domain.entities.LoginEntity
import com.josnelihurt.home.login.domain.repositories.LoginRepository
import javax.inject.Inject

class SaveLoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    operator fun invoke(loginEntity: LoginEntity) {
        repository.save(loginEntity.copyToSave())
    }
}
