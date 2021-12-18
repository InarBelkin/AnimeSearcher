package com.example.animesearcher

import androidx.constraintlayout.utils.widget.MockView
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.animesearcher.data.database.IDbRepos
import com.example.animesearcher.data.net.ISearchRepository
import com.example.animesearcher.ui.list.ListViewModel
import com.example.animesearcher.ui.single.SingleAnimeViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.mockito.Mockito

/**1
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
       // assertEquals("com.example.animesearcher", appContext.packageName)
        val viewModel = SingleAnimeViewModel();
        val result = viewModel.getNumber();
        assertEquals(3,result);
    }


//    @Test
//    fun SearchTest(){
//        val a = Mockito.mock(ISearchRepository::class.java);
//        val b = Mockito.mock(IDbRepos::class.java);
//        val viewModel = ListViewModel(a,b);
//
////        val result = viewModel.getNumber();
//        assertEquals(3,result);
//    }
    @Test
    fun myTest() {
        assertEquals(true, true);
    }

}