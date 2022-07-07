package com.example.movies.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
public open class CoroutineTestExtension constructor(
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