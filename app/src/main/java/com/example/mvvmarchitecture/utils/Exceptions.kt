package com.example.mvvmarchitecture.utils

import java.io.IOException

class Exceptions {
    class ApiException(message: String) : IOException(message)
}