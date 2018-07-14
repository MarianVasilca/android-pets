package tech.ascendio.mvvmstarter.utilities.schedulers

import io.reactivex.Scheduler

typealias ExecutionBlock = () -> Unit

interface Scheduler {
    fun asRxScheduler(): Scheduler

    fun runOnThread(runnable: ExecutionBlock)
}