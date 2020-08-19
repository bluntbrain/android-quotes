package com.ishanlakhwani.mvvmquotesapp

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.ishanlakhwani.mvvmapp.data.preferences.PreferenceProvider
import com.ishanlakhwani.mvvmquotesapp.data.db.AppDatabase
import com.ishanlakhwani.mvvmquotesapp.data.network.MyApi
import com.ishanlakhwani.mvvmquotesapp.data.network.NetworkConnectionInterceptor
import com.ishanlakhwani.mvvmquotesapp.data.repositories.QuotesRepository
import com.ishanlakhwani.mvvmquotesapp.data.repositories.UserRepository
import com.ishanlakhwani.mvvmquotesapp.ui.auth.AuthViewModelFactory
import com.ishanlakhwani.mvvmquotesapp.ui.home.profile.ProfileViewModelFactory
import com.ishanlakhwani.mvvmquotesapp.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware{
    @RequiresApi(Build.VERSION_CODES.O)
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }


}