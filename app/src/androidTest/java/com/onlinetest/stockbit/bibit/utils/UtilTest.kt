package com.onlinetest.stockbit.bibit.utils

import org.junit.Assert
import org.junit.Test

class UtilTest {

    @Test
    fun printDecimalFormat(){
        val value = 0.24489
        Assert.assertEquals("0,245", Utils.printDecimalFormat(value))
    }
}