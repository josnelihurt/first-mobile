package com.josnelihurt.home.login.domain.usecases

import com.josnelihurt.home.login.domain.entities.LoginEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

const val MOCK_LOGIN_DELAY = 2000L

class LoginUseCase @Inject constructor() {
    suspend operator fun invoke(loginEntity: LoginEntity) {
        delay(timeMillis = MOCK_LOGIN_DELAY)
    }
}
