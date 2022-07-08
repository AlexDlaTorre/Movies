package com.example.movies.extensions

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.jupiter.api.extension.ExtensionContext


@ExperimentalCoroutinesApi
class CoroutineTestExtensionWithMockDispatchers(
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