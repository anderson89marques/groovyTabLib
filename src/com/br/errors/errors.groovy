package com.br.errors

/**
 * Created by anderson on 17/12/16.
 */

class InvalidDimensions extends Exception {
    InvalidDimensions(){
        super()
    }

    InvalidDimensions(text){
        super(text)
    }
}

