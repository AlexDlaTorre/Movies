package com.example.movies.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
public class CoroutineTestExtensionWithMockDispatchers(
    private val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : CoroutineTestExtension(testDispatcher) {
    override fun afterEach(context: ExtensionContext?) {
        super.beforeEach(context)
        mockkStatic(Dispatchers::class)
        every { Dispatchers.IO } returns testDispatcher
        every { Dispatchers.Default } returns testDispatcher
        every { Dispatchers.Unconfined } returns testDispatcher
    }

    override fun beforeEach(context: ExtensionContext?) {
        super.afterEach(context)
        unmockkStatic(Dispatchers::class)
    }
}