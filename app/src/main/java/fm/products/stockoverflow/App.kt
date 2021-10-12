package fm.products.stockoverflow

import android.app.Application
import fm.products.stockoverflow.di.repositoriesModule
import fm.products.stockoverflow.di.singletonsModule
import fm.products.stockoverflow.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(singletonsModule, repositoriesModule, viewModelsModule))
        }
    }
}