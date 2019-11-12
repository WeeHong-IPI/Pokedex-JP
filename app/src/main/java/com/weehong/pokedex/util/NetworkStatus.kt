package com.weehong.pokedex.util

import com.weehong.pokedex.model.Network

class NetworkStatus {
    companion object {
        fun <T> success(data: T): Network<T> {
            return Network(
                Network.Status.SUCCESS,
                data,
                null)
        }

        fun <T> error(message: String, data: T? = null): Network<T> {
            return Network(
                Network.Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading(data: T? = null): Network<T> {
            return Network(
                Network.Status.LOADING,
                data,
                null
            )
        }
    }
}