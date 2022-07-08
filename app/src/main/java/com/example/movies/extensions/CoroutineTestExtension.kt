package com.example.movies.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext


@ExperimentalCoroutinesApi
open class CoroutineTestExtension constructor(
    private val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : AfterEachCallback, BeforeEachCallback {
    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}