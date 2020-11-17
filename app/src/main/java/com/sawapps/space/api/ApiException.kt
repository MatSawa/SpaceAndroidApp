package com.sawapps.space.api

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
sealed class ApiException(message: String) : Exception(message) {
    class NoInternetConnectionException : ApiException("")
    class NotRespondingException : ApiException("")
    class ParseException(message: String) : ApiException(message)
}